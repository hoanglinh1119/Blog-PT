package com.hoanglinh.controller;


import com.hoanglinh.model.Blog;
import com.hoanglinh.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@RequestParam("title")Optional<String> title,
                                  @RequestParam("author") Optional<String> author,
                                  @RequestParam("time") Optional<String> time,
                                  @PageableDefault(size=5)Pageable pageable){

        Page<Blog>blogs;
       if(title.isPresent()){
           blogs=blogService.findByTitle(title.get(),pageable);
       }else
           if (time.isPresent()){
               blogs=blogService.findByTime(time.get(),pageable);
           }else if (author.isPresent()){
               blogs=blogService.findByAuthor(author.get(),pageable);
           }else {
                blogs=blogService.findAll(pageable);
           }
        ModelAndView modelAndView = new ModelAndView("blogs/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
     ModelAndView modelAndView=new ModelAndView("blogs/create");
     modelAndView.addObject("blog",new Blog());
     return modelAndView;
    }
    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blogs/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

}
