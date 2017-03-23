package com.tju.daggerDemo.ui;

import android.os.Bundle;

/**
 * Created by rakshith on 19/03/17.
 */

public class BaseContract {
    public interface View {

    }

    public interface Presenter {

        void saveUIState(Bundle outState);

        void restoreUIState(Bundle savedInstanceState);

        void registerForEvents();

        void unregisterForEvents();
    }
}
