package TRJavaHWs.lesson10;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(User o) {
        if (!this.getName().equals(o.getName())){
            return this.getAge()-o.getAge();
        } else {
            return this.getName().compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
