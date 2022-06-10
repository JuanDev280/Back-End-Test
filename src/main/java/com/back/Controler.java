package com.back;

import com.back.domain.Usuario;
import com.back.domain.Book;
import com.back.domain.RentBook;
import com.back.service.BookService;
import com.back.service.RentBookService;
import com.back.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class Controler {
    
    
    SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
    Calendar calendar = Calendar.getInstance();;
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RentBookService rentBookService;
    
    public Usuario localuser;
    public RentBook rentBook;
    
    
    
    @GetMapping("/")
    public String start(){
        log.info("Ejecutando el controlador rest");
        return "login";
    }
    
    @PostMapping("/login")
    public String login(Usuario user){
        localuser = userService.findByUsername(user.getUsername());
        if(localuser.getPwd().equals(user.getPwd())){
            return "index";
        }else {
            return "/errors/403";
        }
    }
    
    
    
    /* User request */
    @GetMapping("/add")
    public String add(Usuario user){
        return "/user/update";
    }
    
    @PostMapping("/save")
    public String save(Usuario user){
        userService.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id_user}")
    public String edit(Usuario user, Model model){
        user = userService.findUser(user);
        model.addAttribute("user", user);
        return "update";
    }
    
    @GetMapping("/remove/{id_user}")
    public String remove(Usuario user){
        userService.remove(user);
        return "redirect:/";
    }
    
    @GetMapping("/listBooksUser")
    public String listBooks(Model model){
        var books = bookService.listBooks();
        model.addAttribute("books", books);
        return "/user/listBooksUser";
    } 
    
    @GetMapping("/rent/{isbn}")
    public String rent(Book book, Model model){
        book = bookService.findBook(book);
        model.addAttribute("book", book);
        return "/user/rent";
    }
    
    @PostMapping("/saveReservation")
    public String saveReservation(Book book){
        Date date = calendar.getTime();
        int quantity = 1;
        rentBook = new RentBook(date, date, quantity, localuser, book);      
        rentBookService.save(rentBook);
        return "redirect:/";
    }
    
    @GetMapping("/viewReservations")
    public String viewReservations(Model model){
        var rentBooks = rentBookService.listRentBooks();
        model.addAttribute("rentBooks", rentBooks);
        return "/user/viewReservations";
    } 
    
    
    /* Admin request */
    @GetMapping("/admin")
    public String adminView(){
        return "/admin/admin";
    } 
    
    @GetMapping("/listBooks")
    public String editBooks(Model model){
        var books = bookService.listBooks();
        model.addAttribute("books", books);
        return "/admin/listBooks";
    }
    
    @GetMapping("/addBook")
    public String addBook(Book book){
        return "/admin/addBook";
    }
    
    @PostMapping("/saveBook")
    public String saveBook(Book book){
        bookService.save(book);
        return "redirect:/";
    }
    
    @GetMapping("/editBook/{isbn}")
    public String editBook(Book book, Model model){
        book = bookService.findBook(book);
        model.addAttribute("book", book);
        return "/admin/addBook";
    }
    
    @GetMapping("/removeBook/{isbn}")
    public String removeBook(Book book){
        bookService.remove(book);
        return "redirect:/";
    }
    
    @GetMapping("/listUsers")
    public String listUsers(Model model){
        var users = userService.listUsers();
        model.addAttribute("users", users);
        return ("/admin/listUsers");
    }
}
