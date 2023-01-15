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
                Map<String, Integer> map = new HashMap<>();
                for (String temp : list) {
                    String[] array = temp.split("[ .,:?!-]");
                    for (String arrayTemp : array) {
                        if (map.containsKey(arrayTemp) && arrayTemp.length() > 3)
                            map.merge(arrayTemp, 1, Integer::sum);
                        else
                            map.putIfAbsent(arrayTemp, 1); //добавляет в мапу, если значения нет
                    }

                }

                Map.Entry<String, Integer> maxEntry = map.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);
                System.out.println(maxEntry);
                //map.forEach((k, v) -> System.out.print(k + v + " "));
            }
        };
        thread1.start();
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
