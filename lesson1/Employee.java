package TRJavaHWs.lesson1;

public class Employee {
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary>=0){
        this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }
    public void raiseSalary(double k){
        this.setSalary(this.getSalary() + this.getSalary() * k);
    }

    @Override
    public String toString() {
        return "Сотрудник по имени и фамилии "  + name +
                " " + surname +
                "имеет годовую зарплату " + salary;
    }
}
