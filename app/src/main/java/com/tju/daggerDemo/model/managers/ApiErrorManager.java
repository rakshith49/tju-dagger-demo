package com.tju.daggerDemo.model.managers;


import com.squareup.otto.Bus;
import com.tju.daggerDemo.model.exceptions.HttpException;

import java.net.SocketTimeoutException;

/**
 * Created by rakshith on 23/03/17.
 */

public class ApiErrorManager {

    public static String TAG = "ApiErrorManager";
    private final Bus bus;

    public ApiErrorManager(Bus bus) {
        this.bus = bus;
    }

    public void handleError(Throwable e) {

        //Sample error Handling
        Throwable cause = e.getCause();
        if (cause instanceof HttpException) {
            handleHTTPException((HttpException) cause);
            return;
        }
        if (e instanceof SocketTimeoutException) {
            handleSocketTimeoutException();
            return;
        }
        handleGenericError();
    }

    private void handleGenericError() {

        //Todo:Handle Generic Errors
    }

    private void handleSocketTimeoutException() {
        //Todo:Handle handleSocketTimeoutException
    }

    private void handleHTTPException(HttpException cause) {
        //Todo:Handle handleHTTPException
    }


}
