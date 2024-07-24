package com.BloggingApp.Blogging_App.Service;

import com.BloggingApp.Blogging_App.Dto.BlogDto;
import com.BloggingApp.Blogging_App.Model.Blog;
import com.BloggingApp.Blogging_App.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(BlogDto blogDto) throws Exception {
        Blog blog = new Blog();

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setImage(blogDto.getImage());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        try {
            return blogRepository.save(blog);
        } catch (Exception e) {
            throw new Exception("Blog couldn't be created!");
        }
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if(blog.isPresent()) {
            return blog.get();
        }
        else {
            throw new RuntimeException("Blog with id: " + id + "not found!");
        }
    }

    public Blog updateBlog(Long id, BlogDto blogDto) throws Exception {
        Blog blog = getBlogById(id);

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setImage(blogDto.getImage());
        blog.setUpdatedAt(LocalDateTime.now());
        try {
            return blogRepository.save(blog);
        }catch (Exception e) {
            throw new Exception("Blog with Id: " + id + "couldn't be updated!");
        }
    }

    public void deleteBlog(Long id) throws Exception {
        try {
            blogRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Blog with id: " + id + "couldn't be deleted");
        }
    }
}
