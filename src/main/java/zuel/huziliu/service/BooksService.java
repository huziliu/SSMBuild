package zuel.huziliu.service;

import zuel.huziliu.pojo.Books;

import java.util.List;

public interface BooksService {
    //增加一本书
    public int add_a_Book(Books books);
    //删除一本书
    public int delete_a_Book(int bookID);
    //更新一本书
    public int update_a_Book(Books books);
    //查询一本书
    public Books getBookById(int bookID);
    //查询全部的书
    public List<Books> getBooks();
    //通过书名查书
    public List<Books> getBooksByName(String bookName);
    public List<Books> transactionTest();

}
