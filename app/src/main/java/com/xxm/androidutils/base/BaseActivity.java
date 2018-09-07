package com.xxm.androidutils.base;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xxm.androidutils.R;

import java.util.LinkedList;
import java.util.List;


/**
 * activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 管理运行的所有的activity
     **/
    public final static List<BaseActivity> mActivities = new LinkedList<>();
    public BaseActivity mActivity;
    private long firstClickBack;
    public RelativeLayout loadingView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar  即隐藏标题栏
        beforeSetContentView(savedInstanceState);
        setContentView(getContentViewId());
        //ButterKnife.bind(this);


       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏*/

        mActivity = this;

        //的作用
        synchronized (mActivities) {
            mActivities.add(this);
        }

        initView();
        initData();
    }


    /**
     * 设置布局文件之前且在 super.onCreate(savedInstanceState);之后
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState. Note: Otherwise it is null.
     */
    protected void beforeSetContentView(Bundle savedInstanceState) {

    }


    /**
     * 关闭所有已打开的activity
     */
    protected void killAllActivities() {
        // 复制了一份mActivities 集合
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
        //android.os.Process.killProcess(android.os.Process.myPid());
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //返回键二次点击退出
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mActivities.size() == 1) {
                long secondClickBack = System.currentTimeMillis();
                if (secondClickBack - firstClickBack > 1500) {
                    Toast.makeText(this, R.string.one_more_exit, Toast.LENGTH_SHORT).show();
                    firstClickBack = secondClickBack;
                    return true;
                } else {
                    killAllActivities();
                    return true;
                }

            }
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * activity跳转
     *
     * @param clazz activity的class
     */
    protected void actIntent(Class clazz) {
        Intent intent = new Intent(mActivity, clazz);
        startActivity(intent);
    }

    /**
     * activity带参数跳转
     *
     * @param clazz activity的class
     */
    protected void actIntent(Class clazz, String name, Parcelable value) {
        Intent intent = new Intent(mActivity, clazz);
        intent.putExtra(name, value);
        startActivity(intent);
    }

    /**
     * 注销
     */
    protected void exitApp() {
        cancelAllNotification();
        killAllActivities();
        //actIntent(LoginActivity.class);
    }

    /**
     * 取消所有的通知
     */
    private void cancelAllNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.cancelAll();
        }
    }


    /**
     * 显示 loadingView
     */
    protected void showLoadingView() {
        if (loadingView != null) {
            loadingView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 取消 loadingView
     */
    protected void dismissLoadingView() {
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
    }

    /**
     * 在父类获取子类的类名
     *
     * @return 子类的类名
     */
    protected String getClassName() {
        return getClass().getSimpleName();
    }


    /**
     * 布局文件ID
     **/
    protected abstract int getContentViewId();


    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 初始化View
     */
    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }

    }


}
