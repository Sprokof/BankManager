package bank.dao;

import bank.entity.Client;

public interface ClientDAO {
    void saveClient(Client client);
    Client getClientById(int id);
    void updateClient(Client client);
    void deleteClient(Client client);
    Client getClientByPassportNumber(String passportNumber);
}
