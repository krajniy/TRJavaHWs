package TRJavaHWs.lesson34.anns;

import TRJavaHWs.lesson34.refl.*;

import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionPractice {
    private static final Map<Class<?>, Class<?>> wrapperMap = Map.of(
            long.class, Long.class,
            int.class, Integer.class
    );

    public static void main(String[] args) {
//        User u = new User(1, "a", "b", LocalDateTime.of(1980,10,5,0,0));
//        Method[] methods = u.getClass().getDeclaredMethods();
//
//        Class<? extends User> clazz = u.getClass();
//
//        Field[] fields = clazz.getDeclaredFields();
//
//        Object o = new Event(1);
//        System.out.println(o);

        try {
            Object o1 = createObjectFromClass(User.class);
            Object o2 = createObjectFromClass(Event.class);
            System.out.println(o1);
            System.out.println(o2);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


//        Arrays.stream(fields).forEach(System.out::println);
//
//        try {
//            Field nameField = clazz.getDeclaredField("firstName");
//            nameField.setAccessible(true);
//            nameField.set(u, "John");
//            System.out.println(nameField.get(u));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }


//        for (Method method : methods){
//            Parameter[] parameters = method.getParameters();
//            Class<?> returnedType = method.getReturnType();
//
//
//            if (parameters.length == 1 && parameters[0].getType().equals(String.class)){
//                System.out.println(method.getName());
//            }
//            if (returnedType.equals(String.class)){
//                System.out.println(returnedType.getName() + " " + method.getName());
//            }

//            System.out.println(method);
//        }


    }

    public static Object createObjectFromClass(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
         * TODO:
         *   1. Получить список конструкторов класса
         *   2. Взять первые конструктор
         *   3. Узнать, какие аргументы он принимает
         *   4. В зависимости от типа передать любые аргументы этого типа
         * */

        Constructor<?>[] constructors = clazz.getConstructors();
        Constructor<?> constructor = constructors[0];
        Parameter[] parameters = constructor.getParameters();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class paramClass = parameters[i].getType();
            if (paramClass.isAssignableFrom(String.class)) {
                args[i] = "aaaaa";
            } else if (paramClass.isPrimitive()) {
                Class<?> wrapperClass = wrapperMap.get(paramClass);
                if (wrapperClass.equals(Long.class)) {
                    args[i] = 11111111;
                }
            } else if (paramClass.isAssignableFrom(LocalDateTime.class)) {
                args[i] = LocalDateTime.of(1980, 10, 5, 0, 5);
            }
        }

        return constructor.newInstance(args);

    }
}
