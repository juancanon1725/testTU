package com.project.thinkup.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @ManyToOne(targetEntity = Idea.class)
    private Idea idea;
    
    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @Column(length = 2000)
    private String description;

    public Comment() {
    }

    public Comment(Idea idea, User user, String description) {
        creationDate = LocalDate.now();
        this.idea = idea;
        this.user = user;
        this.description = description; 
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        String name = user.getFirstName();
        String lastName = user.getLastName();
        return name + " " + lastName + "\n" +
                creationDate + "\n" + 
                description + "\n";
    }
}
