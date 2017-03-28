# MyUtilsLibrary
工具库
# 图片选择器
> 在AndroidManifet.xml中添加
```
<!--//多选相册-->
        <activity
            android:name="cc.dagger.photopicker.MultiImageSelectorActivity"
            android:screenOrientation="portrait"
            android:theme="@style/NO_ACTIONBAR" />

        <activity
            android:name="cc.dagger.photopicker.PhotoPreviewActivity"
            android:screenOrientation="portrait"
            android:theme="@style/NO_ACTIONBAR"/>
```
> 添加主题类型：
```
<style name="NO_ACTIONBAR" parent="Theme.AppCompat.Light.NoActionBar"/>
```
> 在超类activity中添加
```
@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ImagePickerUtils.REQUEST_STORAGE_READ_ACCESS_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
```
最后在活动中调用
```
switch (requestCode) {
            case PhotoPicker.REQUEST_SELECTED:
                if (data != null) {
                    photos = data.getStringArrayListExtra(PhotoPicker.EXTRA_RESULT);
                }

                if (photos != null) {
              
                }
                break;
        }
```
**photos是照片集合 类型为String
