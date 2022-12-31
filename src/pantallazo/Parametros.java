package pantallazo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

/**
 * Encapsula los parámetros permitidos.
 *
 * @author César M.
 */
public class Parametros {
    
    private String destino;
    private String fecha;
    private String nombre;
    private boolean hayQueEstablecerFecha;
    private boolean esLinux;
    private int tiempoDeRetardo;
    private boolean hayRetardo;
    
    
    public Parametros() {

        this.destino                = "";       
        this.nombre                 = "";  
        this.hayQueEstablecerFecha  = true;
        this.hayRetardo             = false;
        fecha();
    }

    public void establecerDestino(String destino) {       
        this.destino = destino+File.separator;
    }
    
    public void noEstablecerFecha() {
        this.hayQueEstablecerFecha=false;
    }
    
    private void fecha() {
        Date fechaActual = new Date();       
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy-HHmmss");      
        this.fecha = formatoFecha.format(fechaActual);
    }

    public void establecerNombre(String nombre) {
        this.nombre=nombre;
    }
    
    public String dameDestinoFinal(){    
        return this.destino+this.nombre+((hayQueEstablecerFecha)?this.fecha:"")+".png";    
    }

    public void establecerLinux(boolean b) {
        this.esLinux=b;
    }

    public boolean esLinux() {
        return this.esLinux;
    }

    public void establecerRetardo(int tpo) {
        this.tiempoDeRetardo=tpo;
        this.hayRetardo=true;
    }

    public int dameTiempoDeRetardo() {
        return tiempoDeRetardo;
    }

    public boolean hayRetardo() {
        return hayRetardo;
    } 
    
}
