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
    
    private String  destino;
    private String  fecha;
    private String  nombre;
    private boolean hayQueEstablecerFecha;
    private boolean esLinux;
    private int     tiempoDeRetardo;
    private boolean hayRetardo;
    
    
    public Parametros() {

        this.destino                = "";       
        this.nombre                 = "";  
        this.hayQueEstablecerFecha  = true;
        this.hayRetardo             = false;
        fecha();
    }

    /**
     * Establece el destino donde se guarda la captura.
     * 
     * @param destino
     */
    public void establecerDestino(String destino) {       
        this.destino = destino+File.separator;
    }
    
    /**
     * Permite no usar la marca temporal en el nombre del archivo.
     * 
     */
    public void noEstablecerFecha() {
        this.hayQueEstablecerFecha=false;
    }
    
    /**
     * Fecha actual.
     * 
     */
    private void fecha() {
        Date fechaActual = new Date();       
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy-HHmmss");      
        this.fecha = formatoFecha.format(fechaActual);
    }

    /**
     * Nombre de la imagen.
     * 
     * @param nombre
     */
    public void establecerNombre(String nombre) {
        this.nombre=nombre;
    }
    
    /**
     * Obtiene el destino final de la imagen.
     * 
     * @return
     */
    public String dameDestinoFinal(){    
        return this.destino+this.nombre+((hayQueEstablecerFecha)?this.fecha:"")+".png";    
    }

    /**
     * Establece si el sistema operativo es linux. Se considera linux cualquiera distinto de win.
     * 
     * @param b
     */
    public void establecerEsLinux(boolean b) {
        this.esLinux = b;
    }

    /**
     * Determina si el sistema operativo es o no linux.
     * 
     * @return
     */
    public boolean esLinux() {
        return this.esLinux;
    }

    /**
     * Establece el tiempo de retardo.
     * 
     * @param tpo
     */
    public void establecerRetardo(int tpo) {
        this.tiempoDeRetardo=tpo;
        this.hayRetardo=true;
    }

    /**
     * Obtiene el tiempo d etetardo.
     * 
     * @return
     */
    public int dameTiempoDeRetardo() {
        return tiempoDeRetardo;
    }

    /**
     * Determina si hay retardo en los parámetros.
     * 
     * @return
     */
    public boolean hayRetardo() {
        return hayRetardo;
    } 
    
}
