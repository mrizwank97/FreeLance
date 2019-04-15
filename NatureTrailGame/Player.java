public class Player
{
    private int score;
    private int position;
    private String name;

    public Player()
    {
        score = 0;
        position = 1;
        name = "";
    }
    
    public Player(int score, int position, String name)
    {
        this.score = score;
        this.position = position;
        this.name = name;
    }
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public int getScore() 
    {
        return score;
    }
    
    public void setScore(int score) 
    {
        this.score = score;
    }

    public int getPosition() 
    {
        return position;
    }
    
    public void setPosition(int position)
    {
        this.position = position;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }    
    
    @Override
    public String toString() {
        return "Player [score=" + score + ", position=" + position + ", name=" + name + "]";
    }
}
