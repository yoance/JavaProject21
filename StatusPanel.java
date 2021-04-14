import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class StatusPanel extends JPanel{
    public static int getLives;
    public static int getScore;
    public static int getSolvedAmt;
    private int lives;
    private int score;
    private int solvedAmt;
    private JLabel livesLabel;
    private JLabel solvedLabel;
    private JLabel scoreLabel;
    private Font statusLabelFont;

    public StatusPanel(Player player, int amountSolved)
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

        lives = player.getHealthPoints();
        score = player.getScore();
        solvedAmt=amountSolved;

        livesLabel = new JLabel();
        //livesLabel.setBorder(new LineBorder(Color.RED));
        livesLabel.setText("Lives: " + lives);
        livesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        livesLabel.setVerticalAlignment(SwingConstants.CENTER);
        livesLabel.setForeground(Color.BLACK);
        livesLabel.setFont(statusLabelFont);
        this.add(livesLabel);

        scoreLabel = new JLabel();
        scoreLabel.setText(String.valueOf(score));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(statusLabelFont);
        scoreLabel.setSize(25,100);
        scoreLabel.setLocation(30,10);
        this.add(scoreLabel);
        
        solvedLabel = new JLabel();
        solvedLabel.setText("Solved: " + solvedAmt);
        solvedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        solvedLabel.setVerticalAlignment(SwingConstants.CENTER);
        solvedLabel.setFont(statusLabelFont);
        this.add(solvedLabel);
    }

    /*public void timeOut()
    {
        setLives(getLives()-1);
    }*/

    public void rightAnswer(LogoLabel runningLogo)
    {
    //    setScore(getScore()+(1000*[OBJECT TIMER]));
        setSolvedAmt(getSolvedAmt()+1);
    }

    public int getSolvedAmt()
    {
        return solvedAmt;
    }

    public void setSolvedAmt(int amountSolved)
    {
        solvedAmt=amountSolved;
    }

}
