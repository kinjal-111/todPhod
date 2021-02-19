
package todphod.core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
    public static byte[] toBytes(BufferedImage image) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", stream);
        } catch(IOException e) {
            // This *shouldn't* happen with a ByteArrayOutputStream, but if it
            // somehow does happen, then we don't want to just ignore it
            throw new RuntimeException(e);
        }
        return stream.toByteArray();
    }
    
    public static BufferedImage toImage(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
