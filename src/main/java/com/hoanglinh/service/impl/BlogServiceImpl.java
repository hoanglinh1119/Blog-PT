package com.hoanglinh.service.impl;

import com.hoanglinh.model.Blog;
import com.hoanglinh.repository.BlogRepository;
import com.hoanglinh.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByTitle(String title,Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> findByTime(String time,Pageable pageable) {
        return blogRepository.findAllByTitleContaining(time,pageable);
    }

    @Override
    public Page<Blog> findByAuthor(String author, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(author,pageable);
    }
}
