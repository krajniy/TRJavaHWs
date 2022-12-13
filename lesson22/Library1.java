package TRJavaHWs.lesson22;

import java.util.ArrayList;
import java.util.List;

 public class Library1<T extends Object > {

    List<T> list = new ArrayList<>();

     public T get(int i) {
         return list.get(i);
     }

     public void add(T media){
         list.add(media);
     }





}

class Book1 {

}

class Manuscript1  {

}

class Newspapper1  {

}

class Magazine1 {

}


