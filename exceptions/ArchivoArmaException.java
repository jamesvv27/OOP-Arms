package exceptions;

public class ArchivoArmaException extends Exception
{
    public ArchivoArmaException(
            final String mensaje,
            final Throwable causa
    ){
        super(mensaje, causa);
    }
}
