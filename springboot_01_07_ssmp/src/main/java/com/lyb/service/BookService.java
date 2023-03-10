package com.lyb.service;
import com.lyb.daomian.Book;
import java.util.List;
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
}
