package bank.validate;

import bank.entity.Client;
import lombok.NoArgsConstructor;
import static bank.validate.Fields.*;

@NoArgsConstructor
public class ValidateClient {

    public static String isCorrect(Client client) {

        if(!client.getPassportNumber().matches("[0-9]{2}//s[0-9]{2}//s[0-9]{6}")){
            return PASSPORT.getFieldName();
        }
        if(!client.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+" +
                "(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")){
        return EMAIL.getFieldName();
        }
        if(!client.getPhoneNumber().matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|" +
                "\\(\\d{3}\\)\\d{3}-?\\d{4}")){
            return PHONE.getFieldName();
        }
    return null;

    }


}
