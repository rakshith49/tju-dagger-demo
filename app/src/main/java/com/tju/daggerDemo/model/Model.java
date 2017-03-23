package com.tju.daggerDemo.model;

import com.tju.daggerDemo.model.managers.SeriesManager;

/**
 * Created by rakshith on 19/03/17.
 */

public class Model {
    public final SeriesManager seariesManager;

    public Model(SeriesManager seariesManager) {
        this.seariesManager = seariesManager;
    }
}
