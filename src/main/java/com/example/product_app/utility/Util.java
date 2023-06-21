package com.example.product_app.utility;

public final class Util
{
    private Util(){}

    public static void showGeneralException(Exception exception){
        String message = Util.createGeneralExceptionInfo(exception);
        System.err.println(message);
    }
    public static String createGeneralExceptionInfo(Exception exception){
        String message = exception.getClass().getSimpleName() + " has ben accured. Exception message: " + exception.getMessage();
        return message;
    }

}