package pantallazo.utilidades;

/**
 * Distintas utilidades.
 *
 * @author César M.
 */
public class Herramientas {

    /**
     * Obtiene las tres primeras letras de la identificación del sistema operativo.
     */
    public static String dameSistemaOperativo() {

        return System.getProperty("os.name").substring(0, 3);
    }
    
    /**
     * Aplica una pausa en milisegundos.
     */
    public static void pausa(long tiempo){

        long milisInicio = System.currentTimeMillis();
        long milisFin =0;
        do{
            milisFin = System.currentTimeMillis();
        }while(tiempo > milisFin - milisInicio);
     }
        
}
