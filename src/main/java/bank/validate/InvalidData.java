package bank.validate;

public class InvalidData extends Exception{

    private final String firstMessage;
    private final String secondMessage;

    public InvalidData(String firstMessage, String secondMessage) {
        this.firstMessage = firstMessage;
        this.secondMessage = secondMessage;
    }
}
