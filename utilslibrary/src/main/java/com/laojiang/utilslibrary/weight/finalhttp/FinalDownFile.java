package com.laojiang.utilslibrary.weight.finalhttp;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.laojiang.utilslibrary.R;
import com.laojiang.utilslibrary.uitls.PreferenceUtils;
import com.laojiang.utilslibrary.uitls.systemsetting.FilesUtils;


/**
 * 类介绍（必填）：自定义文件下载附带progressbar
 * Created by Jiang on 2017/1/6 14:24.
 */

public class FinalDownFile extends BaseFinalFiles{


    private static final String DOWNNUM = "down_num";

    public FinalDownFile(Class clazzs, Context context, String strPath, String outPath, DownFileCallBack callBack) {
        super.clazzs = clazzs;
        super.mActivity = context;
        super.strPath = strPath;
        super.outPath = outPath;
        super.callBack = callBack;
        initProgress(clazzs);
        downFileNum = PreferenceUtils.getPrefInt(mActivity, DOWNNUM, 0);
        downFileNum = downFileNum +1;
    }

    @Override
    protected void initSuccess() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                builder.setContentText("下载完成")
                        .setProgress(0, 0, false);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                systemService.notify(downFileNum, builder.build());
            }
        }).start();
        PreferenceUtils.setPrefInt(mActivity,DOWNNUM,0);
    }

    @Override
    protected void init(final int progress) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                builder.setProgress(100, progress, false);
                systemService.notify(downFileNum, builder.build());
            }
        }).start();
    }



    public void showDownloadDialog() {
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.soft_updating);
        // 给下载对话框增加进度条
        final LayoutInflater inflater = LayoutInflater.from(mActivity);
        View v = inflater.inflate(R.layout.dialog_softupdate_progress, null);
        mProgress = (ProgressBar) v.findViewById(R.id.update_progress);

        builder.setView(v);
        // 取消下载
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
               if (handlerDown!=null)
                   handlerDown.stop();

            }
        });
        mDownloadDialog = builder.create();
        mDownloadDialog.setCanceledOnTouchOutside(false);
        mDownloadDialog.show();

        // 下载文件
        downloadFile();
    }


    private void initProgress(final Class clazz) {
//        //自定义显示布局
//        contentViews = new RemoteViews(mActivity.getPackageName(), R.layout.custom_notification);
//        //通过控件的Id设置属性
//        contentViews.setImageViewResource(R.id.iv_icon_img, R.drawable.ic_launcher);
//        contentViews.setTextViewText(R.id.tv_title, "下载文件");
//        contentViews.setTextViewText(R.id.tv_content, FilesUtils.getFileName(strPath));
//
//        contentViews.setTextViewText(R.id.tv_cancel,"取消");

                    Intent intents = new Intent(mActivity,clazz);
                    pendingIntent = PendingIntent.getActivities(mActivity,downFileNum,new Intent[]{intents},PendingIntent.FLAG_UPDATE_CURRENT);
                    systemService = (NotificationManager) mActivity.getSystemService(Context.NOTIFICATION_SERVICE);
                    builder = new NotificationCompat.Builder(mActivity);
                    builder.setContentTitle("下载文件");
                    builder.setContentText(FilesUtils.getFileName(strPath));
                    builder.setSmallIcon(R.mipmap.ico_add_img);
                    builder.setPriority(NotificationCompat.PRIORITY_MAX);
                    builder.setContentIntent(pendingIntent);
                    builder.setAutoCancel(true);


        PreferenceUtils.setPrefInt(mActivity,DOWNNUM,downFileNum);
                downloadFile();





    }
}
