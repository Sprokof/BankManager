package bank.service;

import bank.dao.CreditDAOImpl;
import bank.entity.Credit;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditServiceImpl implements CreditService{

    @Autowired
    private CreditDAOImpl creditDAO;

    @Override
    public void saveCredit(Credit credit) {
        this.creditDAO.saveCredit(credit);

    }

    @Override
    public Credit getCreditById(int id) {
        return this.creditDAO.getCreditById(id);
    }

    @Override
    public void updateCredit(Credit credit) {
        this.creditDAO.updateCredit(credit);
    }

    @Override
    public void deleteCredit(Credit credit) {
        this.creditDAO.deleteCredit(credit);
    }

    @Override
    public void deleteCreditById(int id) {
        this.deleteCredit(this.getCreditById(id));
    }
}
