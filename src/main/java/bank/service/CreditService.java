package bank.service;

import bank.entity.Credit;

public interface CreditService {
    void saveCredit(Credit credit);
    Credit getCreditById(int id);
    void updateCredit(Credit credit);
    void deleteCredit(Credit credit);
    void deleteCreditById(int id);
}
