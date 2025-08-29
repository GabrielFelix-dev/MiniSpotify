package exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException (String mensagem){
        super(mensagem);
    }
}
