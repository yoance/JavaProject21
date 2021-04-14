import javax.swing.*;
import java.awt.*;

public class Main{

    private JFrame mainFrame;
    private StatusPanel statusDisplay;
    private GameplayPanel gameplayDisplay;
    private GameModel gameModel;
    private AnswerField answer;

    public Main() {
        gameModel = new GameModel(3);
        gameplayDisplay = new GameplayPanel(gameModel.getCurrentWordList());
        answer = new AnswerField();

        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(1168,685);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        
        statusDisplay = new StatusPanel(gameModel.getPlayer(), 0);
        statusDisplay.setVisible(true);
        statusDisplay.setLocation(0,0);
        statusDisplay.setSize(1152,80);
        mainFrame.add(statusDisplay);
        
        gameplayDisplay.setVisible(true);
        gameplayDisplay.setLayout(null);
        gameplayDisplay.setFont(new java.awt.Font("Adagio",Font.PLAIN,10));
        gameplayDisplay.setLocation(0,80);
        gameplayDisplay.setSize(1152,568);
        mainFrame.add(gameplayDisplay);

        JPanel answerPanel = new JPanel();
        answerPanel.add(answer);
        mainFrame.add(answerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Main frame = new Main();
    }

}