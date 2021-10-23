/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

/**
 *
 * @author debor
 */
public class MinhaThread extends Thread {
    
    private boolean sleep;
    private boolean wait;
    private long    time;

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }    
    
    public MinhaThread(String name) {
        this.setName(name);
    }
    
    @Override
    public synchronized void run() {
        for (int i = 0; i < 2000000; i++) {
            if (this.isSleep()) {
                try {
                    Thread.currentThread().getName();
                    Thread.sleep(this.getTime());
                } catch (InterruptedException ex) { }
            }
            if (this.isWait()) {
                try {     
                    this.wait();
                } catch (InterruptedException ex) { }
            }            
            System.out.println(i + " Thread " + this.getName());
        }
    }    
    
}
