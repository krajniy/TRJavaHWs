package TRJavaHWs.lesson7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
//        students.add(new Student("Jobs", 2));
//        students.add(new Student("Gates", 5));
//        students.add(new Student("Zuckerberg", 3));
//        students.add(new Student("Brin", 5));
//
//        Student.printStudents(students, 5);
        Methods methods = new Methods();
        printStudentsByCourse(methods.getStudents());




    }

    public static void printStudentsByCourse(List<Student> students){
        for (int i = Methods.START_COURSE; i < Methods.FINISH_COURSE; i++) {
            System.out.println("Students of "+i+" course");
            printStudents1(students, i);
            System.out.println();
        }
    }
    public static void printStudents1(List<Student> students, int course){
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()){
            Student st = studentIterator.next();
            if (st.getCourse()==course){

                System.out.println(st.getName());
            }

        }
    }
}
