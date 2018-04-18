/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Files {

    public static void loadFile(Game g) {
        BufferedReader br = null;
        FileReader fr = null;
        String line;
        try {
            fr = new FileReader("save.txt");
            br = new BufferedReader(fr);
            line = br.readLine();
            // Separate by commas
            // Insert code
            String[] elements = line.split(",");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveFile(Game g) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("save.txt"));
            // Insert code
            printWriter.close();
        } catch (IOException ioe) {
            //Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ioe);
            System.out.println("No space left on disk" + ioe.toString());
        }

    }
}
