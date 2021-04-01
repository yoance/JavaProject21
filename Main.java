package TypeShootGame;

import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements KeyListener, ActionListener{
JFrame mainFrame;
JTextField tf;
JLabel displayLabel;
JLabel displayLabel2;
JButton btn;
GameModel gameModel;
StringBuilder strInput = new StringBuilder();
boolean check = false;

public Main() {
    mainFrame = new JFrame();
    displayLabel = new JLabel();
    displayLabel2 = new JLabel();

    //text field w/ center alignment & is unselectable
    tf = new JTextField(15);
    tf.addKeyListener(this);
    tf.setHorizontalAlignment(JTextField.CENTER);
    tf.setHighlighter(null);

    btn = new JButton("Clear");
    btn.addActionListener(this);

    JPanel panel = new JPanel();
    panel.add(tf);
    panel.add(btn);

    mainFrame.setLayout(new BorderLayout());
    mainFrame.add(displayLabel, BorderLayout.NORTH);
    mainFrame.add(displayLabel2);
    
    mainFrame.add(panel, BorderLayout.SOUTH);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(1920,1080);
    mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //mainFrame.setLayout(new GridLayout(3,1));
    mainFrame.setVisible(true);

    gameModel = new GameModel();
    gameModel.setCurrentWord1();
    gameModel.setCurrentWord2();
    displayLabel.setText("Text 1  :" + gameModel.getWord1());
    displayLabel2.setText("Text 2: "+ gameModel.getWord2());
}

@Override
public void keyTyped(KeyEvent e) {
    String fixedWord = new String();
    if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && strInput.length() != 0){  
        //if backspace is typed, setting length to - 1 (removing last char)
        strInput.setLength(strInput.length()-1);
    }
    else{
        //appends key typed to strInput (as user's input) if input is an alphabet
        if (Character.isLetter(e.getKeyChar()) == true)
            strInput.append(e.getKeyChar()); 
        
        if(wordCheck(gameModel.getWord1(), strInput) == true){ 
            fieldColor("black");
            fixedWord=gameModel.getWord1();
            displayLabel.setText("Current text is " + fixedWord + "  your input: " + strInput.toString());

            //if input equals to words[roll]
            if(strInput.toString().equalsIgnoreCase(fixedWord)){
                //reset strInput & text field
                resetInput();

                //roll to next random word
                gameModel.setCurrentWord1();
                displayLabel.setForeground(Color.BLACK);
                displayLabel.setText("Current text is " + gameModel.getWord1());
                check = true;
                }
            if(wordCheck(fixedWord, strInput) == true)
                displayLabel.setForeground(Color.GREEN);
            //else
            //    displayLabel.setForeground(Color.GREEN);
        
            displayLabel2.setText("Text 2: " + gameModel.getWord2());
            displayLabel2.setForeground(Color.BLACK);
        }
        else if(wordCheck(gameModel.getWord2(), strInput) == true){
            fieldColor("black");
            fixedWord = gameModel.getWord2();
            displayLabel2.setText("Current text is " + fixedWord + "  your input: " + strInput.toString());
            //if input equals to current word2
            if(strInput.toString().equalsIgnoreCase(fixedWord)){
                //roll to next random word
                gameModel.setCurrentWord2();
                displayLabel2.setForeground(Color.BLACK);
                displayLabel2.setText("Current text is " + gameModel.getWord2());

                check = true;
            }
            if(wordCheck(fixedWord, strInput) == true)
                displayLabel2.setForeground(Color.GREEN);
            //else
            //    displayLabel.setForeground(Color.GREEN);
            displayLabel.setText("Text 1: " + gameModel.getWord1());
            displayLabel.setForeground(Color.BLACK);
        }
        else{
            fieldColor("red");
        }
    }


    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
    {
    //code to execute if escape is pressed
    }
}

public boolean wordCheck(String currentWord, StringBuilder str){
    if(currentWord.toUpperCase().startsWith(str.toString().toUpperCase()))
        return true;
    else
        return false;
}

public void resetInput(){
    strInput = new StringBuilder();
    tf.setText("");
}

public void fieldColor(String color){
    if (color.equalsIgnoreCase("RED")){
        tf.setBackground(Color.RED);
        tf.setForeground(Color.WHITE);
    }
    else{
        tf.setBackground(Color.WHITE);
        tf.setForeground(Color.BLACK);
    }
}

@Override
public void keyPressed(KeyEvent e) {
//can be used for triggering events by pressing backspace
    if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && strInput.length() != 0){  
        //if backspace is pressed, setting length to - 1 (removing last char)
        strInput.setLength(strInput.length()-1);
    }
}

@Override
public void keyReleased(KeyEvent e) {
    if (check == true){
        //reset strInput & text field
        resetInput();
        check = false;
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    resetInput();
}

public static void main(String[] args){
        Main mainTest = new Main();
}
}