package bank.validate;

import java.util.HashMap;

import static bank.validate.Fields.*;

public class FieldsContainer {
    private final HashMap<String, String> container = new HashMap<>();

   public FieldsContainer(){
         this.container.put(PASSPORT.getFieldName(), "Wrong passport format. It must be in next " +
                 "view 00 00 00");
         this.container.put(EMAIL.getFieldName(), "Wrong email format. Please verify");
         this.container.put(PHONE.getFieldName(), "Wrong phone format. Please verify");
    }

   public String getErrorMessage(String fieldName){
        return this.container.get(fieldName);
   }
}
