package DesignPatterns.BehavioralPattern.IteratorDesign;

public class Client {
    public static void main(String[] args) {
        UserManagement users = new UserManagement();
        users.addUser(new User("1", "Abhishek"));
        users.addUser(new User("2", "Narayan"));
        users.addUser(new User("3", "Anu"));
        users.addUser(new User("4", "Dhriti"));

        MyIterator iterator = users.getIterator();
        while(iterator.hasNext()){
            User user = (User) iterator.next();
            System.out.println("name: "+user.getUserName());
        }

    }
}
