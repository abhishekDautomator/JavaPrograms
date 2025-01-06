package DesignPatterns.BehavioralPattern.ObserverDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    public static void main(String[] args) throws IOException {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber abhishek = new Subscriber("Abhishek");
        Subscriber anu = new Subscriber("Anu");
        channel.subscribe(abhishek);
        channel.subscribe(anu);
        channel.notifyChanges("Design Patterns");
        channel.notifyChanges("Data Structure");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter an option to perform an operation from the below list");
        System.out.println("1. To add a video");
        System.out.println("2. To add a subscriber");
        System.out.println("3. To remove a subscriber");
        System.out.println("4. To exit");
        int input = Integer.parseInt(bf.readLine());

        switch (input){
            case 1: {
                System.out.println("Enter title of the video");
                String movie= bf.readLine();
                channel.notifyChanges(movie);
            }
            case 2: {
                System.out.println("Enter the name of the subscriber who needs to be added");
                String name= bf.readLine();
                Subscriber dhriti = new Subscriber(name);
                channel.subscribe(dhriti);
            }
            case 3: {
                System.out.println("Enter the name of the subscriber who needs to be removed");
                String name= bf.readLine();
                int counter = 0;
                for (Observer subscriber : channel.subscribers) {
                    if(subscriber.name().equalsIgnoreCase(name)){
                        channel.unSubscribe(subscriber);
                        System.out.println(name+" unsubscribed from the channel");
                        break;
                    }else counter++;
                }
                if(counter==channel.subscribers.size()) System.out.println("No such subscriber exists");
            }
            case 4: bf.close(); break;
            default:
                System.out.println("Wrong input entered");
        }
    }
}
