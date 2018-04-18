/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {
    protected int x;        // to store x position
    protected int y;        // to store y position
    protected int width;    // to store width position
    protected int height;   // to store height position
    protected int xSpeed;   // to store x speed
    protected int ySpeed;   // to store y speed
    
    /**
     * Set initial values to create the item
     * @param x <b>x</b> position of the object
     * @param y <b>y</b> position of the object
     * @param width <b>width</b> of the object
     * @param height <b>height</b> of the object
     * @param xSpeed <b>x speed</b> of the object
     * @param ySpeed <b>y speed</b> of the object
     */
    public Item(int x, int y, int width, int height, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    /**
     * Get x value
     * @return x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Get middle x value
     * @return x+(width/2)
     */
    public int getXMiddle() {
        return x+getWidth()/2;
    }
    
    /**
     * Get final x value
     * @return x+width
     */
    public int getXFinal() {
        return x+getWidth();
    }
    
    /**
     * Get y value
     * @return y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Get y value
     * @return y+(height/2)
     */
    public int getYMiddle() {
        return y+getHeight()/2;
    }
    
    /**
     * Get y value
     * @return y+height
     */
    public int getYFinal() {
        return y+getHeight();
    }
    
    /**
     * Set x value
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y value
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    
    /**
     * Get width value
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Get height value
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set width value
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Set height value
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Get xSpeed value
     * @return xSpeed
     */
    public int getXSpeed() {
        return xSpeed;
    }
    /**
     * Get ySpeed value
     * @return ySpeed
     */
    public int getYSpeed() {
        return ySpeed;
    }
    
    /**
     * Set xSpeed value
     * @param xSpeed
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    /**
     * Set ySpeed value
     * @param ySpeed
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    /**
     * To check if and item intersects another item
     * @param obj
     * @return boolean
     */
    public boolean intersects(Object obj){
        // Check if the object is an Item and it intersects
        return (obj instanceof Item && this.getRectangle().intersects(((Item) obj).getRectangle()));
    }
    
    /**
     * Get rectangle
     * @return rectangle
     */
    public Rectangle getRectangle(){
        return new Rectangle(getX(),getY(),getWidth(),getHeight());
    }
    
    /**
     * To update positions of the item for every tick
     */
    public abstract void tick();
    
    /**
     * To paint the item
     * @param g <b>Graphics</b> object to paint the item
     */
    public abstract void render(Graphics g);
}
