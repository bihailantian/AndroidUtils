package com.xxm.androidutils.domain;


public class Item {

    private String title;
    private String msg;

    public Item(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
