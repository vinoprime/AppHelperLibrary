package com.vinmacro.apphelperlibrary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;

import java.io.File;

public class AppHelperModule {

    private String TAG = "AppHelperModule";

//    private static AppHelperModule appHelperModule;

    private Activity activity;

//    private AppHelperModule(Activity activity) {
//        this.activity = activity;
//    }

//    public static AppHelperModule getInstance(Activity a) {
//        if (appHelperModule == null) appHelperModule = new AppHelperModule(a);
//        return appHelperModule;
//    }

    public AppHelperModule(Activity activity) {
        this.activity = activity;
    }

    public void installAPK(File apkFile) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }


    public void uninstallAPK(String apkPackageName) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + apkPackageName));
        activity.startActivity(intent);
    }


    public void openStorageSettings() {
        Intent i = new Intent(Settings.ACTION_MEMORY_CARD_SETTINGS);
        activity.startActivity(i);
    }

    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, 0);
    }
}
