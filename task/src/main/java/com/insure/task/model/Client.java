package com.insure.task.model;

import com.insure.task.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;

public class Client {
    String id;
    String contact;
    String contactMethod;
    BookshelfService bookshelf;

    public BookshelfService getBookshelf() {
        return bookshelf;
    }

    public Client(String contact, String id, String contactMethod) {
        this.contact = contact;
        this.id = id;
        this.contactMethod = contactMethod;
        bookshelf = new BookshelfService();
    }

    public String addBook(int id) {
        return bookshelf.addBook(id);
    }

    public String removeBook(int id) {
        return bookshelf.removeBook(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}
