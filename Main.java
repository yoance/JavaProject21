import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener, ActionListener{

    private JFrame mainFrame;
    private StatusPanel statusDisplay;
    private GameplayPanel gameplayDisplay;
    private GameOverPanel gameOverScreen;
    private GameModel gameModel;
    private AnswerField answer;
    private JButton btn;
    private JPanel answerPanel;
    private StartMenuPanel startMenuScreen;
    private HowToPlayPanel howToPlayScreen;
    private PreGamePanel preGameScreen;
    private MusicPlayer bgm;
    private MusicPlayer sfx;

    private StringBuilder strInput = new StringBuilder();
    private boolean reset = false;
    private String temp;
    public boolean isRunning;
    public int level;
    public int liveMeter = 1;
    public int fail = 0;

    public Main(){
        mainFrame = new JFrame();
        startMenuScreen = new StartMenuPanel();
        gameOverScreen = new GameOverPanel();
        howToPlayScreen = new HowToPlayPanel();
        preGameScreen = new PreGamePanel();
        bgm = new MusicPlayer();
        sfx = new MusicPlayer();
        
        mainFrame.setSize(1168,685);
        mainFrame.setLayout(null);
        mainFrame.setBackground(new Color(214,188,248));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        startMenu();
    }

    public void startMenu(){
        bgm.playMusic("res/MUSIC/main.wav");

        mainFrame.repaint();
        mainFrame.revalidate();
        startMenuScreen.setLocation(0,0);
        startMenuScreen.setSize(1152,685);
        startMenuScreen.setVisible(true);
        mainFrame.add(startMenuScreen);
        
        isRunning = false;
        while(!isRunning){
            mainFrame.repaint();
            if(startMenuScreen.startClicked)
            {
                mainFrame.remove(startMenuScreen);
                startMenuScreen.resetMenu();
                runPreGame();
            }
            else if (startMenuScreen.howToPlayClicked)
            {
                mainFrame.remove(startMenuScreen);
                startMenuScreen.resetMenu();
                runHowToPlay();  
            }
            else if(startMenuScreen.exitClicked)
            {
                bgm.stopMusic();
                sfx.playSfx("res/SFX/click.wav");
                startMenuScreen.resetMenu();
                mainFrame.dispose();
                isRunning = true;
                System.exit(0);
            }
        }
    }

    public void runHowToPlay(){
        bgm.stopMusic();
        bgm.playMusic("res/MUSIC/howto.wav");
        sfx.playSfx("res/SFX/click.wav");

        howToPlayScreen.setLocation(0,0);
        howToPlayScreen.setSize(1152,685);
        howToPlayScreen.setVisible(true);
        mainFrame.add(howToPlayScreen);
        while(true){
            mainFrame.repaint();
            if(howToPlayScreen.getBackClicked()){
                bgm.stopMusic();
                back(howToPlayScreen);
                break;
            }
        }
    }
    public void runPreGame(){
        bgm.stopMusic();
        sfx.playSfx("res/SFX/click.wav");
        bgm.playMusic("res/MUSIC/diff.wav");

        preGameScreen.setLocation(0,0);
        preGameScreen.setSize(1152,685);
        preGameScreen.setVisible(true);
        mainFrame.add(preGameScreen);

        while(true){
            mainFrame.repaint();
                if (preGameScreen.getEasyClicked()) {
                    level = GameModel.EASY;
                    preGameScreen.lockButton(preGameScreen.getEasyButton());
                    preGameScreen.unlockStartGameButton();
                    mainFrame.revalidate();
                } else if (preGameScreen.getMediumClicked()) {
                    level = GameModel.MEDIUM;
                    preGameScreen.lockButton(preGameScreen.getMediumButton());
                    preGameScreen.unlockStartGameButton();
                    mainFrame.revalidate();
                } else if (preGameScreen.getHardClicked()) {
                    level = GameModel.HARD;
                    preGameScreen.lockButton(preGameScreen.getHardButton());
                    preGameScreen.unlockStartGameButton();
                    mainFrame.revalidate();
                }
                if (preGameScreen.getBackClicked()) {
                    back(preGameScreen);
                } else if (preGameScreen.getStartGameClicked()) {
                    mainFrame.remove(preGameScreen);
                    preGameScreen.resetButton();
                    run(level);
                }

            if (preGameScreen.getAnyClicked())
            { sfx.playSfx("res/SFX/click.wav");
                preGameScreen.setAnyClickedF();
            }
        }
    }

    public void back(JPanel currentPanel){
        if(currentPanel == howToPlayScreen){
            bgm.stopMusic();
            sfx.playSfx("res/SFX/click.wav");
            howToPlayScreen.resetBackButton();
            mainFrame.remove(howToPlayScreen);
            startMenu();
        }
        else if(currentPanel == preGameScreen){
            bgm.stopMusic();
            sfx.playSfx("res/SFX/click.wav");
            preGameScreen.resetButton();
            mainFrame.remove(preGameScreen);
            startMenu();
        }
    }

    public void run(int level){
        bgm.stopMusic();
        sfx.playSfx("res/SFX/click.wav");
        bgm.playMusic("res/MUSIC/ingame.wav");

        answer = new AnswerField();
        answer.addKeyListener(this);
        btn = new JButton("Clear");
        btn.addActionListener(this);

        gameModel = new GameModel(level);
        statusDisplay = new StatusPanel(gameModel.getPlayer());
        statusDisplay.setVisible(true);
        statusDisplay.setLocation(0,0);
        statusDisplay.setSize(1152,80);
        mainFrame.add(statusDisplay);
        
        gameplayDisplay = new GameplayPanel(gameModel.getCurrentWordList());
        gameplayDisplay.setVisible(true);
        gameplayDisplay.setLayout(null);
        gameplayDisplay.setLocation(0,80);
        gameplayDisplay.setSize(1152,480);
        mainFrame.add(gameplayDisplay);

        answerPanel = new JPanel();
        answerPanel.add(answer); // PAKE ANSWER FIELD
        answerPanel.add(btn);
        answerPanel.setBackground(Color.BLACK);
        answerPanel.setVisible(true);
        answerPanel.setLocation(0,560);
        answerPanel.setSize(1152,125);
        mainFrame.add(answerPanel);

        mainFrame.repaint();
        mainFrame.revalidate();

        isRunning = true;

        liveMeter = 1;
        fail = 0;
        
        while(gameModel.getPlayer().getLives()!=0){
            if (gameModel.getPlayer().getScore()-(liveMeter*(100000))>0)
            {
                gameModel.getPlayer().setLives(gameModel.getPlayer().getLives()+1);
                statusDisplay.update(gameModel.getPlayer().getLives());
                liveMeter++;
            }
            for (int idx=0; idx<gameModel.getLevel(); idx++)
            {
                if (gameplayDisplay.getLogoLabels(idx).isDone())
                {
                    if (!(gameplayDisplay.getLogoLabels(idx).isCorrect()))
                    {fail++;}
                    gameModel.generateWord(idx);
                    gameplayDisplay.updateLogoLabel(idx, gameModel.getNewWord());
                }
                if(fail==1){
                    sfx.playSfx("res/SFX/time.wav");
                    gameModel.getPlayer().setLives(gameModel.getPlayer().getLives()-1);
                    statusDisplay.update(gameModel.getPlayer().getLives());
                    fail = 0;
                }
                if(gameModel.getPlayer().getLives()==0){
                    break;
                }
            }
        }

        if(gameModel.getPlayer().getLives()==0){
            mainFrame.remove(gameplayDisplay);
            mainFrame.remove(answerPanel);
            mainFrame.remove(btn);
            mainFrame.repaint();
            mainFrame.revalidate();

            gameOverScreen.setVisible(true);
            gameOverScreen.setLocation(0,80);
            gameOverScreen.setSize(1152,480);
            mainFrame.add(gameOverScreen);
            
            bgm.stopMusic();
            sfx.playSfx("res/SFX/loss.wav");

            do{
                mainFrame.repaint();
                if(gameOverScreen.menuClicked)
                {
                    gameOverScreen.resetMenu();
                    mainFrame.remove(gameOverScreen);
                    mainFrame.remove(statusDisplay);
                    mainFrame.repaint();
                    mainFrame.revalidate();
                    bgm.stopMusic();
                    sfx.playSfx("res/SFX/click.wav");
                    startMenu();
                }
                else if (gameOverScreen.playAgainClicked)
                {
                    gameOverScreen.resetMenu();
                    mainFrame.remove(gameOverScreen);
                    mainFrame.remove(statusDisplay);
                    mainFrame.repaint();
                    mainFrame.revalidate();
                    bgm.stopMusic();
                    sfx.playSfx("res/SFX/click.wav");
                    runPreGame();
                }
                else if(gameOverScreen.exitClicked)
                {
                    bgm.stopMusic();
                    sfx.playSfx("res/SFX/click.wav");
                    mainFrame.dispose();
                    System.exit(0);
                }
            }while(!gameOverScreen.menuClicked && !gameOverScreen.playAgainClicked && !gameOverScreen.exitClicked);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && strInput.length() != 0){  
            //if backspace is typed, setting length to - 1 (removing last char)
            strInput.setLength(strInput.length()-1);
        }
        else{
            //appends key typed to strInput (as user's input) if input is an alphabet
            if (Character.isLetter(e.getKeyChar()) == true)
                strInput.append(e.getKeyChar());
            
            if (strInput.length()>1){
                if(gameModel.checkAnswer(strInput.toString())){
                    temp = strInput.toString().toUpperCase();
                    answer.fieldColor("GREEN");
                }
                else{
                    answer.fieldColor("RED");
                }

                if(gameModel.finalAnswer(strInput.toString())){
                    int timeLeft = gameplayDisplay.getTimeLeft(strInput.toString().toUpperCase());
                    sfx.playSfx("res/SFX/ding.wav");
                    gameModel.rightAnswer(timeLeft);
                    statusDisplay.update(gameModel.getPlayer().getScore(), gameModel.getPlayer().getAmountSolved());
                    reset = true;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //can be used for triggering events by pressing backspace
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && strInput.length() != 0){
            //if backspace is pressed, setting length to - 1 (removing last char)
            strInput.setLength(strInput.length()-1);
        }
        if(Character.isLetter(e.getKeyChar()) == false){
            answer.setText(strInput.toString());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (reset == true){
            //reset strInput & text field
            resetInput();
            reset = false;
        }
        if(Character.isLetter(e.getKeyChar()) == false || e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            answer.setText(strInput.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resetInput();
    }
    
    public void resetInput(){
        strInput = new StringBuilder();
        answer.fieldColor("");
        answer.setText("");
    }

    public static void main(String[] args) {
        Main frame = new Main();
    }

}