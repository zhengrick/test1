package com.test.myapplication;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.reactivex.disposables.Disposable;

public class Comment extends Data implements Disposable {
    @Expose
    @SerializedName("data")
    private String data;
    @Expose
    @SerializedName("name")
    private String name;

    void saveData() {
        // real save
    }


    volatile boolean disposed;
    @Override public void dispose() {
        disposed = true;
    }
    @Override public boolean isDisposed() {
        return disposed;
    }
}
