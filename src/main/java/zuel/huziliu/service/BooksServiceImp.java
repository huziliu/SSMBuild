package zuel.huziliu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zuel.huziliu.mapper.BooksMapper;
import zuel.huziliu.pojo.Books;

import java.util.List;
@Service("BookServiceImp")
public class BooksServiceImp implements BooksService{
    //service层调用mapper(dao)层

    private BooksMapper booksMapper;

    @Autowired
    @Qualifier("booksMapper")
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int add_a_Book(Books books) {
        return booksMapper.add_a_Book(books);
    }

    public int delete_a_Book(int bookID) {
        return booksMapper.delete_a_Book(bookID);
    }

    public int update_a_Book(Books books) {
        return booksMapper.update_a_Book(books);
    }

    public Books getBookById(int bookID) {
        return booksMapper.getBookById(bookID);
    }

    public List<Books> getBooks() {
        return booksMapper.getBooks();
    }

    public List<Books> transactionTest(){
        booksMapper.add_a_Book(new Books(4,"测试罢了",10,"呵呵"));
        booksMapper.delete_a_Book(4);
        return booksMapper.getBooks();
    }

    public List<Books> getBooksByName(String bookName) {
        return booksMapper.getBooksByName(bookName);
    }
}
