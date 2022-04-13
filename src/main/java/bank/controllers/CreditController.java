package bank.controllers;

import bank.entity.Client;
import bank.entity.Credit;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import static bank.service.CreditServiceImpl.*;
import static bank.service.ClientServiceImpl.*;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private static Client client = null;

    @RequestMapping(value = "find{passportNumber}", method = RequestMethod.GET)
    public ModelAndView findClient(@PathVariable String passportNumber, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", new Client());
        if((client = newClientService().getClientByPassport(passportNumber)) == null){
            bindingResult.rejectValue("passportNumber", "client is not exist. " +
                    "Verify passport' data");
        }
        modelAndView.setViewName("saveCredit");
        return modelAndView;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView saveCredit(Credit credit, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveCredit");
        if(client == null){
            bindingResult.rejectValue("credit.creditsLimit",
                    "client in not exist or does not chosen. Please verify");
        }
        else{
        client.addCredit(credit);
            modelAndView.addObject("credit", new Credit());
            newCreditService().saveCredit(credit);}
        return modelAndView;
    }
}
