import java.awt.Color;
import javax.swing.JTextField;

public class AnswerField extends JTextField{
    private JTextField tf;

    public AnswerField(){
        //text field w/ center alignment & is unselectable
        tf = new JTextField(15);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setHighlighter(null);
        tf.setVisible(true);
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
}

