package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Comment;

public class CommentImpl implements Comment {
    private String author;
    private String description;

    public CommentImpl(String author, String description) {
        this.author = author;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
