package com.api.book.bootrestbook.Controllers;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;
    //get all book handler
@GetMapping("/books")
    public List<Book> getBooks(){
    Book book=new Book();
//    book.setId(1234);
//    book.setAuthor("the programmer");
//    book.setTitle("XYZ");
        return this.bookService.getAllBooks();
    }

    //get single book handler
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id")int id){
    return bookService.getBookById(id);
    }
//new book handler create
    @PostMapping("/books")
public Book addBook(@RequestBody Book book){
  Book b=  this.bookService.addBook(book);
        System.out.println(book);
    return b;
}

//delete book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable  ("bookId") int bookId){
    this.bookService.deleteBook(bookId);
    }

    //update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
    this.bookService.updateBook(book,bookId);
        return book;
    }
}
