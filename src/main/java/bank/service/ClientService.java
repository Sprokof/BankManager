package bank.service;

import bank.entity.Client;
import bank.entity.Credit;

public interface ClientService {
    void saveClient(Client client);
    Client getClientById(int id);
    void updateClient(Client client);
    void deleteClient(Client client);
    Client getClientByPassport(String passport);
    void deleteCreditById(int id);
}
