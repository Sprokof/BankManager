package bank.validate;

public enum Fields {
    EMAIL("email"),
    PASSPORT("passportNumber"),
    PHONE("phoneNumber");

    String fieldName;

    Fields(String fieldName){
        this.fieldName = fieldName;
    }

    String getFieldName(){
        return fieldName;
    }
}
