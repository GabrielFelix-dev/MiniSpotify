package exceptions;

public class PlaylistInvalidaException extends Exception {
    public PlaylistInvalidaException(String mensagem) {
        super(mensagem);
    }
}