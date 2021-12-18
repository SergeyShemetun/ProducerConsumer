package com.ff;

public class SharedData implements Sharable
{
    private int value;
    public synchronized void setSharedData(int n)
    {
        value = n;
    }
    public synchronized int getSharedData()
    {
        return value;
    }
} // SharedData