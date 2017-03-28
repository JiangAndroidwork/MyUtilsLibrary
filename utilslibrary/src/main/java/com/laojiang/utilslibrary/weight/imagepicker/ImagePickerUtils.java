package com.laojiang.utilslibrary.weight.imagepicker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

import com.laojiang.utilslibrary.R;

import java.util.ArrayList;

import cc.dagger.photopicker.PhotoPicker;
import cc.dagger.photopicker.picker.Load;
import cc.dagger.photopicker.picker.PhotoFilter;
import cc.dagger.photopicker.picker.PhotoSelectBuilder;


/**
 * 类介绍（必填）：照片选择器
 * Created by Jiang on 2017/3/28 8:32.
 */

public class ImagePickerUtils {
    public  static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 110;
    private static ArrayList<String> selectedPhotos = new ArrayList<>();
    public static void getPhotoForAndroid(Context context, Activity activity,int columns ,int maxNum){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(context,activity,Manifest.permission.READ_EXTERNAL_STORAGE,
                    context.getString(R.string.permission_rationale),
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            Load load = PhotoPicker.load()
                    .showCamera(false)
                    .filter(PhotoFilter.build().showGif(false).minSize(2 * 1024))
                    .gridColumns(columns);

            PhotoSelectBuilder builder;

            if (false){
                builder = load.single();
            }else {

                builder = load.multi().maxPickSize(maxNum).selectedPaths(selectedPhotos);
            }

            builder.start(activity);
        }
    }
    private static void requestPermission(final Context context, final Activity activity, final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            new AlertDialog.Builder(activity)
                    .setTitle(R.string.permission_dialog_title)
                    .setMessage(rationale)
                    .setPositiveButton(R.string.permission_dialog_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
                        }
                    })
                    .setNegativeButton(R.string.permission_dialog_cancel, null)
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
        }
    }
}
