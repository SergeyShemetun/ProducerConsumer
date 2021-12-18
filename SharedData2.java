package com.ff;

public class SharedData2 implements Sharable
{
    private int value;
    private boolean writeOK = true;
    public synchronized void setSharedData(int n)
    {
        while ( ! writeOK ) {
            try { wait(); }
            catch (InterruptedException e) { } }
        value = n;
        writeOK = false;
        notify();
    }
    public synchronized int getSharedData()
    {
        while (writeOK) {
            try { wait(); }
            catch (InterruptedException e) { } }
        writeOK = true;
        notify();
        return value;
    }
} // SharedData2
