/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Item {

    private Game game;              // runs game

    public Player(int x, int y, int width, int height, int xSpeed, int ySpeed, Game game) {
        super(x, y, width, height, xSpeed, ySpeed); // assigns x and y, width and height
        this.game = game;
    }

    @Override
    public void tick() {
        //Movement
        if (game.getKeyManager().getLeft()) {
            setX(getX() - xSpeed);
        }
        if (game.getKeyManager().getRight()) {
            setX(getX() + xSpeed);
        }
        if (game.getKeyManager().getUp()) {
            setY(getY() - ySpeed);
        }
        if (game.getKeyManager().getDown()) {
            setY(getY() + ySpeed);
        }

        // reset x position and y position if colision
        if (getX() + getWidth() >= game.getWidth()) {
            setX(game.getWidth() - getWidth());
        } else if (getX() <= 0) {
            setX(0);
        }
        if (getY() + getHeight() >= game.getHeight()) {
            setY(game.getHeight() - getHeight());
        } else if (getY() <= 1) {
            setY(1);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), 20);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);

    }

}
