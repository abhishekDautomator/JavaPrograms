package DesignPatterns.CreationalPattern.Builder;

public class User {
    //Builder Design Pattern offers several advantages in scenarios involving complex object
    // construction, immutability, and readability; it's important to note that the Factory
    // Design Pattern is still valuable for simpler object creation scenarios where the
    // overhead of a Builder is unnecessary. Choosing between them should be based on the
    // specific requirements of your application and the complexity of the objects being created.

    private final String userId;
    private final String userName;
    private final String age;
    private final String salary;
    private final String designation;
    private final String country;

    private User(UserBuilder userBuilder) { //builder design is mainly use to create immutable object
        // so that's why private constructor
        this.userId = userBuilder.userId;
        this.age = userBuilder.age;
        this.userName = userBuilder.userName;
        this.salary = userBuilder.salary;
        this.designation = userBuilder.designation;
        this.country = userBuilder.country;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", designation='" + designation + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    //inner class to create object
    static class UserBuilder{
        private String userId;
        private String userName;
        private String age;
        private String salary;
        private String designation;
        private String country;

        public UserBuilder() {
        }

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public UserBuilder setSalary(String salary) {
            this.salary = salary;
            return this;
        }

        public UserBuilder setDesignation(String designation) {
            this.designation = designation;
            return this;
        }

        public UserBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
