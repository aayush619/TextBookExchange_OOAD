package com.example.ali.loginregister;


import java.io.Serializable;

/**
 * Created by zhangshuzhe on 11/16/15.
 */
public class Book extends schoolRalatedItem implements Serializable {

    private String owner_name;
    private String title;
    private String author;
    private String description;
    private String price;
    private String owner_Email;
    private String owner_Phone;

    public String getOwner_name() {
        return owner_name;
    }
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String owner_name) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getOwner_Email() {
        return owner_Email;
    }
    public void setOwner_Email(String owner_Email) {
        this.owner_Email = owner_Email;
    }

    public String getOwner_Phone() {
        return owner_Phone;
    }
    public void setOwner_Phone(String owner_Phone) {
        this.owner_Phone = owner_Phone;
    }

    public Book(){}

    public Book(String Owner_name,String Title,String Author,String Description,String Price,String Owner_Email,String Owner_Phone) {
        owner_name = Owner_name;
        title = Title;
        author = Author;
        description = Description;
        price = Price;
        owner_Email = Owner_Email;
        owner_Phone = Owner_Phone;
    }

    public void post(){
        addBook();
    }
    public void delete(){

    }
    public boolean addBook(){
        DatabaseManager DbMan = DatabaseManager.getInstance();
        DbMan.addBook(owner_name,title,author,description,price,owner_Email,owner_Phone);
        return true;
    }





}