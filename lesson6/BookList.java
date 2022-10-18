package TRJavaHWs.lesson6;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books = new ArrayList<>();

    public BookList(List<Book> books) {
        this.books.addAll(books);
    }


    public void insertBook(Book book){
        books.add(book);
    }

    public void removeBook(int ind){
        books.remove(ind);
    }

    public void printAll(){
        books.forEach(System.out::println);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
