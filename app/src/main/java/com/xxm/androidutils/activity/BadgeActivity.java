package com.xxm.androidutils.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.xxm.androidutils.R;

public class BadgeActivity extends AppCompatActivity {

    private ImageView ivBadge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);
        ivBadge = findViewById(R.id.iv_badge);


    }
}
