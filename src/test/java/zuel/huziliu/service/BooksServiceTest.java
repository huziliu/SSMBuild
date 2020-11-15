package zuel.huziliu.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zuel.huziliu.pojo.Books;

import java.util.List;

public class BooksServiceTest {
    @Test
    public void test(){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksService= (BooksService) context.getBean("BookServiceImp");
        List<Books> books = booksService.transactionTest();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
