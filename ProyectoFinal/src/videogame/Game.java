/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements Runnable {

    private BufferStrategy bs;          // to have several buffers when displaying
    private Graphics g;                 // to paint objects
    private Display display;            // to display in the game
    String title;                       // title of the window
    private int width;                  // width of the window
    private int height;                 // height of the window
    private Thread thread;              // thread to create the game
    private boolean running;            // to set the game
    private Player player;              // to use a player
    private KeyManager keyManager;      // to manage the keyboard
    private boolean gameOver;           // to manage when player loses
    private boolean gameWin;            // to manage when player wins
    private boolean paused;             // to manage when paused
    private int stage;                  // to manage when is on menu

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        gameOver = false;
        gameWin = false;
        paused = false;
        stage = 0;
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, width, height);
        Assets.init();
        player = new Player(
                getWidth() / 2 - 50, getHeight() - 50, // x position, y position
                100, 35, // width, height
                50, 50, // xspeed, yspeed
                this);
        display.getJframe().addKeyListener(keyManager);
    }

    private void restart() {
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 60;
        //  time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        //  initializing delta
        double delta = 0;
        //  define now to use inside the loop
        long now;
        //intializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            //  setting the time now to the actual time
            now = System.nanoTime();
            //  acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            //  updating the last time
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    /**
     * To get Player
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * To get KeyManager
     *
     * @return keyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    private void tick() {
        // Always check keyManager
        keyManager.tick();
        // If game already stageed
        if(stage < 4){
            if (this.getKeyManager().getSpace()) {
                    stage++;
                }        
        }
        else if(stage == 4){
            player.tick();
            if(this.getPlayer().getX() < 235 && this.getPlayer().getY() < 260){
                stage++;
                this.getPlayer().setX(525);
                this.getPlayer().setY(getHeight() - 120);
            }
        }
        else{
            //Check player positin inside arcade
            if(!gameOver){
                if(this.getPlayer().getX() > 250 && this.getPlayer().getX() < 420 && 
                        this.getPlayer().getY() > 620){
                    stage++;
                }
            }
            if (!gameOver && !gameWin) {
            // Check for pause
            if (keyManager.getP()) {
                if (!paused) {
                    paused = true;
                } else {
                    paused = false;
                }
            }
            // Items things
            if (!paused) {
                player.tick();
                
                if (this.getKeyManager().getSpace()) {
                    //Add code
                }
            } // If paused
            else {
//                // Load file
//                if (keyManager.getL()) {
//                    Files.loadFile(this);
//                }
//                // Save file
//                if (keyManager.getS()) {
//                    Files.saveFile(this);
//                }
            }
        } // If GameOver (win or lose)
        else {
            // Restart ame
            if (keyManager.getR()) {
                restart();
                gameOver = false;
                gameWin = false;
            }
        }
        }
    }

    private void render() {
        // get the buffer strategy from display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display
        every image of the game but
        after clearing the Rectanlge, gettinga the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if(stage == 0){
                g.drawImage(Assets.backgroundStart, 0, 0, width, height, null);
            }
            if (!gameOver && !gameWin) {
                if(stage == 1){
                    g.drawImage(Assets.backgroundChat1, 0, 0, width, height, null);
                }
                if(stage == 2){
                    g.drawImage(Assets.backgroundChat2, 0, 0, width, height, null);
                }
                if(stage == 3){
                    g.drawImage(Assets.backgroundChat3, 0, 0, width, height, null);
                }
                if(stage == 4){
                    g.drawImage(Assets.backgroundTortilla, 0, 0, width, height, null);
                    player.render(g);
                }
                if (stage == 5){
                    g.drawImage(Assets.backgroundArcade, 0, 0, width, height, null);
                    g.drawImage(Assets.arcadeMachine, 110, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 210, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 310, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 410, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 510, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 610, height/2-100, 80, 120, null);
                    g.drawImage(Assets.arcadeMachine, 710, height/2-100, 80, 120, null);
                    player.render(g);
                    if(player.getY() < 360){
                        g.drawImage(Assets.pause, width / 2 - 38, height / 2 - 38, 76, 76, null);
                    }
                    g.setColor(Color.white);
                    g.drawString("Gstats" + stage + "  aaaaa  " + getPlayer().getX() + "   " + getPlayer().getY() , 295, 100);
                    player.render(g);
                }
            } // Player lost
            else if (gameOver) {
//                g.drawImage(Assets.backgroundLose, 0, 0, width, height, null);
            } // Player won
            else {
//                g.drawImage(Assets.backgroundWin, 0, 0, width, height, null);
            }
            //Display info
            g.setColor(Color.white);
//            g.drawString("Gstats" + stage + "  aaaaa  " + getPlayer().getX() + "   " + getPlayer().getY() , 295, 100);
            //g.drawImage(Assets.pause, 650, 22, 76, 50, null);
            if (paused) {
                g.setFont(new Font("Consolas", Font.BOLD, 30));
                g.setColor(Color.white);
                g.drawImage(Assets.pause, width / 2 - 38, height / 2 - 38, 76, 76, null);
                g.drawString("Press 'L' to load game", width / 2 - 130, height / 2 + 100);
                g.drawString("Press 'S' to save game", width / 2 - 130, height / 2 + 150);
            }
            bs.show();
            g.dispose();
        }

    }

    /**
     * setting the thread for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
