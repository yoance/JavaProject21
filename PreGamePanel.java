

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PreGamePanel extends JPanel implements ActionListener {
    public boolean easyClicked;
    public boolean mediumClicked;
    public boolean hardClicked;
    public boolean startGameClicked;
    public boolean backClicked;


    private Font buttonFont;
    private Font titleFont;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton startGameButton;
    private JButton backButton;
    private JLabel difficultyJLabel;
    private boolean anyClicked;

    public PreGamePanel(){
        
        startGameButton = new JButton();
        easyButton = new JButton();
        mediumButton = new JButton();
        hardButton = new JButton();
        backButton = new JButton();
        resetButton();

        startGameButton.addActionListener(this);
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        backButton.addActionListener(this);

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
            buttonFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(buttonFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBackground(new Color(214,188,248));
        setForeground(new Color(142,93,207));
        setLayout(null);

        difficultyJLabel = new JLabel("<html><div style='text-align: center;'>CHOOSE YOUR<br/>DIFFICULTY</html>");
        difficultyJLabel.setFont(titleFont);
        difficultyJLabel.setLocation(326, 60);
        difficultyJLabel.setSize(500,240);
        difficultyJLabel.setForeground(new Color(102,73,177));
        difficultyJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        difficultyJLabel.setVerticalAlignment(SwingConstants.CENTER);
        difficultyJLabel.setVisible(true);
        add(difficultyJLabel);

        easyButton.setText("EASY");
        easyButton.setFont(buttonFont);
        easyButton.setSize(300,40);
        easyButton.setHorizontalAlignment(SwingConstants.CENTER);
        easyButton.setForeground(new Color(102,73,177));
        easyButton.setLocation(426,300);
        easyButton.setVisible(true);
        add(easyButton);

        mediumButton.setText("MEDIUM");
        mediumButton.setFont(buttonFont);
        mediumButton.setSize(300,40);
        mediumButton.setHorizontalAlignment(SwingConstants.CENTER);
        mediumButton.setForeground(new Color(102,73,177));
        mediumButton.setLocation(426,350);
        mediumButton.setVisible(true);
        add(mediumButton);

        hardButton.setText("HARD");
        hardButton.setFont(buttonFont);
        hardButton.setSize(300,40);
        hardButton.setHorizontalAlignment(SwingConstants.CENTER);
        hardButton.setForeground(new Color(102,73,177));
        hardButton.setLocation(426,400);
        hardButton.setVisible(true);
        add(hardButton);

        startGameButton.setText("START GAME");
        startGameButton.setFont(buttonFont);
        startGameButton.setSize(300,40);
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.setForeground(new Color(102,73,177));
        startGameButton.setLocation(426,600);
        startGameButton.setVisible(true);
        startGameButton.setEnabled(false);
        add(startGameButton);

        backButton.setText("BACK");
        backButton.setFont(buttonFont);
        backButton.setSize(300,40);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setForeground(new Color(102,73,177));
        backButton.setLocation(30,600);
        backButton.setVisible(true);
        add(backButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        easyClicked = false;
        mediumClicked = false;
        hardClicked = false;
        if(e.getSource() == startGameButton){
            startGameClicked = true;
            setAnyClickedT();
        }
        else if(e.getSource() == easyButton){
            mediumButton.setEnabled(true);
            hardButton.setEnabled(true);
            setAnyClickedT();
            easyClicked = true;
        }
        else if(e.getSource() == mediumButton){
            easyButton.setEnabled(true);
            hardButton.setEnabled(true);
            setAnyClickedT();
            mediumClicked = true;
        }
        else if(e.getSource() == hardButton){
            easyButton.setEnabled(true);
            mediumButton.setEnabled(true);
            setAnyClickedT();
            hardClicked = true;
        }
        else{
            backClicked = true;
            setAnyClickedT();
        }
    }

    public boolean getStartGameClicked(){return startGameClicked;}
    public boolean getEasyClicked(){return easyClicked;}
    public boolean getMediumClicked(){return mediumClicked;}
    public boolean getHardClicked(){return hardClicked;}
    public boolean getBackClicked(){return backClicked;}
    public boolean getAnyClicked(){return anyClicked;}
    public void setAnyClickedF(){anyClicked=false;}
    public void setAnyClickedT(){anyClicked=true;}

    public void lockButton(JButton b){
        if(b == easyButton){
            easyButton.setEnabled(false);
        }else if(b == mediumButton){
            mediumButton.setEnabled(false);
        }else if(b == hardButton){
            hardButton.setEnabled(false);
        }
    }
    public void unlockStartGameButton(){
         startGameButton.setEnabled(true);
    }

    public JButton getEasyButton(){return easyButton;}
    public JButton getMediumButton(){ return mediumButton;}
    public JButton getHardButton(){ return hardButton;}

    public void resetButton(){
        startGameClicked = false;
        easyClicked = false;
        mediumClicked = false;
        hardClicked = false;
        backClicked = false;
        easyButton.setEnabled(true);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(true);
        startGameButton.setEnabled(false);
        setAnyClickedF();
    }
    
}
