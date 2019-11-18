package com.example.chapter_5;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

public class TestActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "TestActivity";

    private Button mButton1;
    private View mButton2;

    private static int sId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView(){
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (TextView) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View v){
        if (v == mButton1){
            sId ++;
            Notification noification = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("hello world")
                    .setSmallIcon(R.drawable.ic_launcher)
                    .build();
//            noification.icon = R.drawable.ic_launcher;
//            noification.tickerText = "hello world";
//            noification.when = System.currentTimeMillis();
            noification.flags = Notification.FLAG_AUTO_CANCEL;
            Intent intent = new Intent(this, DemoActivity_2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(sId, noification);
        }else if (v == mButton2){
            sId ++;
            Notification noification = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("hello world")
                    .setSmallIcon(R.drawable.ic_launcher)
                    .build();
//            Notification noification = new Notification();
//            noification.icon = R.drawable.ic_launcher;
//            noification.tickerText = "hello world";
//            noification.when = System.currentTimeMillis();
            noification.flags = Notification.FLAG_AUTO_CANCEL;
            Intent intent = new Intent(this, DemoActivity_1.class);
            intent.putExtra("sid", "" + sId);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            System.out.println(pendingIntent);
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);
            remoteViews.setTextViewText(R.id.msg, "chapter_5" + sId);
            remoteViews.setImageViewResource(R.id.icon, R.drawable.icon1);
            PendingIntent openActivity2PendingIntent = PendingIntent.getActivity(this,
                    0, new Intent(this, DemoActivity_2.class), PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.open_activity2, openActivity2PendingIntent);
            noification.contentView = remoteViews;
            noification.contentIntent = pendingIntent;
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(sId, noification);
        }
    }
}
