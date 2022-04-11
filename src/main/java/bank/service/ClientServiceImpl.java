package bank.service;

import bank.dao.ClientDAOImpl;
import bank.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAOImpl clientDAO;
    @Override
    public void saveClient(Client client) {
        this.clientDAO.saveClient(client);
    }

    @Override
    public Client getClientById(int id) {
        return this.clientDAO.getClientById(id);
    }

    @Override
    public void updateClient(Client client) {
        this.clientDAO.updateClient(client);
    }

    @Override
    public void deleteClient(Client client) {
        this.clientDAO.deleteClient(client);
    }

    @Override
    public void deleteCreditById(int id) {
        this.deleteClient(this.getClientById(id));
    }

    @Override
    public Client getClientByPassport(String passport) {
        return this.clientDAO.getClientByPassportNumber(passport);
    }

    public static ClientServiceImpl newClientService(){
        return newClientService();
    }
}
