package com.insure.task.controller;

import com.insure.task.service.BookshelfService;
import com.insure.task.service.ClientService;
import com.insure.task.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public String products() {
        if (UserSessionService.getLoggedStatus()) {
            BookshelfService bookshelfService = clientService.getClient(UserSessionService.getUserId())
                    .getBookshelf();
            if (bookshelfService != null)
                return clientService.getClient(UserSessionService.getUserId()).getBookshelf().toString();
            else
                return "Bookshelf is empty!";
        } else {
            return "Not authorized, must log in first";
        }
    }

    @PostMapping("/add")
    public String addBook(@RequestParam Integer id) {
        if (UserSessionService.getLoggedStatus()) {
            return clientService.getClient(UserSessionService.getUserId()).addBook(id);
        } else {
            return "Not authorized, must log in first";
        }
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam Integer id) {
        if (UserSessionService.getLoggedStatus()) {
            return clientService.getClient(UserSessionService.getUserId()).removeBook(id);
        } else {
            return "Not authorized, must log in first";
        }
    }
}