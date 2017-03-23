package com.laojiang.utilslibrary.weight.finalhttp;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RemoteViews;

import com.laojiang.utilslibrary.uitls.systemsetting.FilesUtils;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import net.tsz.afinal.http.HttpHandler;

import java.io.File;


/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/17 14:46.
 */

public abstract class BaseFinalFiles {
    public  static final String TAG = "自定义文件下载";
    public Context   mActivity;
    public  ProgressBar mProgress;
    public  boolean cancelUpdate;
    public  AlertDialog mDownloadDialog;
    public  String strPath;
    public  String outPath;
    public  int rateNum;
    public  DownFileCallBack callBack;
    public PushFileCallBack pushFileCallBack;
    public FinalHttp finalHttp;
    public HttpHandler<File> handlerDown;
    public  PendingIntent pendingIntent;
    public  NotificationManager systemService;
    public  NotificationCompat.Builder builder;
    public  int countNum;
    public  Class clazzs;
    public  boolean isSuccess =false;
    public   int downFileNum;
    public  boolean isRemote = true;
    public  RemoteViews contentViews;
    public AjaxParams params;
    public void downloadFile(){

        finalHttp = new FinalHttp();
        //中文转utf-8
        strPath = strPath.replace(FilesUtils.getFileName(strPath), Uri.encode(FilesUtils.getFileName(strPath)));
        //                super.onLoading(count, current);
        handlerDown = finalHttp.download(strPath, outPath, new AjaxCallBack<File>() {
            @Override
            public void onLoading(long count, long current) {
//                super.onLoading(count, current);
                int progress = (int) (current * 1.0f / count * 100);
                init(progress);
                if (mProgress!=null)
                    mProgress.setMax((int) count);
                rateNum = (int) current;
                countNum = (int)count;
            }

            @Override
            public void onStart() {
                super.onStart();

            }
            @Override
            public void onSuccess(File file) {
                super.onSuccess(file);
                initSuccess();
                isSuccess = true;
                Log.d(TAG, "下载成功-==");
                if (mDownloadDialog!=null)
                    mDownloadDialog.dismiss();
                callBack.onSuccess(file);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                Log.i(TAG, "下载失败-==" + strMsg);
                if (mDownloadDialog!=null)
                    mDownloadDialog.dismiss();
                callBack.onFailure(strMsg);

            }
        });
    }
public void pushFiles(){
    FinalHttp pushFinal = new FinalHttp();
    Log.i("测试上传==",strPath.toString()+"\n"+params.toString());
    pushFinal.post(strPath, params, new AjaxCallBack<PushFileBean>() {
        @Override
        public void onLoading(long count, long current) {
            super.onLoading(count, current);

            int progress = (int) (current * 1.0f / count * 100);
            init(progress);
        }

        @Override
        public void onSuccess(PushFileBean pushFileBean) {
            super.onSuccess(pushFileBean);
            initSuccess();
            pushFileCallBack.onSuccess(pushFileBean);
        }

        @Override
        public void onFailure(Throwable t, int errorNo, String strMsg) {
            super.onFailure(t, errorNo, strMsg);
            pushFileCallBack.onFailure(strMsg);
        }
    });

}
    protected abstract void initSuccess();

    protected abstract void init(int progress);
}
