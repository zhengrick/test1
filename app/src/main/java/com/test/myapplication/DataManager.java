package com.test.myapplication;

import android.database.Observable;
import android.widget.Toast;

import org.reactivestreams.Subscriber;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

public class DataManager {

    public void postComment() {
        Observable.create(new OnSubscribe<Comment>() {
            @Override
            public void call(Subscriber<? super Comment> subscriber) {
                Comment comment = getComment();
                subscriber.onNext(comment);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Observer<Comment>() {
            @Override
            public void onComplete() {
                Toast.makeText(activity, "Saved!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Comment comment) {
                comment.saveData();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
