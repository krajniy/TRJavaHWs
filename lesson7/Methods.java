package TRJavaHWs.lesson7;

import java.util.LinkedList;
import java.util.List;

public class Methods {

    public static int START_COURSE = 1;
    public static int FINISH_COURSE = 5;
    public List<Student> students;

    public Methods() {
        students = new LinkedList<>();
        fillStudents();
    }

    public Methods(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudents(Student student) {
        students.add(student);
    }
    public void fillStudents(){
        students.add(new Student("Jobs", 2));
        students.add(new Student("Gates", 5));
        students.add(new Student("Zuckerberg", 3));
        students.add(new Student("Brin", 5));
    }

}
