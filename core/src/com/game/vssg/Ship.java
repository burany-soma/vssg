package com.game.vssg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ship extends Sprite {

    private Vector2 position;
    private float speed;
    private boolean active;
    Texture greenLaserTexture = new Texture("laser_green.png");

    public Ship(Texture texture, float x, float y, float speed) {
        super(texture);
        this.position = new Vector2(x, y);
        this.speed = speed;

        active = true;
    }

    public void update(float delta) {
        if (active) {
            Vector2 velocity = new Vector2(speed, 0).setAngleDeg(getRotation());
            position.add(velocity.x * delta, velocity.y * delta);

            // Check if the ship is out of screen bounds and deactivate it if necessary
            if (position.x > Gdx.graphics.getWidth() || position.y > Gdx.graphics.getHeight()) {
                active = false;
            }

            // Update the sprite's position
            setPosition(position.x, position.y);
        }
    }

    public float getSpeed(){

        return this.speed;
    }

    public void setSpeed(float s) {
        this.speed = s;
        System.out.println("Speed is "+speed);
    }
    public Laser fireLaser(Ship ship) {
        float offsetX = -10;
        float offsetY = -1.5f;

        Vector2 laserPosition = new Vector2(ship.getX() + ship.getOriginX() + offsetX, ship.getY() + ship.getOriginY() + offsetY);
        Laser laser = new Laser(greenLaserTexture, laserPosition, ship.getRotation(), 500);
        laser.setPosition(laserPosition.x, laserPosition.y);
        laser.setScale(0.5f);
        return laser;
    }




public boolean isActive(){

    return active;
}


}
