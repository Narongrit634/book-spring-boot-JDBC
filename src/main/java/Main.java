import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import th.ku.bookstore.Book;
import th.ku.bookstore.BookDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDao bookDao = context.getBean("bookDaoImp", BookDao.class);

        // ---- insert book ----
        Book newBook = new Book(4, "Basic of Spring Framework", 556);
        bookDao.save(newBook);

        // ---- select book ----
        Book spring = bookDao.findById(4);
        System.out.println("---getOne: " + spring);

        List<Book> bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

        // ---- update book ----
        newBook.setPrice(600);
        bookDao.update(4, newBook);

        spring = bookDao.findById(4);
        System.out.println("---fineById: " + spring);

        // ---- delete book ----
        bookDao.deleteById(4);

        bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}