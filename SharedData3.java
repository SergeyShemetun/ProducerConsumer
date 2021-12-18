package com.ff;

public class SharedData3 implements Sharable
{
    private final int BUF = 5;
    private int[] sharedInt = new int[BUF];
    private boolean writeOK = true;
    private boolean readOK = false;
    private int readLoc = 0, writeLoc = 0;
    public synchronized void setSharedData(int val){
        while ( !writeOK ) {
            try { wait(); }
            catch ( InterruptedException e ) { } }
        sharedInt[ writeLoc ] = val;
        readOK = true;
        writeLoc = ++writeLoc % BUF;
        if ( writeLoc == readLoc )
            writeOK = false;
        notify(); }
    public synchronized int getSharedData() {
        int val;
        while ( !readOK ) {
            try { wait(); }
            catch ( InterruptedException e ) { } }
        writeOK = true;
        val = sharedInt[ readLoc ];
        readLoc = ++readLoc % BUF;
        if ( readLoc == writeLoc )
            readOK = false;
        notify();
        return val; }
}