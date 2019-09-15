package com.cbartley.library;

public class Book {
    private int bookId;
    private String title;
    private Genre genre;
    private String author;

    public Book() {}

    public Book(String title, String author, Genre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }


    public void SetId(int id){
        this.bookId = id;
    }

    public int GetId(){
        return this.bookId;
    }

    public void SetTitle(String title){
        this.title = title;
    }

    public String GetTitle(){
        return this.title;
    }


    public void SetGenre(Genre g){
        this.genre = g;
    }

    public Genre GetGenre(){
        return this.genre;
    }

    public void SetAuthor(String author){
        this.author = author;
    }

    public String GetAuthor(){
        return this.author;
    }

}
