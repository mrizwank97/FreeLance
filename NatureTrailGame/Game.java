import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game
{
    static int start;
    static int finish ;
    static Scanner input = new Scanner(System.in);
    static HashMap<String,Integer> animals = new HashMap<>();
    
    public static void main(String args[]){
        int move = 0;
        int trailLength;
        String humanName;
        String tossWin;
        Trail trail = new Trail();
        Dice dice = new Dice(1,4);
        Player playerH = new Player();
        Player playerC = new Player();
        
        welcome();
        
        trailLength = requestLength();
        start = 1;
        finish = trailLength;
        
        humanName = getHumanName();
        playerH.setName(humanName);
        playerC.setName("Computer");
        
        populateAnimals();
        generateFeaturesPositions(trail, trailLength);
        
        tossWin = decideTurn(dice, humanName);
        System.out.println(tossWin + " is starting game by moving first.");
        
        if(tossWin.equals(humanName))
        {
            while(playerC.getPosition() != trailLength || playerH.getPosition() != trailLength)
            {
                System.out.println();
                System.out.println(humanName + " press enter to roll dice: ");
                input.nextLine();
                move = rollDice(dice);
                System.out.println(humanName + " gets: " + move);
                System.out.println();
                if(checkPlayerMove(move, trailLength, playerH))
                {
                    break;
                }
                checkForFeatures(trail,playerH);
                System.out.println();
                System.out.println("Computer rolls the dice: ");
                move = rollDice(dice);
                System.out.println("Computer gets: " + move);
                System.out.println();
                if(checkPlayerMove(move, trailLength, playerC))
                {
                    break;
                }
                checkForFeatures(trail, playerC);
            }
        }
        else
        {
            while(playerC.getPosition() != trailLength || playerH.getPosition() != trailLength)
            {
                System.out.println();
                System.out.println(humanName + " press enter to roll dice: ");
                input.nextLine();
                move = rollDice(dice);
                System.out.println(humanName + " gets: " + move);
                System.out.println();
                if(checkPlayerMove(move, trailLength, playerC))
                {
                    break;
                }
                checkForFeatures(trail, playerC);
                System.out.println();
                System.out.println("Computer rolls the dice: ");
                move = rollDice(dice);
                System.out.println("Computer gets: " + move);
                System.out.println();
                if(checkPlayerMove(move, trailLength, playerH))
                {
                    break;
                }
                checkForFeatures(trail, playerH);
            }
        }
        
        trailWithPlayers(trailLength, playerH, playerC);
        gameResult(playerH, playerC);
    }

    public static int requestLength()
    {
        int length = 0;
        boolean flag = true;
        while(flag)
        {
            System.out.println("Enter the length of Trail From 10 - 20");
            length = input.nextInt();
            if(length >= 10 && length <=20) 
            {
                flag =false;
            }
        }
        return length;
    }

    public static String getHumanName()
    {
        String name = "";
        boolean flag = true;
        while(flag)
        {
            System.out.println("Enter your Name:");
            name = input.next();
            if(name.length() >= 1 && name.length() <=6) 
            {
                flag =false;
            }
        }
        return name;
    }
    
    public static String decideTurn(Dice dice, String humanName){
        int tossC = 0;
        int tossH = 0;
        while(tossC == tossH)
        {
            System.out.println("Computer rolling the dice: ");
            tossC = (rollDice(dice));
            System.out.println("Computer gets: " + tossC);
            System.out.println(humanName + " press enter to roll dice: ");
            input.nextLine();
            tossH = (rollDice(dice));
            System.out.println(humanName + " gets: " + tossC);
            System.out.println();
        }
        if(tossH > tossC)
        {
            return humanName;
        }
        else
        {
            return "Computer";
        }
    }
    
    
    public static int rollDice(Dice dice)
    {
        int value;
        Random random = new Random();
        value = random.nextInt(dice.getMaximumValue()) + dice.getMinimumValue();
        return value;
    }
    
    public static void generateFeaturesPositions(Trail trail, int trailLength)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i < trailLength; i++) 
        {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i = 0; i < 4; i++) 
        {
            NatureFeature nf = trail.features.get(i);
            nf.setFeaturePosition(list.get(i));
        }
    }
    
    public static void populateAnimals()
    {
        animals.put("Koala", 10);
        animals.put("Emu", 7);
        animals.put("Wombat", 5);
        animals.put("Kangaro", 2);
        animals.put("Redback Spider", -5);
    }
    
    public static void welcome()
    {
        System.out.println("...........................Welcome To Nature Trail Game...........................");
        System.out.println("In order to decide the first turn each player will alternatively roll the dice.");
        System.out.println("The Player getting higher no. will start its turn");
        System.out.println();
    }
    
    public static void gameResult(Player H, Player C)
    {
        System.out.println();
        System.out.println("The score of Computer is " + C.getScore());
        System.out.println("The score of " + H.getName() + " is " + H.getScore());
        System.out.println();
    }
    
    public static void trailWithPlayers(int trailLength, Player H, Player C)
    {
        String trail = "";
        int pos_H = H.getPosition();
        int pos_C = C.getPosition();
        boolean flag = false;
        for(int i = 1; i <= trailLength; i++)
        {
            if(i == 1)
            {
                trail = trail + "S";
                flag = true;
            }
            if(i == pos_H)
            {
                trail = trail + "H";
                flag = true;
            }
            if(i == pos_C)
            {
                trail = trail + "C";
                flag = true;
            }
            if(i == trailLength)
            {
                trail = trail + "F";
                flag = true;
            }
            if(!flag)
            {
               trail = trail + " _ "; 
            }
            flag = false;
        }
        System.out.println();
        System.out.println(trail);
        System.out.println();
    }
    
    //todo: implement the probability of animal sighting and update score
    public static boolean checkPlayerMove(int move, int trailLength, Player p)
    {
        String name = p.getName();
        if(p.getPosition() + move < trailLength)
        {
            p.setPosition(p.getPosition() + move);
            System.out.println();
            System.out.println(name + " moves " + move + " steps forward");
            if(new Random().nextDouble() <= 0.5)
            {
                ArrayList<String> an = new ArrayList<>();
                an.add("Koala");
                an.add("Emu");
                an.add("Wombat");
                an.add("Kangaro");
                an.add("Redback Spider");
                Random r = new Random();
                int val = r.nextInt(4);
                int score = animals.get(an.get(val));
                p.setScore(p.getScore()+score);
                System.out.println(name + " has seen " + an.get(val) + " and gets score of " + score);
                System.out.println();
            }
            return false;
        }
        else
        {
            p.setPosition(trailLength);
            p.setScore(p.getScore()+10);
            System.out.println();
            System.out.println(name + " moves " + move + " steps forward and reached at finsish state");
            System.out.println();
            return true;
        }
        
    }
    
    public static void checkForFeatures(Trail t, Player p)
    {
        int pos = p.getPosition();
        String name = p.getName();
        for(int i = 0; i < 4; i++)
        {
            NatureFeature nf = t.features.get(i);
            if(pos == nf.getFeaturePosition())
            {
                System.out.println();
                System.out.println(name +" came across nature feature " + nf.getFeatureType());
                System.out.println(name + " moves " + nf.getSpacePenalty() + " steps");
                System.out.println();
                if(pos + nf.getSpacePenalty() > 1)
                {
                    p.setPosition(pos + nf.getSpacePenalty());
                }
                else
                {
                    p.setPosition(1);
                }
            }
        }
    }
}