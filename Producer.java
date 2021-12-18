package com.ff;

public class Producer extends Thread
{
    private final Sharable data;
    private int count;
    private int start;
    private int id;
    public Producer(int id, Sharable d, int count, int start)
    {
        data = d;
        this.count = count;
        this.start = start;
        this.id = id;
    }
    public void run() {
        int end = count+start-1;
        for (int i = start ; i <= end ; i++)
        {
            System.out.println("Producer [" + id + "] produced " + i);
            try {
                data.setSharedData(i);
                sleep((int)(Math.random() * 100));
            }
            catch (InterruptedException e) { }
        } }
} // Producer
