package com.insure.task.controller;

import com.insure.task.model.Client;
import com.insure.task.service.ClientService;
import com.insure.task.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @PostMapping("/signup")
    public String signup(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String contact,
                        @RequestParam String contactMethod) {
        for (Client client : clientService.getClients())
            if (client.getId().equals(id) && client.getContact().equals(contact)
            && client.getContactMethod().equals(contactMethod)) {
                UserSessionService.login(id);
                return "Logged in successfully!";
            }
        return "Invalid credentials!";
    }

    @PostMapping("/logout")
    public String logout() {
        UserSessionService.logout();
        return "Logged out successfully!";
    }

}
