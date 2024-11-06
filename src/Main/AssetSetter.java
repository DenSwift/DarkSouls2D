package Main;

import object.Bonfire;
import object.Torch;

public class AssetSetter {

    Panel p;

    public AssetSetter(Panel p) {
        this.p = p;
    }

    public void setObject() {
        p.obj[0] = new Bonfire();
        p.obj[0].worldX = 25 * p.tileSize;
        p.obj[0].worldY = 6 * p.tileSize;

        p.obj[1] = new Torch();
        p.obj[1].worldX = 27 * p.tileSize;
        p.obj[1].worldY = 5 * p.tileSize;

        p.obj[2] = new Torch();
        p.obj[2].worldX = 29 * p.tileSize;
        p.obj[2].worldY = 5 * p.tileSize;

        p.obj[3] = new Torch();
        p.obj[3].worldX = 31 * p.tileSize;
        p.obj[3].worldY = 5 * p.tileSize;

        p.obj[4] = new Torch();
        p.obj[4].worldX = 33 * p.tileSize;
        p.obj[4].worldY = 5 * p.tileSize;

        p.obj[5] = new Torch();
        p.obj[5].worldX = 35 * p.tileSize;
        p.obj[5].worldY = 5 * p.tileSize;

        p.obj[6] = new Torch();
        p.obj[6].worldX = 27 * p.tileSize;
        p.obj[6].worldY = 7 * p.tileSize;

        p.obj[7] = new Torch();
        p.obj[7].worldX = 29 * p.tileSize;
        p.obj[7].worldY = 7 * p.tileSize;

        p.obj[8] = new Torch();
        p.obj[8].worldX = 31 * p.tileSize;
        p.obj[8].worldY = 7 * p.tileSize;

        p.obj[9] = new Torch();
        p.obj[9].worldX = 33 * p.tileSize;
        p.obj[9].worldY = 7 * p.tileSize;

        p.obj[10] = new Torch();
        p.obj[10].worldX = 35 * p.tileSize;
        p.obj[10].worldY = 7 * p.tileSize;
    }
}
