package com.insure.task.model;

public class Book {
    private String name;
    private String author;
    private String genre;
    private double price;
    private int id;

    public Book(int num) {
        this.id = num;
        switch (num) {
            case 1:
                this.genre = "Fiction";
                this.name = "The Great Gatsby";
                this.author = "F. Scott Fitzgerald";
                this.price = 10.99;
                break;
            case 2:
                this.genre = "Mystery";
                this.name = "The Da Vinci Code";
                this.author = "Dan Brown";
                this.price = 12.50;
                break;
            case 3:
                this.genre = "Science Fiction";
                this.name = "Dune";
                this.author = "Frank Herbert";
                this.price = 14.75;
                break;
            case 4:
                this.genre = "Fantasy";
                this.name = "The Hobbit";
                this.author = "J.R.R. Tolkien";
                this.price = 11.25;
                break;
            case 5:
                this.genre = "Non-fiction";
                this.name = "Sapiens: A Brief History of Humankind";
                this.author = "Yuval Noah Harari";
                this.price = 13.99;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
