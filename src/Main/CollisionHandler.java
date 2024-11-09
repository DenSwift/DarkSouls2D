package Main;

import Entitiy.Entity;

import java.awt.*;
public class CollisionHandler {
    Panel p;
    public CollisionHandler(Panel p) {
        this.p = p;
    }
    public int checkObject(Entity entity, boolean player) {
        int index = 999; // default value if no collision is detected

        for (int i = 0; i < p.obj.length; i++) {
            if (p.obj[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = entity.worldx + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldy + entity.solidAreaDefaultY;

                // Get the object's solid area position
                p.obj[i].solidArea.x = p.obj[i].worldX + p.obj[i].solidAreaDefaultX;
                p.obj[i].solidArea.y = p.obj[i].worldY + p.obj[i].solidAreaDefaultY;

                // Adjust entity's solid area based on its direction and check for intersection
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }

                // Check for collision
                if (entity.solidArea.intersects(p.obj[i].solidArea)) {
                    if (player) {
                        index = i; // if player is colliding, return the index of the object
                    }
                    entity.collisionOn = true; // set collision flag
                }

                // Reset solid area positions to default after each check
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                p.obj[i].solidArea.x = p.obj[i].solidAreaDefaultX;
                p.obj[i].solidArea.y = p.obj[i].solidAreaDefaultY;

                // Stop checking further if a collision is detected
                if (index != 999) {
                    break;
                }
            }
        }

        return index;
    }
    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999; // default value if no collision is detected

        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = entity.worldx + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldy + entity.solidAreaDefaultY;

                // Get the object's solid area position
                target[i].solidArea.x = target[i].worldx + target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].worldy + target[i].solidAreaDefaultY;

                // Adjust entity's solid area based on its direction and check for intersection
                if (entity.direction.equals("left")) {
                    entity.solidArea.x -= entity.speed;
                    if (entity.solidArea.intersects(target[i].solidArea)) {
                        entity.collisionOn = true;
                        index = i;
                    } else if(entity.direction.equals("right")) {
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(p.player.solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                    }
                }
                // Reset solid area positions to default after each check
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    public boolean checkPlayer(Entity entity) {
        // Get entity's solid area position
        entity.solidArea.x = entity.worldx + entity.solidAreaDefaultX;
        entity.solidArea.y = entity.worldy + entity.solidAreaDefaultY;

        // Get the object's solid area position
        p.player.solidArea.x = p.player.worldx + p.player.solidAreaDefaultX;
        p.player.solidArea.y = p.player.worldy + p.player.solidAreaDefaultY;
       // Adjust entity's solid area based on its direction and check for intersection
        if (entity.direction.equals("left")) {
            entity.solidArea.x -= entity.speed;
            if (entity.solidArea.intersects(p.player.solidArea)) {
                entity.collisionOn = true;
                return true;
            }
        }

        if(entity.direction.equals("right")) {
            entity.solidArea.x += entity.speed;
            if (entity.solidArea.intersects(p.player.solidArea)) {
                entity.collisionOn = true;
                return true;
            }
        }
        // Reset solid area positions to default after each check
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        p.player.solidArea.x = p.player.solidAreaDefaultX;
        p.player.solidArea.y = p.player.solidAreaDefaultY;

        return  false;
    }
}

