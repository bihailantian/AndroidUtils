package com.xxm.androidutils.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xxm.androidutils.R;
import com.xxm.androidutils.utils.AppUtils;

/**
 * 跟App相关的辅助类 测试
 */
public class AppUtilsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_utils);

        Button btnAppInfo = findViewById(R.id.btn_app_info);
        final TextView tvName = findViewById(R.id.tv_name);
        final TextView tvVersionName = findViewById(R.id.tv_version_name);


        btnAppInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvName.setText("应用程序名称:" + AppUtils.getAppName(AppUtilsActivity.this));
                tvVersionName.setText("版本名称:" + AppUtils.getVersionName(AppUtilsActivity.this));
            }
        });

    }
}
