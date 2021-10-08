package com.jasekraft.bookclub.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200, message ="Must be at least 5 characters and less than 200 characters")
    private String title;
    
    @NotNull
    @Size(min = 5, max = 200)
    private String author;
    
    @NotNull
    @Size(min = 3, max = 500)
    private String myThoughts;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    public Book() {
    }
    
    public Book(String title, String author, String myThoughts, User user ) {
        this.title = title;
        this.author = author;
        this.myThoughts = myThoughts;
        this.user = user;
    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getAuthor() {
		return author;
	}

	public String getMyThoughts() {
		return myThoughts;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}

    
}

