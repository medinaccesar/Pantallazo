package pantallazo;

import java.util.logging.Level;
import java.util.logging.Logger;
import pantallazo.utilidades.Herramientas;

/**
 * Permite hacer capturas de pantalla por línea de comandos aplicando un retardo.
 * Admite parámetros, ver ayuda: java -jar Pantallazo.jar -a
 *
 * @author César M.
 */
public class Principal {

    /**
     * Método principal.
     * @param args Los argumentos de la llínea de comandos
     * 
     * Nota: para ejecutarlo en win usar -Dfile.encoding=cp850    
     */
    public static void main(String[] args) {
       
        Parametros param = new Parametros();  

        //Si no es Win se considera Linux.      
        param.establecerEsLinux(!Herramientas.dameSistemaOperativo().toUpperCase().equals("WIN"));

        procesarArgumentos(args, param);

        Captura cap = new Captura();
        
        try {
            if(param.hayRetardo()){
                Herramientas.pausa(param.dameTiempoDeRetardo());
            }
            cap.capturarPantalla(param.dameDestinoFinal());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Procesa los argumentos.
     * @param args String Argumentos
     * @param param Parametros 
     */
    private static void procesarArgumentos(String[] args, Parametros param) {
        
        boolean nombreObligatorio = false;
        boolean nombreAportado    = false;
        int longitud              = args.length;

        for (int i = 0; i < longitud; i++) {
            String comando = args[i];

            if (comando.equals("-d")) {

                if (Herramientas.existeSiguienteParametro(i, longitud)) {

                    if (!args[i + 1].startsWith("-")) {
                       establecerDestino(param,args[i + 1]);
                    }
                    else mostrarAyuda();

                }else System.out.println("El modificador -d requiere un parámetro, se ignora");

            } else if (comando.equals("-nf")) {

                param.noEstablecerFecha();
                nombreObligatorio=true;

            } else if (comando.equals("-n")) {

                if (Herramientas.existeSiguienteParametro(i, longitud)) {                    
                    if (!args[i + 1].startsWith("-")) {   

                        param.establecerNombre(args[i + 1]);
                        nombreAportado=true;

                    }else mostrarAyuda();

                }else System.out.println("El modificador -n requiere un parámetro, se ignora.");

            }else if (comando.equals("-r")) {

                if (Herramientas.existeSiguienteParametro(i, longitud)) {        

                    if (!args[i + 1].startsWith("-")) {  

                        establecerRetardo(param,args[i+1]);   

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

    /**
     * Establece el destino donde se guarda la imagen de la captura.
     * @param param Parametros
     * @param destino String directorio
     */
    private static void establecerDestino(Parametros param, String destino){
        
        String dir = System.getProperty("user.home");
        if(!param.esLinux()){                           
            dir = dir.replaceAll("\\\\", "\\\\\\\\");  
        }
        param.establecerDestino(destino.replaceFirst("~", dir));
    }

    /**
     * Establece un retardo.
     * @param param Parametros
     * @param tiempo String 
     */
    private static void establecerRetardo(Parametros param, String tiempo){
       try {
            int tpo = Integer.parseInt(tiempo);
            param.establecerRetardo(tpo);
        } catch (NumberFormatException ee) {
            System.out.println("Argumento -r con error. Se ejecuta sin retardo.");            
        }       
    }

    /**
     * Muestra la ayuda.
     * 
     */
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
