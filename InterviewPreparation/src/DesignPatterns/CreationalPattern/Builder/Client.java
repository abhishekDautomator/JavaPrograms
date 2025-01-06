package DesignPatterns.CreationalPattern.Builder;

public class Client {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setUserId("1")
                .setUserName("Abhishek")
                .setAge("30")
                .setDesignation("Senior Associate")
                .setSalary("155000")
                .setCountry("India")
                .build();
        System.out.println(user);
    }
}
