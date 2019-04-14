/**
 * Class Parking Slot is basically for initilising the new slots for the cars
 *
 * @author (your name)
 * @version 1.0
 */
public class ParkingSlot
{
    // instance variables
    private String slotId;
    private String slotType;
    private Car car;
    
    
    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot()
    {
        // initialise instance variables
        this.slotId = "";
        this.slotType = "";
        this.car = null;
    }

    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot(String slotId, String slotType){
        this.slotId = slotId;
        this.slotType = slotType;
    }

    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot(String slotId, String slotType, Car car){
        this.slotId = slotId;
        this.slotType = slotType;
        this.car = car;
    }
    
    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot(String slotId, Car car){
        this.slotId = slotId;
        this.car = car;
    }
    
    /**
     * Constructor for objects of class ParkingSlot
     */
    public ParkingSlot(String slotId){
        this.slotId = slotId;
    
    }
    
    /**
     * Getter method for returning the slot id of the parking slot
     *
     * @return    slot id of parking slot
     */
    public String getSlotId()
    {
        return this.slotId;
    }
    
    /**
     * Setter method for setting the slot id of the parking slot
     *
     * @param  slotId  slot id of the parking slot
     */
    public void setSlotId(String slotId)
    {
        this.slotId = slotId;
    }
    
    /**
     * Getter method for returning the slot type of the parking slot
     *
     * @return    slot type of parking slot
     */
    public String getSlotType()
    {
        return this.slotType;
    }
    
    /**
     * Setter method for setting the slot typpe of the parking slot
     *
     * @param  slotId  slot type of the parking slot
     */
    public void setSlotType(String slotType)
    {
        this.slotType = slotType;
    }
    
    /**
     * Getter method for returning the car parked at give parking slot
     *
     * @return    car at parking slot
     */
    public Car getCar()
    {
        return this.car;
    }
    
    /**
     * Setter method for placing the car at the parking slot
     *
     * @param  slotId  car for parking slot
     */
    public void setCar(Car car)
    {
        this.car = car;
    }
}