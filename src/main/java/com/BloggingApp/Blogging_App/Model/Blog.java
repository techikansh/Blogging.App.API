package com.BloggingApp.Blogging_App.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
