package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //    private static List<Book> list=new ArrayList<>();
//    static{
//        list.add(new Book(12,"java  complete  ","XYZ"));
//        list.add(new Book(13,"the programmer of java","ABC"));
//        list.add(new Book(14,"the genius book of programm","EFG"));
//        list.add(new Book(15,"the elborate programmer","PQR"));
//    }
    //get all books
    // public List<Book> getAllBooks(){
    //  return list;
    // }
    //get all books wihe help of database
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }


    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try {
           // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        book=this.bookRepository.findById(id);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    //add the book
//    public Book addBook(Book b){
//        list.add(b);
//        return b;
//    }
    //add the book with the help of database
    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }
    //delete the book
//    public void deleteBook(int bid) {
//        list=  list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
//    }

    //delete the book by the help of database
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
    }

    //update the book
//    public void updateBook(Book book, int bookId) {
//        list.stream().map(b->{
//            if(b.getId()==bookId){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
//    }

    //update the book with the help of database
    public void updateBook(Book book,int bookId){
        book.setId(bookId);
        bookRepository.save(book);
    }
}

