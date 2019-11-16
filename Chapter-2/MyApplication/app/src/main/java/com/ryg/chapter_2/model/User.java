package com.ryg.chapter_2.model;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 25400 on 2019/11/4.
 */

public class User implements Parcelable, Serializable {

    public static final long serialVersionUID = 1L;

    public int userId;
    public String userName;
    public boolean isMale;

    public Book book;

    public User(){
    }

    public User(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    public int describeContents() {
        return 0;
    }
}
