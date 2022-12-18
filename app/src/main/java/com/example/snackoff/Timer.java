package com.example.snackoff;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

public class Timer extends Handler {

    private static Timer timer;
    private ArrayList<TickListener> tickListenersList;

    private Timer(){
        tickListenersList = new ArrayList<>();
        sendMessageDelayed(obtainMessage(), 1000);
    }

    /**
     * To handle the time of the game
     * @param m
     */
    @Override
    public void handleMessage(Message m){

        notifyObserver();
        sendMessageDelayed(obtainMessage(), 10);
    }

    /**
     * To use getTimer() to only instantiate Timer object once
     * To use as singleton design pattern
     * @return Timer object
     */
    public static Timer getTimer() {
        if (timer == null) {
            timer = new Timer();
        }
        return timer;
    }

    /**
     * To register object as an Observer
     * To add the Observer to an ArrayList
     * @param t
     */
    public void register(TickListener t) {
        tickListenersList.add(t);
    }

    /**
     * To deregister object as an Observer
     * To remove the Observer from an ArrayList
     * @param t
     */
    public void deregister(TickListener t) {
        tickListenersList.remove(t);
    }

    /**
     * Observable will notifies the Observer
     * To loop through TickListener ArrayList and make each element to call tick()
     */
    public void notifyObserver() {
        for (TickListener t : tickListenersList) {
            t.tick();
        }
    }


}
