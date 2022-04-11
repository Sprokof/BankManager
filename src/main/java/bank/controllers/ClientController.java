package bank.controllers;

import bank.entity.Client;
import bank.service.ClientService;
import bank.service.ClientServiceImpl;
import bank.validate.FieldsContainer;
import bank.validate.ValidateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    private static final FieldsContainer container = new FieldsContainer();

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView saveClient(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("save");
        return modelAndView;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveClient(Client client, BindingResult bindingResult){
    String fieldWithError;
        Client isExistClient = ClientServiceImpl.
                newClientService().getClientByPassport(client.getPassportNumber());
        if(isExistClient != null) {
            bindingResult.rejectValue("firstName", "Client already added");}
        if((fieldWithError = ValidateClient.isCorrect(client)) != null){
        bindingResult.rejectValue(fieldWithError, container.getErrorMessage(fieldWithError));
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", new Client());
        ClientServiceImpl.newClientService().saveClient(client);
        modelAndView.setViewName("save");
        return modelAndView;

    }

}
