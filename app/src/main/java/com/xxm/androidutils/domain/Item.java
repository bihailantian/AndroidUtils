package com.xxm.androidutils.domain;


public class Item {

    private String title;
    private String msg;
    private Class clazz;

    public Item(String title, String msg,Class clazz) {
        this.title = title;
        this.msg = msg;
        this.clazz = clazz;
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

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
