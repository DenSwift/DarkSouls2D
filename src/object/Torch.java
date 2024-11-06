package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Torch  extends SuperObject {
    public Torch() {
        name = "Torch";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Torch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
