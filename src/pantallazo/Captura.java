package pantallazo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Crea un fichero de imagen con la captura de pantalla.
 *
 * @author César M.
 */
public class Captura {
        
    public void capturarPantalla(String fileName) throws Exception {
       
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        
        ImageIO.write(image, "png", new File(fileName));
       
    }
    
}
