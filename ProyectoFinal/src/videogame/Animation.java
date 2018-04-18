/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed;                  // for the speed of every frame
    private int index;                  // to get the index of next frame ti paint
    private long lastTime;              // to save the previous time of the animation
    private long timer;                 // to acumulate the time of the animation
    private BufferedImage[] frames;     // to store every image - frame
    
    /**
     * Creating the animation with all the frames and the speed for each
     * @param frames an <code>array</code> of images
     * @param speed an <code>int</code> value for the speed of every frame
     */
    public Animation(BufferedImage[] frames, int speed){
        this.frames = frames; // storing frames
        this.speed = speed; // storing speed
        index = 0;  // Initializing index
        timer = 0;  // Initializing timer
        lastTime = System.currentTimeMillis();  // Getting the initial time
    }
    
    /**
     * Getting the current frame to paint
     * @return the <code> BufferedImage</code> to the corresponding frame to paint
     */
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
    
    /**
     * To update the animation to get the right index of the frame to paint
     */
    public void tick(){
        // Acumulating time from the previous tick to this one
        timer += System.currentTimeMillis() - lastTime;
        // Updating the lastTime for the next tick
        lastTime = System.currentTimeMillis();
        // Check the itmer to increase the index
        if(timer > speed){
            index++;
            timer = 0;
            // Check index not to get out of bounds
            if(index >= frames.length){
                index = 0;
            }
        }
    }
}
