import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
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
            //pas di inisialisasi, udah langsung auto startTimer 
            logoLabels.add(new LogoLabel(currentWord.get(i)));
            //logoLabels.get(i).setVisible(true); langsung pas inisialisasi aj
            logoLabels.get(i).setLocation(ranNum.nextInt(902),ranNum.nextInt(318));
            add(logoLabels.get(i));
        }
      
    }

    public void updateLogoLabel(int idx, String newWord){
        logoLabels.set(idx, new LogoLabel(newWord));
        add(logoLabels.get(idx));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon ("res/0bg.png");
        g.drawImage(img.getImage(), 0, 0, 1152,568,null);
    }

}
