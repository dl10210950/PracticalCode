package com.duanlian.practicalcode.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by duanlian on 2018/1/10.
 * Description :发送一条notification
 */

public class NotificationUtil {
    /**
     * 初始化notification
     *
     * @param context  上下文
     * @param ticker   设置的是通知时在状态栏显示的通知内容，
     *                 一般是一段文字，例如在状态栏显示“您有一条短信，待查收”。
     * @param title    标题
     *                 设置的是收到通知后你将状态栏下拉后，显示的通知的具体内容的标题。
     * @param icon     设置通知小ICON
     * @param summary  内容概要
     * @param activity 跳转到的activity
     */
    public static void createNotification(Context context, String title, String ticker, String summary, int icon, Class activity) {

        NotificationManager mNotificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

        mBuilder.setContentTitle(title)//设置通知栏标题
                    .setContentText(summary) //<span style="font-family: Arial;">/设置通知栏显示内容</span>
                    .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL, context, activity)) //设置通知栏点击跳转到哪里
                    //.setNumber(number) //设置通知集合的数量 Context.getDefalutIntent(Notification.FLAG_AUTO_CANCEL)
                    .setTicker(ticker) //通知首次出现在通知栏，带上升动画效果的那段文字
                    .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                    .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                    .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                    .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                    //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                    .setSmallIcon(icon);//设置通知小ICON
        Notification notify = mBuilder.build();
        notify.flags = Notification.FLAG_SHOW_LIGHTS;
        notify.ledARGB = 0xff0000ff;
        notify.ledOnMS = 300;
        notify.ledOffMS = 300;
        mNotificationManager.notify(1, mBuilder.build());

    }

    private static PendingIntent getDefaultIntent(int flags, Context context, Class activity) {
        //跳转到消息页面
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, new Intent(context, activity), flags);
        return pendingIntent;
    }
}
