package pl.akademiakodu.library.domain;

/**
 * Created by Daniel_B on 16.11.2016.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(int id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }


}
