package TRJavaHWs.lesson34.anns;

import lesson34.annotationpractice.Greeting;
import lesson34.annotationpractice.HelloAnnotation;
import lesson34.annotationpractice.HelloAnnotationProccessor;
import lesson34.annotationpractice.InvocationCount;

import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) {
        Greeter g = new Greeter();
//        HelloAnnotationProccessor p = new HelloAnnotationProccessor();
//        p.processForObject(g);
        InvocationCountProcessor icp = new InvocationCountProcessor();
        try {
            icp.invocationProcess(g);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}

class Greeter {
    private int count = 0;

    @HelloAnnotation(greeting = Greeting.HI, from = "Java", to = "Spring")
    void m1(){

    }

    @HelloAnnotation(greeting = Greeting.HELLO, from = "Java", to = "Spring")

    void m2(){

    }
    @HelloAnnotation(greeting = Greeting.GREETNGS, from = "Java", to = "Spring")

    void m3(){

    }

    @InvocationCount(4)
    void m4(){
        System.out.println(++count);

    }
}
