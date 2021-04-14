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
        //while (logoTimer!=0 && answerField!=this.logoName)
        while(true)
        {
            int var = Math.round(logoTimer/1000);
            timerLabel.setText(String.valueOf(var));
            timerLabel.setFont(timerLabelFont);
            timerLabel.setSize(var*10,var*10);
            timerLabel.setHorizontalAlignment(SwingConstants.LEFT);
            timerLabel.setVerticalAlignment(SwingConstants.TOP);
            timerLabel.setLocation(var,var);
            this.add(timerLabel);
            this.height=((15+var) * 6);
            this.width=((15+var) * 6);
            try{ Thread.sleep(1); }
            catch(Exception e){}
            logoTimer-=2;
            getParent().repaint();
            getParent().revalidate();
            //if (logoTimer==0)
            if(height <= 90){
                //GAMEPLAY PANEL -> REMOVE LOGO LABEL, IMMEDIATELY REPLACE WITH NEW ONE
                //Player.timeOut();
                setVisible(false);
                //remove setVisible after gameplay panel implementation
                break;
            }
            //if (answerField==logoName) [IF ANSWER IS RIGHT]
            //{
                //GAMEPLAY PANEL -> REMOVE LOGO LABEL, IMMEDIATELY REPLACE WITH NEW ONE
                //Player.rightAnswer(logoTimer);
                //break;
            //}
        }       
    }

    public LogoLabel(String fetchedName)
    {
        logoName=fetchedName;
        setVisible(true);
        setLayout(new GridLayout(1,1));
        thread.start();
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

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon ("res/"+logoName+".png");
        g.drawImage(img.getImage(), 0,0, width,height,null);
    }

}
