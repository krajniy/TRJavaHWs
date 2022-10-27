package TRJavaHWs.lesson9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoMovie {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(10, "What we do in the shadows", 2014));
        movies.add(new Movie(9, "Everything Everywhere All at Once", 2021));
        movies.add(new Movie(8, "Blade Runner", 1982));
        movies.add(new Movie(6, "Filth", 2013));
        movies.add(new Movie(3, "Ready Player One", 2018));

        System.out.println(movies);
        Collections.sort(movies);
        System.out.println(movies);

        Comparator movieComparator = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result !=0){
                    return result;
                }
                return o1.getRating()-o2.getRating();
            }
        };
        Collections.sort(movies, movieComparator);
        System.out.println(movies);


    }
}
