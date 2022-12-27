package com.lyb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyb.dao.BookDao;
import com.lyb.daomian.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;

@SpringBootTest
class Springboot0107SsmpApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
        //查询id
    void testGetId(){
        bookDao.selectById(1);
    }

    @Test
    //添加
    void testSave(){
        Book book=new Book();
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDescription("测试数据11111111111");
        bookDao.insert(book);
    }

    @Test
    //修改
    void testUpdate(){
        Book book=new Book();
        book.setId(11);
        book.setType("测试数据2");
        book.setName("测试数据2");
        book.setDescription("测试数据22222222");
        bookDao.updateById(book);
    }

    @Test
    //删除
    void testDelete(){
        bookDao.deleteById(12);
    }

    @Test
    //查询所有
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    //分页查询
    void testGetPage(){
        IPage page=new Page(1,4);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    @Test
    //按条件查询
    void testGetBy(){
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.like("name","java");
        bookDao.selectList(qw);
    }
    @Test
        //按条件查询
    void testGetBy1(){
        String name="java";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,"java");
        bookDao.selectList(lqw);
    }
}
