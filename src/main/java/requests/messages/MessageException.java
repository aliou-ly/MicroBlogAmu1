package requests.messages;

public class MessageException extends Exception {

    public MessageException() {

    }
    public MessageException(String messageError) {
        super(messageError);
    }

    public Messages checker(Messages message) throws MessageException {

        excessCharacters(message);
        return message;
    }

    private void excessCharacters(Messages message) throws MessageException {
        boolean isExceeded = (message.toString().length() > 256);

        if (isExceeded) throw new MessageException("Dépassement de limite de Caractere");
    }

}
