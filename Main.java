package com.ff;

public class Main {

    private static final int COUNT = 10;
    public static void main(String[] s)
    {
        Sharable data = new SharedData3();
        Producer p = new Producer(1,data,COUNT, 1);
        Consumer c = new Consumer(1,data,COUNT);
        p.start();
        c.start();
    }
}

