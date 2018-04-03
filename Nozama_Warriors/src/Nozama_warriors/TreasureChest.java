package Nozama_warriors;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by 160538L on 8/22/2017.
 */
public class TreasureChest {

    public String update(Warrior warrior) {
        Grid.notreached = false;                                                                                        // telling others to Stop with this
        // Writing the Winners details in the Text document
        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter("Winner .txt"))) {
                out.write(warrior.getName() + " Finish the task");
            }
        } catch (IOException e) {
        }
        // Returning the winning details
        return (warrior.getName() + " Finish the task \n" + "Misson Accomplished...\n" + "\n" + "\n" + "\n" + "© Shady Studio");
    }

}


