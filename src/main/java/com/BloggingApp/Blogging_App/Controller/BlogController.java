package com.BloggingApp.Blogging_App.Controller;


import com.BloggingApp.Blogging_App.Dto.BlogDto;
import com.BloggingApp.Blogging_App.Model.Blog;
import com.BloggingApp.Blogging_App.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:5173/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create-blog")
    public ResponseEntity<Blog> createBlog (@RequestBody BlogDto blogDto) throws Exception {
        if (blogDto == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogService.createBlog(blogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @PutMapping("blogs/{id}")
    public ResponseEntity<Blog> updateBlog (@PathVariable Long id, @RequestBody BlogDto blogDto) throws Exception {
        if (blogDto == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogService.updateBlog(id, blogDto), HttpStatus.OK);
    }

    @DeleteMapping("blogs/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) throws Exception {
        blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
