
import java.awt.Color;
import java.io.File;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JTextField;

public class AnswerField extends JTextField{
    private Font answerFieldFont;

    public AnswerField() {
        try {
            answerFieldFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/FONTS/CompelBlackSE.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(answerFieldFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //text field w/ center alignment & is unselectable
        setSize(150, 20);
        setFont(answerFieldFont);
        setColumns(15);
        setHorizontalAlignment(JTextField.CENTER);
        setHighlighter(null);
    }
    
    public void fieldColor(String color){
        if (color.equalsIgnoreCase("RED")){
            setBackground(Color.RED);
            setForeground(Color.BLACK);
        }
        else if(color.equalsIgnoreCase("GREEN")){
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
        else{
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
    }
}

