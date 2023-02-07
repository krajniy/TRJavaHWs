package TRJavaHWs.lesson34.anns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationCountProcessor {
    /*
     * TODO:
     *   Написать InvocationCountProcessor, таким образом, чтобы он получал все методы объекта с данной аннотацией
     *   и вызывал каждый из этих методов столько раз, сколько указано в аннотации
     * */

    public void invocationProcess(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(InvocationCount.class)){
                int count = o.getClass().getAnnotation(InvocationCount.class).value();
                for (int i = 0; i < count; i++) {
                    method.invoke(o);
                }
            }
        }
    }

}
