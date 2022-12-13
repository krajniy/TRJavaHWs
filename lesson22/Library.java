package TRJavaHWs.lesson22;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {

    List<T> list = new ArrayList<>();

    public T get(int i) {
        return list.get(i);
    }

    public void add(T media){
        list.add(media);
    }

}

class Book implements Media {

}

class Manuscript implements Media {

}

class Newspapper implements Media {

}

class Magazine implements Media {

}

interface Media {

}
