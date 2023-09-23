package com.api.book.bootrestbook.Controllers;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    //get all book handler
    @GetMapping("/books")
    //public List<Book> getBooks(){
    // Book book=new Book();
//    book.setId(1234);
//    book.setAuthor("the programmer");
//    book.setTitle("XYZ");
    // return this.bookService.getAllBooks();
//}
    public ResponseEntity<List<Book>> getBooks() {
        //https status
        List<Book> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(list));
        }

    }

    //get single book handler
    @GetMapping("/books/{id}")
//    public Book getBook(@PathVariable("id")int id){
//    return bookService.getBookById(id);
//    }

    //get single book handler with https status
    public ResponseEntity<Book> getBook(@PathVariable("Id") int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(book));
        }
    }

    //new book handler create
    @PostMapping("/books")
//public Book addBook(@RequestBody Book book){
    // Book b=  this.bookService.addBook(book);
    //      System.out.println(book);
    //  return b;
//}
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //delete book handler
    @DeleteMapping("/books/{bookId}")
//    public void deleteBook(@PathVariable  ("bookId") int bookId){
//    this.bookService.deleteBook(bookId);
//}
    //try catch with the delete book handler
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //update book handler
    @PutMapping("/books/{bookId}")
//    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
//    this.bookService.updateBook(book,bookId);
//        return book;
//    }

    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        try {
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

