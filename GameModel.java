package TypeShootGame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameModel {
List allLogo;
String word1 = new String();
String word2 = new String();

public GameModel(){
    initializeLogo();
    word1 = "-";
    word2 = "-";
}   

public void initializeLogo(){
    allLogo = new ArrayList<String>();

    allLogo.add("Love"); allLogo.add("Truth");
    allLogo.add("Epic"); allLogo.add("Business");
    allLogo.add("Wives"); allLogo.add("Interest");
    allLogo.add("Roses"); allLogo.add("Angel");
    allLogo.add("Empty"); allLogo.add("Spring");
    allLogo.add("Banana"); allLogo.add("Samba");
    allLogo.add("Dough"); allLogo.add("Thief");
    allLogo.add("Surf"); allLogo.add("Believe");

    Collections.shuffle(allLogo, new Random(System.currentTimeMillis()));
    /*
    String words[]={"Love", "Hate", "Truth", "Happy", "Pressure", "Burp", "Vampire"
    , "Surf", "Believe", "Slime", "Dream", "Religion", "Rhythm", "Disco", "Honey",
    "Star", "Armies", "Zombie", "Heart", "Break", "Docks", "Multiply", "Mace", "Moustache"
    , "Wizards", "Sports", "Blind", "Riddle", "Business", "School", "Blood", "Promenade",
    "Vault", "Spray", "Eternal", "Dress", "Abstain", "Controls", "Circuit", "Forever",
    "Dangerous", "Skunk", "House", "Wives", "Flashlight", "Console", "Awesome", "Scared",
    "Hormones", "Promise", "Angel", "Baggage", "Duck", "Destroy", "Tissue", "Ketchup",
    "Picture", "Basket", "Basketball", "Fan", "Dough", "Thief", "Female", "Family", "Normal",
    "Wireless", "Empty", "Cycles", "Banana", "Eggplant", "Samba", "Jumble", "Flush", "Beach",
    "Driver", "Queen", "Mommy", "Fade", "Kitten", "Spring", "Interest", "Debts", "Horse",
    "Tomorrow", "Discount", "Faithful", "Midnight", "Epic", "Calendar", "Roses", "Funeral",
    "Badminton", "Spirit", "Water", "Pizza", "Science", "Cabinet", "Apple", "Television",
    "Profile", "Wine", "Sedan", "Luxury", "Firewall", "Computer", "Tablet", "Giraffe", "Ring",
    "Shut", "Vision", "World", "War", "High", "School", "Fantasy", "Warfare", "Incognito",
    "Loading", "Penguins", "Fright", "Night", "Diary", "Mega", "Submit", "Hold", "Statue",
    "Boat", "Mobile", "Invisible", "Visible", "Ground", "Space", "Dragon", "Spade", "Clover",
    "Senior", "Junior", "Sophomore", "Freshman", "Twilight", "Dawn", "Eclipse", "Moon",
    "Hair", "Spray", "Camp", "Jazz", "Rock", "Eggs", "Hustle"};
    */
}

public void setCurrentWord1(){
    Random randnum = new Random();
    int roll;

    do{
        roll = randnum.nextInt(15);
    }while(Character.compare(allLogo.get(roll).toString().charAt(0), word2.charAt(0)) == 0);

    this.word1 = allLogo.get(roll).toString();
}

public void setCurrentWord2(){
    Random randnum = new Random();
    int roll;
    do{
        roll = randnum.nextInt(15);
    }while(Character.compare(word1.charAt(0), allLogo.get(roll).toString().charAt(0)) == 0);
    this.word2 = allLogo.get(roll).toString();
}

public String getWord1(){
    return this.word1;
}

public String getWord2(){
    return this.word2;
}
}