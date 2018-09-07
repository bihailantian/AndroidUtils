package com.xxm.androidutils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Fragment 基类
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;
    public View mRootView;
    public RelativeLayout loadingView;

    public BaseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = initView(inflater, savedInstanceState);
        return mRootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
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
     * 初始化数据
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    protected abstract void initData(Bundle savedInstanceState);


    /**
     * 初始化view
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null
     */
    protected abstract View initView(LayoutInflater inflater, Bundle savedInstanceState);


    /**
     * 获取rootView
     *
     * @return rootView
     */
    public View getmRootView() {
        return mRootView;
    }
}
