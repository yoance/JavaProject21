
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class StatusPanel extends JPanel{
    private int lives;
    private int score;
    private int solvedAmt;
    private JLabel livesLabel;
    private JLabel solvedLabel;
    private JLabel scoreLabel;
    private Font statusLabelFont;

    public StatusPanel(Player player)
    {
        try {
            statusLabelFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/Adagio.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(statusLabelFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(1,3));
        setOpaque(true);
        setBackground(new Color(214,188,248));

        lives = player.getLives();
        score = player.getScore();
        solvedAmt = player.getAmountSolved();

        livesLabel = new JLabel();
        livesLabel.setText("Lives: " + lives);
        livesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        livesLabel.setVerticalAlignment(SwingConstants.CENTER);
        livesLabel.setForeground(Color.BLACK);
        livesLabel.setFont(statusLabelFont);
        this.add(livesLabel);

        scoreLabel = new JLabel();
        scoreLabel.setText("Score: " + score);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(statusLabelFont);
        scoreLabel.setSize(25,100);
        scoreLabel.setLocation(30,10);
        this.add(scoreLabel);
        
        solvedLabel = new JLabel();
        solvedLabel.setText("Solved: " + solvedAmt);
        solvedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        solvedLabel.setVerticalAlignment(SwingConstants.CENTER);
        solvedLabel.setFont(statusLabelFont);
        this.add(solvedLabel);
    }

    public void update(int lives)
    {
        livesLabel.setText("Lives: " + lives);
    }

    public void update(int score, int amountSolved)
    {
        scoreLabel.setText("Score: " + score);
        solvedLabel.setText("Solved: " + amountSolved);
    }
}
