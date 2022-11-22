package TRJavaHWs.lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyStringBuilder {
    private static List<String> strings = new ArrayList<>();

    public MyStringBuilder(String value) {
        strings.add(value);
    }

    public MyStringBuilder() {
    }

    public MyStringBuilder append(String s){

        strings.add(s);
        return this;

    }

    public String reverse(){
        Function<String, String> f = str -> str + "";
        for (String s : strings){
            f = f.compose(str -> str + s);
        }

        return f.apply("Reverse: ");
    }

    @Override
    public String toString() {
        Function<String, String> f = Function.identity();
        for (String s : strings){
            f = f.andThen(str -> str + s);

        }

        return f.apply("ToString: ");
    }
}
