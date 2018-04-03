package Nozama_warriors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JPanel {
    private static ArrayList<Inhabitant> inhabitantArrayList = new ArrayList<>();
    public JFrame jf;
    GUI(JFrame jf) {
        this.jf=jf;
        jf.setTitle("Nozama Warriors");
        jf.add(this);
        jf.setVisible(true);
        jf.setBackground(new Color(0, 102,204));
        jf.setBounds(0,0,890,890);
        jf.setIconImage(new ImageIcon("C:/Users/Sabesan/Downloads/Nozama_Warriors/Warrior.png").getImage());
    }

    @Override
    public void paintComponent(Graphics g) {
        /**get the images from directory their
         * these images are used for indicate inhabitants
         * Every inhabitant has unique images
         */
        Image nwImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\W.png");
        ImageIcon nwImg1 = new ImageIcon("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\W.png");
        Image swImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\SW.png");
        Image infImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\inf.png");
        Image kfImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\kf.png");
        Image rfImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\rf.png");
        Image lfImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sabesan\\Downloads\\Nozama_Warriors\\ICON\\lf.png");

        //Draw the grid lines
        g.setColor(Color.black);
        for (int i = 50; i < 875; i += 75) {
            g.drawLine(i, 50, i, 800);
            g.drawLine(50, i, 800, i);
        }

        g.setColor(new Color(0, 0, 0));
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                g.fill3DRect((i * 75) + 45, (j * 75) + 45, 10, 10,true);
            }
        }
        g.setColor(new Color(0,255,0));
        g.fill3DRect(420,420,10,10,true);

        for (int i = 0; i < inhabitantArrayList.size(); i++) {
            if (inhabitantArrayList.get(i) instanceof InnocentFish) {
                g.drawImage(infImg, (((InnocentFish) inhabitantArrayList.get(i)).getX() * 75) + 25, (((InnocentFish) inhabitantArrayList.get(i)).getY() * 75) + 15, 50,50,this);
                //g.finalize();
            }
            else if (inhabitantArrayList.get(i) instanceof KillerFish) {
                g.drawImage(kfImg, (((KillerFish) inhabitantArrayList.get(i)).getX() * 75) + 20, (((KillerFish) inhabitantArrayList.get(i)).getY() * 75) + 20, 65,65,this);
                //g.finalize();
            }
            else if (inhabitantArrayList.get(i) instanceof RubberEatFish) {
                g.drawImage(rfImg, (((RubberEatFish) inhabitantArrayList.get(i)).getX() * 75) + 20, (((RubberEatFish) inhabitantArrayList.get(i)).getY() * 75) + 10, 65,65,this);
                //g.finalize();
            }
            else if (inhabitantArrayList.get(i) instanceof NormalWarrior) {
               g.drawImage(nwImg, (((NormalWarrior) inhabitantArrayList.get(i)).getX() * 75) + 30, (((NormalWarrior) inhabitantArrayList.get(i)).getY() * 75) + 10, 50,50,this);
                //g.finalize();
                }
            else if (inhabitantArrayList.get(i) instanceof SuperWarrior) {
                g.drawImage(swImg, (((SuperWarrior) inhabitantArrayList.get(i)).getX() * 75) + 20, (((SuperWarrior) inhabitantArrayList.get(i)).getY() * 75) + 5, 50,50,this);
                //g.finalize();
            }
                else if (inhabitantArrayList.get(i) instanceof LotusFlower) {
                    g.drawImage(lfImg, (((LotusFlower) inhabitantArrayList.get(i)).getX() * 75) + 25, (((LotusFlower) inhabitantArrayList.get(i)).getY() * 75) + 10, 50,50,this);
                    //g.finalize();
                }
            }
    }

    public static void attach(Inhabitant inhabit) {
        inhabitantArrayList.add(inhabit);
    }

    public void paintAgain() {
        jf.repaint();
    }
}