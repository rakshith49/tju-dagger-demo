package com.tju.daggerDemo.utils;

import com.tju.daggerDemo.BuildConfig;

/**
 * Created by rakshith on 22/03/17.
 */

public class SeriesBuildTypeConfig {

    public static boolean isDebug() {
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            return true;
        }
        return false;
    }
}
