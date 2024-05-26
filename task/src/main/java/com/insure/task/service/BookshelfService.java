package com.insure.task.service;

import com.insure.task.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class BookshelfService {
    private Set<Book> books = new HashSet<>();

    public String addBook(int id) {
        if (contains(id)) {
            return "Book already exists on the bookshelf.";
        } else {
            try {
                Book book = new Book(id);
                books.add(book);
                return "Book added to the bookshelf.";
            } catch (IllegalArgumentException e) {
                return "Invalid input. Number must be between 1 and 5.";
            }
        }
    }

    public String removeBook(int id) {
        if (contains(id)) {
            books.remove(getBook(id));
            return "Book removed from the bookshelf.";
        } else {
            return "Book does not exist on the bookshelf.";
        }
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        if (!books.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Book book : books) {
                sb.append(book.toString()).append("\n");
            }
            return sb.toString();
        } else
            return "Bookshelf is empty!";
    }

    public boolean contains(int id) {
        return getBook(id) != null;
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

}
