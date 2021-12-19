
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class LogoLabel extends JLabel implements Runnable{
    Random ranNum = new Random();
    private String logoName;
    private int width = 150;
    private int height = 150;
    private int logoTimer;
    private JLabel timerLabel = new JLabel();
    private Font timerLabelFont;
    private boolean isCorrect;
    private boolean isDone;

    {
        try {
            timerLabelFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/FONTS/MonsterFriendFore.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(timerLabelFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Thread thread = new Thread(this);
    @Override
    public void run(){
        logoTimer=10000;
        isCorrect = false;
        isDone = false;
        this.add(timerLabel);
        timerLabel.setFont(timerLabelFont);
        timerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        timerLabel.setVerticalAlignment(SwingConstants.TOP);
        while(!isDone)
        {
            int var = Math.round(logoTimer / 1000);
            timerLabel.setText(String.valueOf(var));
            timerLabel.setSize(var * 11, var * 11);
            timerLabel.setLocation(var+1, var+1);
            this.height = ((15 + var) * 6);
            this.width = ((15 + var) * 6);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            logoTimer -= 2;
            getParent().repaint();
            getParent().revalidate();
            if (logoTimer==0 || isCorrect) {
                setIsDone();
                break;
            }
        }
        stop();
    }

    public LogoLabel(String fetchedName)
    {
        logoName=fetchedName;
        setVisible(true);
        setLayout(new GridLayout(1,1));
        thread.start();
        isDone = false;
    }

    public int getWidth()
    {
        return width;
    }
    public void setWidth(int currentWidth)
    {
        width=currentWidth;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int currentHeight)
    {
        height=currentHeight;
    }
    public void stop(){
        setVisible(false);
    }
    public void setIsDone(){isDone=true;}
    public void setIsCorrect(){isCorrect=true;}
    public boolean isDone(){
        return isDone;
    }
    public boolean isCorrect(){
        return isCorrect;
    }
    public int getLogoTimer(){
        return logoTimer;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon ("res/"+logoName+".png");
        g.drawImage(img.getImage(), 0,0, width,height,null);
    }

    public String getName(){
        return this.logoName;
    }
}
