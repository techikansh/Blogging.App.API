package com.BloggingApp.Blogging_App.Repository;

import com.BloggingApp.Blogging_App.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
