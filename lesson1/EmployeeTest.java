package TRJavaHWs.lesson1;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee johnSmith = new Employee("John Smith", "", 60000);
        Employee janeDoe = new Employee("Jane Doe", "", 96000);

        System.out.println(johnSmith);
        System.out.println(janeDoe);

        johnSmith.raiseSalary(0.1);
        janeDoe.raiseSalary(0.1);

        System.out.println(johnSmith);
        System.out.println(janeDoe);

    }
}
