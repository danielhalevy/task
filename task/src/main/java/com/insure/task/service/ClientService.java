package com.insure.task.service;

import com.insure.task.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    private List<Client> clients = new ArrayList<>();

    public Client getClient(String id) {
        for (int i = 0; i < clients.size(); i++) {
            if (Objects.equals(clients.get(i).getId(), id)) {
                return clients.get(i);
            }
        }
        return null;
    }

    public List<Client> getClients() {
        return clients;
    }

    public String addClient(Client client) {
        if(getClient(client.getId())!=null)
            return "Client with this id already exists!";
        else
            clients.add(client);
        return "Client added successfully!";
    }
}
