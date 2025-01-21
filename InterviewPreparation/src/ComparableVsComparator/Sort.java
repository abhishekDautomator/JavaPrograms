package ComparableVsComparator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        ArrayList<Integer> marksList = new ArrayList<>();
        marksList.add(78);
        marksList.add(90);
        marksList.add(86);
        System.out.println(marksList);
        Collections.sort(marksList);
        System.out.println(marksList);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Narayan", 35));
        students.add(new Student(2, "Anu", 15));
        students.add(new Student(3, "Dhriti", 30));
        System.out.println(students);

        //comparable sorting //single field sorting
        students.sort(Comparator.naturalOrder());
        System.out.println(students);

        students.sort(Comparator.reverseOrder());
        System.out.println(students);

        //comparator sorting //multi field sorting
        students.sort(new StudentIdComparator());
        System.out.println(students);

        students.sort(new StudentNameComparator());
        System.out.println(students);
    }
}
