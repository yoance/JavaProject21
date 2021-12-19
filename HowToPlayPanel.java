//package src2204;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayPanel extends JPanel implements ActionListener{
    
    public boolean backClicked;
    private Font titleFont;
    private Font textFont;
    private Font buttonFont;
    private JLabel titleLabel;
    private JLabel textArea;
    private JButton backButton;

    public HowToPlayPanel(){
        setBackground(new Color(214,188,248));
        setForeground(new Color(142,93,207));
        setLayout(null);

        readFont();
        backClicked = false;

        titleLabel = new JLabel("How To Play");
        titleLabel.setFont(titleFont);
        titleLabel.setSize(400, 80);
        titleLabel.setLocation(370, 60);
        titleLabel.setForeground(new Color(102,73,177));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVisible(true);
        add(titleLabel);
        
        //textArea
        textArea = new JLabel();
        textArea.setText("<html><div style='text-align: center;'>It's easy! Just type in the logo you see on the screen before it disappears after 10 seconds!<br/>You start with 7 lives regardless of difficulty, and will lose one if you don't guess the logo in time.<br/> You will lose once you run out of lives, but worry not, you get another life every 50000 points.<br/> Your score is calculated based on how fast you guessed the logo.<br/>The faster you type, the more points you'll get!<br/><br/>Set the game to your own pace! Difficulty settings:<br/>Easy: 2 logos at once<br/>Medium: 3 logos at once<br/>Hard: 4 logos at once<br/><br/>And most importantly, have fun!<br/><br/><br/><br/>Created by Marcelina, Yohan Chandrasukmana, and Gabriel Jason Theo. 2021</html>");
        textArea.setForeground(new Color(142,93,207));
        textArea.setFont(textFont);
        textArea.setHorizontalAlignment(SwingConstants.CENTER);
        textArea.setSize(950,400);
        textArea.setLocation(100, 140);
        textArea.setVisible(true);
        add(textArea);
        

        //button
        backButton = new JButton();
        backButton.addActionListener(this);
        backButton.setText("BACK");
        backButton.setFont(buttonFont);
        backButton.setSize(300,30);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setForeground(new Color(102,73,177));
        backButton.setLocation(30,600);
        backButton.setVisible(true);
        add(backButton);
    }

    public boolean getBackClicked(){
        return backClicked;
    }
    public void resetBackButton(){
        backClicked = false;
    }
    
    public void readFont(){
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(titleFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            textFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/Adagio.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(textFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            buttonFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(buttonFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        backClicked = true;
    }
        

}


