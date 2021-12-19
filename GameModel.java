
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameModel {
    private ArrayList<String> currentWords;
    private Player player;
    private List<Logo> logos; 
    private String newWord;
    private int level;
    public static final int EASY = 2;
    public static final int MEDIUM = 3;
    public static final int HARD = 4;
        

    public GameModel(int size){
        level = size;
        player = new Player();
        initializeLogo();
        initializeCurrentWords(size);
    }   

    public void initializeCurrentWords(int size){
        currentWords = new ArrayList<String>();
        for(int i = 0; i<size; i++){
            currentWords.add("0");
            generateWord(i);
        }
    }

    public int getLevel(){
        return level;
    }
    /**
     * generate the word and update the current ongoing word on the given index.
     */
    public void generateWord(int idx){
        Random randnum = new Random();
        int roll;
        boolean dupe = false;
        do{
            roll = randnum.nextInt(logos.size()-1);
            dupe = false;
            for(int i=0; i<currentWords.size(); i++){
                if((i!= idx && logos.get(roll).getName().startsWith(currentWords.get(i))) || logos.get(roll).getMark()){
                    dupe = true;
                    break;
                }    
            }
        }while(dupe==true);
        newWord = logos.get(roll).getName();
        logos.get(roll).setMark();
        currentWords.set(idx,newWord);
    }

    public String getNewWord(){
        return newWord;
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<String> getCurrentWordList(){
        return currentWords;
    }

    public boolean checkAnswer(String ans){
        for(int i=0; i<currentWords.size(); i++){
            if(currentWords.get(i).toUpperCase().startsWith(ans.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public boolean finalAnswer(String ans){
        for(int i=0; i<(currentWords.size()); i++){
            if(currentWords.get(i).equalsIgnoreCase(ans)){
                //stop animasi & set current correct word
                generateWord(i);
                return true;
            }
        }
        return false;
    }

    public void rightAnswer(int logoTimer)
    {
        player.setScore(player.getScore()+logoTimer);
        player.setAmountSolved();
    }

    public void initializeLogo(){
        logos = new ArrayList<Logo>();
        //add logo to the list
        logos.add(new Logo(Logo.Code.ABBOTT)); logos.add(new Logo(Logo.Code.ADOBE)); logos.add(new Logo(Logo.Code.AIRWALK)); 
        logos.add(new Logo(Logo.Code.AJINOMOTO)); logos.add(new Logo(Logo.Code.AMAZON)); logos.add(new Logo(Logo.Code.ARENA)); 
        logos.add(new Logo(Logo.Code.ASUS)); logos.add(new Logo(Logo.Code.ATARI)); logos.add(new Logo(Logo.Code.AXA)); 
        logos.add(new Logo(Logo.Code.BAJAJ)); logos.add(new Logo(Logo.Code.BEATS)); logos.add(new Logo(Logo.Code.BILLABONG)); 
        logos.add(new Logo(Logo.Code.BLOGGER)); logos.add(new Logo(Logo.Code.BOSCH)); logos.add(new Logo(Logo.Code.BRAUN)); 
        logos.add(new Logo(Logo.Code.BTS)); logos.add(new Logo(Logo.Code.BUGATTI)); logos.add(new Logo(Logo.Code.CARHARTT)); 
        logos.add(new Logo(Logo.Code.CHRISTIE)); logos.add(new Logo(Logo.Code.CISCO)); logos.add(new Logo(Logo.Code.CLINIQUE)); 
        logos.add(new Logo(Logo.Code.COMPAQ)); logos.add(new Logo(Logo.Code.CROCS)); logos.add(new Logo(Logo.Code.DAIHATSU)); 
        logos.add(new Logo(Logo.Code.DEBIAN)); logos.add(new Logo(Logo.Code.DHL)); logos.add(new Logo(Logo.Code.DIADORA)); 
        logos.add(new Logo(Logo.Code.DOLBY)); logos.add(new Logo(Logo.Code.DREAMWORKS)); logos.add(new Logo(Logo.Code.DUOLINGO)); 
        logos.add(new Logo(Logo.Code.ELECTROLUX)); logos.add(new Logo(Logo.Code.ETIHAD)); logos.add(new Logo(Logo.Code.EVERBEST)); 
        logos.add(new Logo(Logo.Code.FACEBOOK)); logos.add(new Logo(Logo.Code.FEDEX)); logos.add(new Logo(Logo.Code.FUJITSU)); 
        logos.add(new Logo(Logo.Code.GARNIER)); logos.add(new Logo(Logo.Code.GE)); logos.add(new Logo(Logo.Code.GIMP)); 
        logos.add(new Logo(Logo.Code.HERMES)); logos.add(new Logo(Logo.Code.HILTON)); logos.add(new Logo(Logo.Code.HSBC)); 
        logos.add(new Logo(Logo.Code.HUAWEI)); logos.add(new Logo(Logo.Code.HYUNDAI)); logos.add(new Logo(Logo.Code.IBM)); 
        logos.add(new Logo(Logo.Code.IKEA)); logos.add(new Logo(Logo.Code.INDOMIE)); logos.add(new Logo(Logo.Code.ISUZU)); 
        logos.add(new Logo(Logo.Code.ITUNES)); logos.add(new Logo(Logo.Code.JAGUAR)); logos.add(new Logo(Logo.Code.JBL)); 
        logos.add(new Logo(Logo.Code.JUVENTUS)); logos.add(new Logo(Logo.Code.KAWASAKI)); logos.add(new Logo(Logo.Code.KENWOOD)); 
        logos.add(new Logo(Logo.Code.KLM)); logos.add(new Logo(Logo.Code.KODAK)); logos.add(new Logo(Logo.Code.KYB)); 
        logos.add(new Logo(Logo.Code.LAYS)); logos.add(new Logo(Logo.Code.LEICA)); logos.add(new Logo(Logo.Code.LG)); 
        logos.add(new Logo(Logo.Code.LINUX)); logos.add(new Logo(Logo.Code.LOTTO)); logos.add(new Logo(Logo.Code.LUFTHANSA)); 
        logos.add(new Logo(Logo.Code.MASPION)); logos.add(new Logo(Logo.Code.MCAFEE)); logos.add(new Logo(Logo.Code.MENTOS)); 
        logos.add(new Logo(Logo.Code.MICHELIN)); logos.add(new Logo(Logo.Code.MOTOROLA)); logos.add(new Logo(Logo.Code.MSN)); 
        logos.add(new Logo(Logo.Code.NAKAMICHI)); logos.add(new Logo(Logo.Code.NBA)); logos.add(new Logo(Logo.Code.NESCAFE)); 
        logos.add(new Logo(Logo.Code.NICKELODEON)); logos.add(new Logo(Logo.Code.NOVOTEL)); logos.add(new Logo(Logo.Code.NUTELLA)); 
        logos.add(new Logo(Logo.Code.NVIDIA)); logos.add(new Logo(Logo.Code.OLAY)); logos.add(new Logo(Logo.Code.OMEGA)); 
        logos.add(new Logo(Logo.Code.OPEL)); logos.add(new Logo(Logo.Code.OXONE)); logos.add(new Logo(Logo.Code.PANTENE)); 
        logos.add(new Logo(Logo.Code.PEUGEOT)); logos.add(new Logo(Logo.Code.PFIZER)); logos.add(new Logo(Logo.Code.PIONEER)); 
        logos.add(new Logo(Logo.Code.POKEMON)); logos.add(new Logo(Logo.Code.PRINGLES)); logos.add(new Logo(Logo.Code.PUMA)); 
        logos.add(new Logo(Logo.Code.PYTHON)); logos.add(new Logo(Logo.Code.QANTAS)); logos.add(new Logo(Logo.Code.QUAKER)); 
        logos.add(new Logo(Logo.Code.RENAULT)); logos.add(new Logo(Logo.Code.ROLEX)); logos.add(new Logo(Logo.Code.RSS)); 
        logos.add(new Logo(Logo.Code.SANYO)); logos.add(new Logo(Logo.Code.SENNHEISER)); logos.add(new Logo(Logo.Code.SHISEIDO)); 
        logos.add(new Logo(Logo.Code.SIEMENS)); logos.add(new Logo(Logo.Code.SKULLCANDY)); logos.add(new Logo(Logo.Code.SNAPCHAT));
        logos.add(new Logo(Logo.Code.SPOTIFY)); logos.add(new Logo(Logo.Code.SRIRACHA)); logos.add(new Logo(Logo.Code.STABILO)); 
        logos.add(new Logo(Logo.Code.SUZUKI)); logos.add(new Logo(Logo.Code.TATA)); logos.add(new Logo(Logo.Code.TDK)); 
        logos.add(new Logo(Logo.Code.TESLA)); logos.add(new Logo(Logo.Code.TIMBERLAND)); logos.add(new Logo(Logo.Code.TOBLERONE)); 
        logos.add(new Logo(Logo.Code.TRIPADVISOR)); logos.add(new Logo(Logo.Code.TWITCH)); logos.add(new Logo(Logo.Code.UMBRO)); 
        logos.add(new Logo(Logo.Code.UNILEVER)); logos.add(new Logo(Logo.Code.VANS)); logos.add(new Logo(Logo.Code.VERSACE)); 
        logos.add(new Logo(Logo.Code.VIMEO)); logos.add(new Logo(Logo.Code.VOLVO)); logos.add(new Logo(Logo.Code.WAZE)); 
        logos.add(new Logo(Logo.Code.WHATSAPP)); logos.add(new Logo(Logo.Code.WIKIPEDIA)); logos.add(new Logo(Logo.Code.WORDPRESS)); 
        logos.add(new Logo(Logo.Code.XBOX)); logos.add(new Logo(Logo.Code.XEROX)); logos.add(new Logo(Logo.Code.YELP)); 
        logos.add(new Logo(Logo.Code.YOUTUBE)); logos.add(new Logo(Logo.Code.ZOOM));

        //randomize the logo position on the list
        Collections.shuffle(logos, new Random(System.currentTimeMillis()));
    }

}