package bank.dao;

import bank.entity.Credit;

public interface CreditDAO {
    void saveCredit(Credit credit);
    Credit getCreditById(int id);
    void updateCredit(Credit credit);
    void deleteCredit(Credit credit);
}
