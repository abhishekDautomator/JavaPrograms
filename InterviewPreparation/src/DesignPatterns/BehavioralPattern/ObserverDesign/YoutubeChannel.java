package DesignPatterns.BehavioralPattern.ObserverDesign;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        this.subscribers.add(ob);
    }

    @Override
    public void unSubscribe(Observer ob) {
        this.subscribers.remove(ob);
    }

    @Override
    public void notifyChanges(String title) {
        this.subscribers.forEach(observer->{
            observer.notified(title);
        });

    }
}
