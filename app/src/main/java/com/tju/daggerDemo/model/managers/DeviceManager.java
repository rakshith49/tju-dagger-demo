package com.tju.daggerDemo.model.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * Created by rakshith on 20/03/17.
 */

public class DeviceManager {

    private final Context mContext;

    public DeviceManager(Context context) {
        mContext = context;
    }

    /**
     * Returns a unique ID for this device. This is a 64-bit number (as a hex string)
     * that is randomly generated when the user first sets up the device (or factory
     * resets) and should remain constant for the lifetime of the user's device.
     */
    public String getDeviceId() {
        return Settings.Secure.getString(
                mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID
        );
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }
}
