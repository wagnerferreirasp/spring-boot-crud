package poc.wagner.exception;

public class BusinessException extends Exception {
    public BusinessException(String mensagem) {
        super(mensagem);
    }
}
