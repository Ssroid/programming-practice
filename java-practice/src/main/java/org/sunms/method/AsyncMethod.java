package org.sunms.method;

import java.util.concurrent.Callable;

public class AsyncMethod {

    Callable callable;

    public AsyncMethod(Callable callable) {
        this.callable = callable;
    }



}
