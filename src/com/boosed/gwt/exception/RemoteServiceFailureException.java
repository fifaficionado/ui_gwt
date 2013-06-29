package com.boosed.gwt.exception;

public class RemoteServiceFailureException extends Exception {

    public RemoteServiceFailureException() {
    // default no-arg constructor
    }

    public RemoteServiceFailureException(Throwable throwable) {
        super(throwable);
    }
}
