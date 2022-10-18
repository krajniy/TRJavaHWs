package TRJavaHWs.lesson6;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        BookList bookList = new BookList(List.of(
                new Book("Tolstoy", "War and Peace"),
                new Book("Pushkin", "Eugene Onegin"),
                new Book("Jois", "Ulysses")));

//        bookList.printAll();
        bookList.removeBook("War and Peace");
        bookList.printAll();



    }
}
