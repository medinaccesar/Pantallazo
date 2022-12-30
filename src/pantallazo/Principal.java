/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallazo;

import java.util.logging.Level;
import java.util.logging.Logger;
import pantallazo.utilidades.Herramientas;

/**
 * Permite hacer capturas de pantalla por línea de comandos aplicando un retardo.
 * Admite parámetros, ver ayuda: java -jar Pantallazo.jar -a
 * @author César M.
 */
public class Principal {

    /**
     * @param args the command line arguments
     * 
     * 
     * Nota: para ejecutarlo en win usar -Dfile.encoding=cp850
     * 
     */
    public static void main(String[] args) {
       
        Parametros p = new Parametros();
        p.establecerLinux(!Herramientas.dameSistemaOperativo().toUpperCase().equals("WIN"));
        procesaArgumentos(args, p);
        Captura c = new Captura();
        try {
            if(p.hayRetardo()){
                Herramientas.pausa(p.dameTiempoDeRetardo());
            }
            c.capturaPantalla(p.dameDestinoFinal());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void procesaArgumentos(String[] args, Parametros p) {
        boolean nombreObligatorio=false;
        boolean nombreAportado=false;
        int longitud = args.length;
        for (int i = 0; i < longitud; i++) {
            String comando = args[i];

            if (comando.equals("-d")) {
                if ((i + 1) < longitud) {
                    if (!args[i + 1].startsWith("-")) {
                                              
                       //Directorio de usuario:
                        String dp = System.getProperty("user.home");
                        if(!p.esLinux()){                           
                            dp=dp.replaceAll("\\\\", "\\\\\\\\");  
                        }
                        p.establecerDestino(args[i + 1].replaceFirst("~", dp));
                    }
                    else mostrarAyuda();
                }else System.out.println("El modificador -d requiere un parámetro, se ignora");

            } else if (comando.equals("-nf")) {
                p.noEstablecerFecha();
                nombreObligatorio=true;
            } else if (comando.equals("-n")) {
                if ((i + 1) < longitud) {                    
                    if (!args[i + 1].startsWith("-")) {                       
                        p.establecerNombre(args[i + 1]);
                        nombreAportado=true;
                    }else mostrarAyuda();
                }else System.out.println("El modificador -n requiere un parámetro, se ignora.");
            }else if (comando.equals("-r")) {
                if ((i + 1) < longitud) {                    
                    if (!args[i + 1].startsWith("-")) {  
                        try {
                            int tpo = Integer.parseInt(args[i+1]);
                            p.establecerRetardo(tpo);
                        } catch (NumberFormatException ee) {
                            System.out.println("Argumento -r con error. Se ejecuta sin retardo.");
                           
                        }                        
                    }else mostrarAyuda();
                }else System.out.println("El modificador -r requiere un parámetro, se ignora.");
            }
           else if (comando.equals("-a") || comando.equals("-h")) mostrarAyuda();
        }
       
        if(nombreObligatorio && !nombreAportado){
            System.err.println("\n\nFalta el nombre, necesario si la captura no se nombra con fecha.");
            mostrarAyuda();
        }

    }

    
     private static void mostrarAyuda() {
       
            System.out.println(
                    "\n\t==============  Pantallazo 1.0  =====================");
            System.out.println(
                   "\tMlogicial, César Medina Cámara. Burgos, junio de 2015");
            System.out.println(
                    "\nHace una captura de pantalla en formato png, por defecto sin retardo, en el directorio actual y con la fecha como nombre.\nOpciones:");
            System.out.println(
                    "-d:  <ruta> ruta absoluta de la carpeta de destino."
                    + "Si tiene espacios va entre comillas."
                    + "Se puede usar el comodín ~ (ALT+126 o ALTGr+Ñ) para indicar el directorio del usuario actual.");            
            System.out.println(
                    "-n:  <nombre> nombre sin extensión de la captura de pantalla.");
            System.out.println(
                    "-r:  <retardo> retardo en milisegundos antes de hacer la captura de pantalla.");
            System.out.println(
                    "-nf: No usa la fecha para nombrar la captura, si se usa es obligatorio usar -n. ");
            System.out.println(
                    "-a:  muestra esta ayuda.");
            System.out.println(
                    "Uso:  java -jar Pantallazo.jar [-d <ruta>] [-n <nombre>]  [-nf] [-r <retardo>]");
            System.out.println(
                    "p.e.: java -jar Pantallazo.jar -n pantallazo -nf");
            System.out.println(
                    "      java -jar Pantallazo.jar -d \"~/Espacio de trabajo\" -n pantallazo -nf");
            System.out.println(
                    "      java -jar Pantallazo.jar -d \"~\\Mis documentos\" -n pantallazo -nf");
            System.out.println(
                   "      java -jar Pantallazo.jar -r 5000");
            System.out.println(
                   "      java -jar Pantallazo.jar \n");
            System.exit(0);       

    }     
      
}
