package com.hoanglinh.formatter;

//import com.hoanglinh.model.Blog;
//import com.hoanglinh.service.BlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//
//
//import java.text.ParseException;
//import java.util.Locale;
//
//public class BlogFormatter implements Formatter <Blog>{
//     private BlogService blogService;
//     @Autowired
//     public BlogFormatter(BlogService blogService){
//         this.blogService=blogService;
//     }
//
//    @Override
//    public Blog parse(String text, Locale locale) throws ParseException {
//        return blogService.findByTime();
//    }
//
//    @Override
//    public String print(Blog object, Locale locale) {
//        return null;
//    }
//}
