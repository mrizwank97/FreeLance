public class Dice
{
    private int maximumValue;
    private int minimumValue;

    public Dice()
    {
        maximumValue = 0;
        minimumValue = 0;
    }
    
    public Dice(int minimumValue, int maximumValue)
    {
        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
    }

    public Dice(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
    
    public int getMaximumValue() {
        return maximumValue;
    }
    
    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
    }
    
    public int getMinimumValue() {
        return minimumValue;
    }
    
    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }
}
