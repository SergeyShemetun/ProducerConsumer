package com.ff;

public class Consumer extends Thread
{
    private Sharable data;
    private int count;
    private int id;
    public Consumer(int id, Sharable d, int count)
    {
        data = d;
        this.count = count;
        this.id = id;
    }
    public void run()
    {
        int local = -1;;
        for (int i = 1 ; i <= count ; i++) {
            try {
                sleep((int)(Math.random() * 100));
                local = data.getSharedData();
            }
            catch (InterruptedException e) { }
            System.out.println("\t\t\t\t\t\t\t\tConsumer [" + id + "] used " + local);
        }
    }
}