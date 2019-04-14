
/**
 * Car class is basically for creating the car object having information like registration no. of car, owner of car and owner type of car.
 *
 * @author (your name)
 * @version 1.0
 */
public class Car
{
    // instance variables 
    private String regNo;
    private String owner;
    private boolean isStaff;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        this.regNo = "";
        this.owner = "";
        this.isStaff = false;
    }
    
    /**
     * Constructor for objects of class Car
     */
    public Car(String regNo,String owner,boolean isStaff)
    {
        this.regNo = regNo;
        this.owner = owner;
        this.isStaff = isStaff;
    }
    
    /**
     * Getter method for returning the registration no. of car
     *
     * @return    registration no. of car
     */
    public String getRegNo()
    {
        // put your code here
        return this.regNo;
    }
    
    /**
     * Setter method for setting the registration no. of car
     *
     * @param  regNo  registration no. of car
     */
    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }
    
    /**
     * Getter method for returning the owner of car
     *
     * @return    owner of car
     */
    public String getOwner()
    {
        return this.owner;
    }
    
    /**
     * Setter method for setting the owner of car
     *
     * @param  owner  owner of car
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
    
    /**
     * Getter method for returning the boolean value showing whether the owner is a staff or visitor
     *
     * @return    boolean value
     */
    public boolean getIsStaff()
    {
        return this.isStaff;
    }
    
    /**
     * Setter method for setting the boolean value of owner type
     *
     * @param  isStaff  boolean value
     */
    public void setIsStaff(boolean isStaff)
    {
        this.isStaff = isStaff;
    }
}