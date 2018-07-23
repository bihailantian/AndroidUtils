package com.xxm.androidutils.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xxm.androidutils.R;
import com.xxm.androidutils.utils.NetUtils;

public class NetActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNetStatus, tvWifi;
//    private Button btnNetStatus, btnWifi, btnSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        tvNetStatus = findViewById(R.id.tv_net_status);
        tvWifi = findViewById(R.id.tv_wifi);
        Button btnNetStatus = findViewById(R.id.btn_net_status);
        Button btnWifi = findViewById(R.id.btn_wifi);
        Button btnSetting = findViewById(R.id.btn_setting);

        btnNetStatus.setOnClickListener(this);
        btnWifi.setOnClickListener(this);
        btnSetting.setOnClickListener(this);

        tvNetStatus.setText("是否已联网：");
        tvWifi.setText("是否是wifi联网：");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_net_status:
                tvNetStatus.setText("是否已联网：" + NetUtils.isConnected(this));
                break;

            case R.id.btn_wifi:
                tvWifi.setText("是否wifi是联网：" + NetUtils.isWifi(this));
                break;

            case R.id.btn_setting:
                NetUtils.openSetting(this);
                break;
        }
    }
}
