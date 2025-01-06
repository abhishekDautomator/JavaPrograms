public class ReferenceComparisionVsContentComparision {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println("s1==s2 - > "+(s1==s2));
        System.out.println("s1.equals(s2) -> "+s1.equals(s2)); //false if default content comparison happens
        System.out.println("s1.x==s2.x -> "+(s1.x==s2.x));
        System.out.println("s1.y==s2.y -> "+(s1.y==s2.y));
        System.out.println("s1.x==s1.y -> "+(s1.x==s1.y));
        System.out.println("s2.x==s2.y -> "+(s2.x==s2.y));
        System.out.println("s1.x==s2.y -> "+(s1.x==s2.y));
        System.out.println("s1.y==s2.x -> "+(s1.y==s2.x));

        String str1 = "Abhishek";
        String str2 = "Abhishek";
        String str3 = "Narayan";
        System.out.println("str1==str2 -> "+(str1==str2));
        System.out.println("str1.equals(str2) -> "+str1.equals(str2));
        System.out.println("str1==str3 -> "+(str1==str3));
        System.out.println("str1.equals(str3) -> "+str1.equals(str3));

        String st1 = new String("Hello");
        String st2 = new String("Hello");
        String st3 = "Hello";

        System.out.println(st1 == st2); // false, different references
        System.out.println(st1.equals(st2)); // true, same content
        System.out.println(st3 == st1); // false, different references
        System.out.println(st3.equals(st1)); // true, same content
    }
}

class Student{
    int x = 34;
    int y = 34;

    /*@Override
    public boolean equals(Object o){
        System.out.println("Object content comparision");
        Student s = (Student) o;
        return s.x==this.x;
    }*/
}


