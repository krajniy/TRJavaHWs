package TRJavaHWs.lesson23.testing;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        User admin = createUser(
                "John Smith", LocalDate.of(1989, 12, 13),
                UserType.ADMIN, "@jsmith89");

        User defaultUser = createUser(
                "Tyler Black", LocalDate.of(1963, 9, 24),
                UserType.DEFAULT, "@jsmith89");

        System.out.println(createUserTest(admin));
        System.out.println(createUserTest(defaultUser));

        System.out.println(createUserNegativeTest(admin, true));
        System.out.println(createUserNegativeTest(defaultUser, false));


    }

    public static User createUser(String fullName, LocalDate birthDate, UserType userType, String login) {
        String name = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];
        int age = LocalDate.now().compareTo(birthDate);
        boolean isAdmin = true; //userType == UserType.ADMIN;
        login = login.replaceAll("@", "");

        return new User(name, lastName, age, isAdmin, login);


    }

    public static boolean createUserTest(User u) {
        boolean age = u.getAge()>0;
        boolean name = !u.getName().isEmpty();
        boolean lastName = !u.getLastName().isEmpty();
        boolean admin = true;
        boolean login = u.getLogin().matches("\\w+");


        if (age && name && lastName && admin && login){
            return true;
        } else throw new  RuntimeException();

    }

    public static boolean createUserNegativeTest(User u, boolean isAdmin) {
        boolean age = u.getAge()>0;
        boolean name = !u.getName().isEmpty();
        boolean lastName = !u.getLastName().isEmpty();
        boolean admin = isAdmin == u.isAdmin();
        boolean login = u.getLogin().matches("\\w+");


        if (age && name && lastName && admin && login){
            return true;
        } else throw new  RuntimeException();

    }

    public enum UserType {
        ADMIN, DEFAULT
    }

}



