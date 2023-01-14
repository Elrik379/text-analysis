package analysis.main.service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class BookService implements Runnable {
    private File book;

    public BookService(File book) {
        this.book = book;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(book))) {
            List<String> bookList = new ArrayList<>();
            while (bufferedReader.ready()) {
                bookList.add(bufferedReader.readLine());
            }
            threadRun(bookList);
            getResult(bookList);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void threadRun(List<String> list) throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {

            }
        };
    }

    public void getResult(List<String> list) {
        PrintStream printStream = new PrintStream(System.out);
        long resultAll = 0, resultCh = 0;
        for (String s : list) {
            resultAll += s.chars().count();
            resultCh += s.chars().filter(x -> x != ' ').count();

        }
        printStream.println("Количество символов с пробелами: " + resultAll);
        printStream.println("Количество символов без пробелов: " + resultCh);

    }

}
