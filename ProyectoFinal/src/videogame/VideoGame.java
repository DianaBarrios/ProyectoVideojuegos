/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

public class VideoGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Creating a Game object
        Game g = new Game("Game Over Food", 960, 720);
        // Initializing the game
        g.start();
    }

}
