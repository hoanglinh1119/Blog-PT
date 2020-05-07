package com.hoanglinh.service;


import com.hoanglinh.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService{
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitle(String title,Pageable pageable);
    void save(Blog blog);
    Blog findById(Long id);
    Page<Blog> findByTime(String time,Pageable pageable);
    Page<Blog> findByAuthor(String author,Pageable pageable);


}
