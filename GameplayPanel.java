
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GameplayPanel extends JPanel {
   
    private static final long serialVersionUID = 1L;
    private List<LogoLabel> logoLabels;

    public GameplayPanel(ArrayList<String> currentWord) {
        initNewLogo(currentWord);
    }

    public void initNewLogo(ArrayList<String> currentWord)
    {
        logoLabels = new ArrayList<LogoLabel>();
        Random ranNum = new Random();
        for(int i = 0; i<currentWord.size(); i++ ){
            logoLabels.add(new LogoLabel(currentWord.get(i)));
            logoLabels.get(i).setLocation((i*(1152/currentWord.size())+ranNum.nextInt((1152/currentWord.size())-150)),ranNum.nextInt(348));
            add(logoLabels.get(i));
        }
    }

    public LogoLabel getLogoLabels(int idx){
        return logoLabels.get(idx);
    }
    
    public void updateLogoLabel(int idx, String newWord){
        Random ranNum = new Random();
        logoLabels.set(idx, new LogoLabel(newWord));
        logoLabels.get(idx).setLocation((idx*(1152/logoLabels.size())+ranNum.nextInt((1152/logoLabels.size())-150)),ranNum.nextInt(348));
        add(logoLabels.get(idx));
    }

    public int getTimeLeft(String ans)
    {
        int idx = findLogo(ans);
        logoLabels.get(idx).setIsCorrect();
        return logoLabels.get(idx).getLogoTimer();
    }

    public int findLogo(String ans){
        for(int i = 0; i<logoLabels.size(); i++){
            if(logoLabels.get(i).getName().startsWith(ans)){
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon ("res/0bg.png");
        g.drawImage(img.getImage(), 0, 0, 1152,568,null);
    }
}
