package pl.akademiakodu.library.dao;

import pl.akademiakodu.library.domain.Book;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Daniel_B on 16.11.2016.
 */
public class BookDaoSqlite implements BookDao {
    private Connection connection;

    public BookDaoSqlite() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        createTable();
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, "
                + "author TEXT, "
                + "pages INTEGER "
                + ")";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Nie udało sie wykonać SQL " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BookDaoSqlite bookDaoSqlite = new BookDaoSqlite();
        bookDaoSqlite.addBook(new Book("Pozytywne myślenie", "Brayan Stacey", 359));

    }

    public void addBook(Book book) {
        String simpleClassName = book.getClass().getSimpleName();
        Field[] fields = book.getClass().getDeclaredFields();
        StringBuilder attributeString = new StringBuilder("(");
        for (Field field:fields){
            if(!field.getName().equals("id")) {
                attributeString.append(field.getName());
                attributeString.append(",");
            }


        }
        attributeString.deleteCharAt(attributeString.length()-1);
        attributeString.append(")");
        System.out.println(attributeString);
        String sql = "INSERT INTO " + simpleClassName + "s "+attributeString
                + "VALUES ('" + book.getTitle() + "','" + book.getAuthor() + "'," + book.getPages() + ")";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            System.out.println("Nie udało sie wykonać SQL " + e.getMessage());
        }
    }


    public void removeBook(Book book) {
    }


    public List<Book> getAllBooks() {
        return null;
    }
}
