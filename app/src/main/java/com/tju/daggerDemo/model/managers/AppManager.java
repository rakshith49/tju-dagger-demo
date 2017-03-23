package com.tju.daggerDemo.model.managers;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by rakshith on 22/03/17.
 */

public class AppManager {

    private final Context mContext;

    public AppManager(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Gets the application version code from the package manager
     *
     * @return if available: the application version code
     * and -1 if not available
     */
    public int getApplicationVersionCode() {
        try {
            return mContext
                    .getPackageManager()
                    .getPackageInfo(mContext.getPackageName(), 0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }
}
