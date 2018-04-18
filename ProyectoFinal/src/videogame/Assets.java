/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

public class Assets {

    //img general
    public static BufferedImage backgroundStart;     // to store background start image
    public static BufferedImage backgroundTortilla;     // to store background tortilla image
    public static BufferedImage backgroundArcade;     // to store background arcade image
    public static BufferedImage backgroundChat1;     // to store background image
    public static BufferedImage backgroundChat2;     // to store background image
    public static BufferedImage backgroundChat3;     // to store background image
    
    public static BufferedImage pause;          // to store pause image
    //player
    public static BufferedImage player;        // to store player
    //machine
    public static BufferedImage arcadeMachine;        // to store arcadeMachine
    
    /**
     * initializing the images of the game
     */
    public static void init() {
        //img general
        backgroundStart = ImageLoader.loadImage("/images/BgStart.jpeg");
        backgroundTortilla = ImageLoader.loadImage("/images/BgTortilla.jpg");
        backgroundArcade = ImageLoader.loadImage("/images/BgArcade2.jpeg");
        backgroundChat1 = ImageLoader.loadImage("/images/BgChat1.jpeg");
        backgroundChat2 = ImageLoader.loadImage("/images/BgChat2.jpeg");
        backgroundChat3 = ImageLoader.loadImage("/images/BgChat3.jpeg");
        pause = ImageLoader.loadImage("/images/pause.png");

        //img objects
        //player
        player = ImageLoader.loadImage("/images/boyy.png");
        
        arcadeMachine = ImageLoader.loadImage("/images/maquinita.png");
    }
}
