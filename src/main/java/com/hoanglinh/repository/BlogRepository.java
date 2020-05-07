package com.hoanglinh.repository;

import com.hoanglinh.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
