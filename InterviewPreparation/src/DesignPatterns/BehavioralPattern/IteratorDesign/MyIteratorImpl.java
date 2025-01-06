package DesignPatterns.BehavioralPattern.IteratorDesign;

import java.util.ArrayList;
import java.util.List;

public class MyIteratorImpl implements MyIterator{
    private List<User> users;
    private int length;
    private int index = 0;

    public MyIteratorImpl(List<User> users){
        this.users = users;
        this.length = users.size();
    }

    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public Object next() {
        return users.get(index++);
    }
}
