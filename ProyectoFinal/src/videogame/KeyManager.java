/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
    private boolean left;       // flag to left move the player
    private boolean right;      // flag to right move the player
    private boolean up;       // flag to up move the player
    private boolean down;      // flag to down move the player
    private boolean p;          // flag to pause
    private boolean r;          // flag to restart
    private boolean s;          // flag to save
    private boolean l;          // flag to load
    private boolean space;      // flag to shoot
    
    private boolean keys[]; // to store all the flags for every key
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        // set true to every key pressed
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_P 
                || e.getKeyCode() == KeyEvent.VK_R || e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_L || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[e.getKeyCode()] = false;
        }
        else{
            keys[e.getKeyCode()] = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        // set true to every key released
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_P 
                || e.getKeyCode() == KeyEvent.VK_R || e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_L || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[e.getKeyCode()] = true;
        }
        else{
            keys[e.getKeyCode()] = false;
        }
    }
    
    /**
     * To enable or disable moves on every tick
     */
    public void tick() {
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        p = keys[KeyEvent.VK_P];
        r = keys[KeyEvent.VK_R];
        s = keys[KeyEvent.VK_S];
        l = keys[KeyEvent.VK_L];
        space = keys[KeyEvent.VK_SPACE];
        //to reset
        keys[KeyEvent.VK_P] = false;
        keys[KeyEvent.VK_R] = false;
        keys[KeyEvent.VK_UP] = false;
        keys[KeyEvent.VK_DOWN] = false;
        keys[KeyEvent.VK_RIGHT] = false;
        keys[KeyEvent.VK_LEFT] = false;
        keys[KeyEvent.VK_S] = false;
        keys[KeyEvent.VK_L] = false;
        keys[KeyEvent.VK_SPACE] = false;
    }
    /**
     * Get VK_LEFT status
     * @return left
     */
    public boolean getLeft(){
        return left;
    }
    /**
     * Get VK_RIGHT status
     * @return right
     */
    public boolean getRight(){
        return right;
    }
    /**
     * Get VK_UP status
     * @return up
     */
    public boolean getUp(){
        return up;
    }
    /**
     * Get VK_DOWN status
     * @return down
     */
    public boolean getDown(){
        return down;
    }
    /**
     * Get VK_P status
     * @return p
     */
    public boolean getP(){
        return p;
    }
    /**
     * Get VK_R status
     * @return r
     */
    public boolean getR(){
        return r;
    }
    /**
     * Get VK_S status
     * @return s
     */
    public boolean getS(){
        return s;
    }
    /**
     * Get VK_L status
     * @return l
     */
    public boolean getL(){
        return l;
    }
    /**
     * Get VK_SPACE status
     * @return space
     */
    public boolean getSpace(){
        return space;
    }
    
}
