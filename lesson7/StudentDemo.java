package TRJavaHWs.lesson7;

import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jobs", 2));
        students.add(new Student("Gates", 5));
        students.add(new Student("Zuckerberg", 3));
        students.add(new Student("Brin", 5));

        Student.printStudents(students, 5);

    }
}
