package com.xxm.androidutils.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.xxm.androidutils.R;
import com.xxm.androidutils.utils.KeyBoardUtils;

public class KeyBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edKeyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board);

        edKeyBoard = findViewById(R.id.ed_key_board);
        edKeyBoard.setOnClickListener(this);
        edKeyBoard.setHint("软件盘关闭");

    }

    //软键盘是否打开
    boolean isOpen = true;

    @Override
    public void onClick(View v) {
        if (isOpen) {
            KeyBoardUtils.closeKeybord(edKeyBoard, this);
            edKeyBoard.setHint("软件盘关闭");
        } else {
            KeyBoardUtils.openKeybord(edKeyBoard, this);
            edKeyBoard.setHint("软件盘打开");
        }
        isOpen = !isOpen;

    }
}
