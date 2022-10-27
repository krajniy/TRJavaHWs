package TRJavaHWs.lesson9;

public class Movie implements Comparable<Movie> {

    private int rating;
    private String name;
    private int Year;

    public Movie(int rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        Year = year;
    }


    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return Year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.getYear() - o.getYear();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", Year=" + Year +
                '}';
    }
}
