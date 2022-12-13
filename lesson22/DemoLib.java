package TRJavaHWs.lesson22;

public class DemoLib {
    public static void main(String[] args) {
        Library1<Object> library1 = new Library1();
        library1.add(new Book1());
        library1.add(new Newspapper1());
        library1.add(new Magazine());
        library1.add(new Manuscript());

        Library<Media> library = new Library<>();
        library.add(new Book());
        library.add(new Magazine());
        library.add(new Newspapper());
        library.add(new Manuscript());

        Library2 library2 = new Library2();
        library2.add(new Book2());
        library2.add(new Magazine2());
        library2.add(new Newspapper2());
        library2.add(new Manuscript2());

    }
}
