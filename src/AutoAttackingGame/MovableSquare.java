package AutoAttackingGame;

import java.awt.*;

public class MovableSquare extends Rectangle{

    private int height = 200;
    private int width = 200;
    private double speed = 1.5;
    private int damage = 100;
    private int health = 100;

    public MovableSquare(int height, int width, int speed, int damage, int health) {
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.damage = damage;
        this.health = health;


    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
