
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartMenuPanel extends JPanel implements ActionListener {

    public boolean startClicked;
    public boolean howToPlayClicked;
    public boolean exitClicked;

    private Font buttonFont;
    private JButton startButton;
    private JButton howToPlayButton;
    private JButton exitButton;

    public StartMenuPanel() {
        startClicked = false;
        howToPlayClicked = false;
        exitClicked = false;
        
        startButton = new JButton();
        howToPlayButton = new JButton();
        exitButton = new JButton();

        startButton.addActionListener(this);
        howToPlayButton.addActionListener(this);
        exitButton.addActionListener(this);

        try {
            buttonFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(buttonFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setForeground(new Color(214,188,248));
        setBackground(new Color(142,93,207));
        setLayout(null);

        startButton.setText("START");
        startButton.setFont(buttonFont);
        startButton.setSize(300,40);
        startButton.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.setLocation(426,415);
        startButton.setVisible(true);
        add(startButton);

        howToPlayButton.setText("HOW TO PLAY");
        howToPlayButton.setFont(buttonFont);
        howToPlayButton.setSize(300,40);
        howToPlayButton.setHorizontalAlignment(SwingConstants.CENTER);
        howToPlayButton.setLocation(426,460);
        howToPlayButton.setVisible(true);
        add(howToPlayButton);

        exitButton.setText("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setSize(300,40);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setLocation(426,505);
        exitButton.setVisible(true);
        add(exitButton);

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon ("res/0LOGOWARS.png");
        g.drawImage(img.getImage(), 376, 70, 400, 287,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            startClicked = true;
        }
        else if(e.getSource() == howToPlayButton){
            howToPlayClicked = true;
        }
        else{
            exitClicked = true;
        }
    }

    public boolean getStartClicked(){
        return startClicked;
    }
    public boolean getHowToPlayClicked(){
        return howToPlayClicked;
    }
    public boolean getExitClicked(){
        return exitClicked;
    }

    public void resetMenu(){
        startClicked = false;
        howToPlayClicked = false;
        exitClicked = false;
    }
}


