package com.lyb.dao;

import com.lyb.daomian.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from daomian where id = #{id}")
    public Book getById(Integer id);
}
