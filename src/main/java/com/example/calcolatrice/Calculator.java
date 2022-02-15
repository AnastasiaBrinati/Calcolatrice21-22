package com.example.calcolatrice;

public class Calculator {

    private static Calculator instance = null;

    private Calculator(){
        //costruttore
    }

    public static synchronized Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public float sum(float a, float b){
        return a+b;
    }

    public float sub(float a, float b){
        return a-b;
    }

    public float mul(float a, float b){
        return a*b;
    }

    public float div(float a, float b){
        if(b == 0){
            return 0;
        }
        return a/b;
    }
}
