package zuel.huziliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zuel.huziliu.pojo.Books;
import zuel.huziliu.service.BooksService;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    private BooksService booksService;

    @Autowired
    @Qualifier("BookServiceImp")
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/allbooks")
    public String list(Model model){
       /* ApplicationContext context=new ClassPathXmlApplicationContext("spring-service.xml");
        booksService= (BooksService) context.getBean("BookServiceImp");*/
        List<Books> books = booksService.getBooks();
        model.addAttribute("books",books);
        return "allbooks";
    }

    @RequestMapping("/to_addbook")
    public String add_book(Model model){
        return "addBook";
    }

    @PostMapping("/add")
    public String add(Books books)  {
        booksService.add_a_Book(books);
        return "redirect:/book/allbooks";
    }

    @RequestMapping("/to_updatebook/{id}")
    public String update_book(@PathVariable int id, Model model, HttpSession session){
        Books book = booksService.getBookById(id);
        model.addAttribute("book",book);
//        session.setAttribute("current_id",id);
        return "updateBook";
    }

    @RequestMapping("/update")
    public String update(Books books,Model model,HttpSession session){
     /*   Object current_id =  session.getAttribute("current_id");
        books.setBookID((Integer) current_id);*/
        booksService.update_a_Book(books);
        return "redirect:/book/allbooks";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        booksService.delete_a_Book(id);
        return "redirect:/book/allbooks";
    }

    @PostMapping("/search")
    public String search_books(String queryBookName, Model model){
        List<Books> list;
        if(queryBookName.equals("")){
            list = booksService.getBooks();
        }
        else {
            list = booksService.getBooksByName(queryBookName);
        }
        model.addAttribute("books",list);
        return "allbooks";
    }
}
