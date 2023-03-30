package pojos;

public class Mensaje {
    private boolean error;
    private String mensaje;

    public Mensaje(String mensaje, boolean error) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public Mensaje() {
        
    }

   
    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}


