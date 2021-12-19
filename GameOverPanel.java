
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameOverPanel extends JPanel implements ActionListener{

    public boolean menuClicked;
    public boolean playAgainClicked;
    public boolean exitClicked;
    
    private Font gameOverFont;
    private Font buttonFont;
    private JLabel gameOverLabel;
    private JButton menuButton;
    private JButton playAgainButton;
    private JButton exitButton;

    public GameOverPanel() {
        menuClicked = false;
        playAgainClicked = false;
        exitClicked = false;

        gameOverLabel = new JLabel();
        menuButton = new JButton();
        playAgainButton = new JButton();
        exitButton = new JButton();

        menuButton.addActionListener(this);
        playAgainButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        try {
            gameOverFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(gameOverFont);
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

        setForeground(new Color(214,188,248));
        setBackground(new Color(142,93,207));
        setLayout(null);
        gameOverLabel.setText("GAME OVER");
        gameOverLabel.setFont(gameOverFont);
        gameOverLabel.setLocation(330,100);
        gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameOverLabel.setVerticalAlignment(SwingConstants.CENTER);
        gameOverLabel.setSize(500,100);
        gameOverLabel.setVisible(true);
        add(gameOverLabel);

        menuButton.setText("MENU");
        menuButton.setFont(buttonFont);
        menuButton.setSize(300,40);
        menuButton.setHorizontalAlignment(SwingConstants.CENTER);
        menuButton.setLocation(426,280);
        menuButton.setVisible(true);
        add(menuButton);

        playAgainButton.setText("PLAY AGAIN");
        playAgainButton.setFont(buttonFont);
        playAgainButton.setSize(300,40);
        playAgainButton.setHorizontalAlignment(SwingConstants.CENTER);
        playAgainButton.setLocation(426,320);
        playAgainButton.setVisible(true);
        add(playAgainButton);

        exitButton.setText("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setSize(300,40);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setLocation(426,360);
        exitButton.setVisible(true);
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuButton){
            menuClicked = true;
        }
        else if(e.getSource() == playAgainButton){
            playAgainClicked = true;
        }
        else{
            exitClicked = true;
        }
    }

    public void resetMenu(){
        menuClicked = false;
        playAgainClicked = false;
        exitClicked = false;
    }

}
