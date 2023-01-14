package analysis.main.model;

import java.util.List;

public class Book {
    private String title;
    private List<String> bookList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public Book(String title, List<String> bookList) {
        this.title = title;
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Название книги: " + title;
    }
}
