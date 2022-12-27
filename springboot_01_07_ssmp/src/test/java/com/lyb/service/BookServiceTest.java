package com.lyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyb.daomian.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;
    @Test
    void getId(){
        System.out.println(bookService.getById(1));
    }
    @Test
        //添加
    void testSave(){
        Book book=new Book();
        book.setType("测试数据2");
        book.setName("测试数据2");
        book.setDescription("测试数据666666");
        bookService.save(book);
    }

    @Test
        //修改
    void testUpdate(){
        Book book=new Book();
        book.setId(11);
        book.setType("测试数据2");
        book.setName("测试数据2");
        book.setDescription("测试数据22222222");
        bookService.updateById(book);
    }

    @Test
        //删除
    void testDelete(){
        bookService.removeById(12);
    }

    @Test
        //查询所有
    void testGetAll(){
        bookService.list();
    }

    @Test
        //分页查询
    void testGetPage(){
        IPage<Book> page=new Page<Book>(2,5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }
}
