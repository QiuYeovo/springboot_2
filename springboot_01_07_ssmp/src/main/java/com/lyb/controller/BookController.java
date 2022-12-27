package com.lyb.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyb.controller.utils.R;
import com.lyb.daomian.Book;
import com.lyb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")){
            throw new IOException();
        }
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
//        if (currentPage>page.getPages()){
//            page=iBookService.getPage((int)page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){

        System.out.println(book);
        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        if (currentPage>page.getPages()){
           page= iBookService.getPage((int) page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
