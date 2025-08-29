package exceptions;

public class UsuarioInexistentException extends Exception {
    public UsuarioInexistentException(String mensagem) {
        super(mensagem);
    }
}
