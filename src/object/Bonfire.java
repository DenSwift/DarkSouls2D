package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bonfire extends  SuperObject {

    public Bonfire() {
        name = "Bonfire";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bonfire.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
