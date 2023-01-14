package analysis.main;

import analysis.main.service.BookService;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BookService bookService = new BookService(new File("emiliya.doc"));
        Thread threadRead = new Thread(bookService);
        threadRead.start();

    }
}
