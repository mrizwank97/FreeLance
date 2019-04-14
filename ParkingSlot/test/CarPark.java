import java.util.HashMap;
/**
 * This class is responsible for maintaining the list of available parking spots, adding parking slots, removing parking slots, listing the parking slots, parking the car, finding the car and removing the car. 
 *
 * @author (your name)
 * @version 1.0
 */
public class CarPark
{
    // instance variables
    private HashMap<String, ParkingSlot> map;

    /**
     * Constructor for objects of class CarPark
     */
    public CarPark()
    {
        // initialise instance variables
        map = new  HashMap<>();
    }
    
    /**
     * This method is responsible for allocating the car at given parking slot by validating the slot type.
     *
     * @param  parkingSlot  parking slot object
     */
    public void parkCar(ParkingSlot parkingSlot)
    {
        //get slot id of parking slot
        String slotId = parkingSlot.getSlotId();
        //check if owner is staff
        boolean isStaff = parkingSlot.getCar().getIsStaff();
        String staff;
        
        if(isStaff)
        {
            staff = "staff";
        }
        
        else
        {
            staff  ="visitor";
        }
        
        if(this.map.get(slotId).getSlotType().equals(staff) )
        {
            this.map.put(slotId,parkingSlot);
            System.out.println("Car is place at slot id " +slotId);
        }
        
        else
        {
            System.out.println("The slot you have requested is reserved for other type of customers");
        }
    
    }
    
    /**
     *This method returns the slot id if slot is available and is not in use by anyone.
     *
     * @param  parkingSlot  parking slot to find
     * @return    slot id of the parking slot
     */
    public String findSlot(ParkingSlot parkingSlot)
    {
        //not slots added
        if(!this.map.isEmpty()){
            String slotId = parkingSlot.getSlotId();
            parkingSlot = this.map.get(slotId);
            //if a car is already parked
            if(parkingSlot.getCar() != null){
                String regNo = parkingSlot.getCar().getRegNo();
                System.out.println("Slot not available. A car with registration no: " + regNo+ " is already parked there.");
                return null;
            }
            else
            {
                return slotId;
            }
        }
        else
        {
            System.out.println("No parking slots have been created.");
            return null;
        }
    }

    /**
     * This method basically adds new parking slots to the system
     *
     * @param  parkingSlot  parking slot for adding the new slots
     */
    public void addSlot(ParkingSlot parkingSlot)
    {
        this.map.put(parkingSlot.getSlotId(),parkingSlot);
        System.out.println("New Parking slot having slot id "+ parkingSlot.getSlotId()+ " has been added");
    }
    
    /**
     * This method basically removes the existing parking slot.
     *
     * @param  slotId  slot id of the parking slot
     */
    public void removeSlot(String slotId)
    {
        //no parking slots in system
        if(!this.map.isEmpty()){
            //check if given slot id is avaialable
            if(this.map.containsKey(slotId))
            {
                ParkingSlot ps = this.map.get(slotId);
                //if a car is parked
                if(ps.getCar() != null)
                {
                    String regNo = ps.getCar().getRegNo();
                    System.out.println("Unable to remove parking slot. A car with registration no: " + regNo+ " is already parked there.");
                }
                //remove the slot
                else
                {  
                    this.map.remove(slotId);
                    System.out.println("A parking slot with slot id:  " + slotId + " has been removed");
                }
            }
            else
            {
                System.out.println("A parking slot against slot id:  " + slotId + " does not exist");
            }
        }
        else
        {
            System.out.println("Parking slots have not been initialized.");
        }
    }
     
    /**
     * This method basically finds the car by registration no if it is parked.
     *
     * @param  regNo  registration no of the car
     */
    public void findCar(String regNo)
    {
        //no slots in the system
        if(!this.map.isEmpty())
        {
            boolean carFound = false;
            //compare with every slot
            for (String i : this.map.keySet())
            {
                ParkingSlot parkingSlot = this.map.get(i);
                //if a car is parked
                if(parkingSlot.getCar() != null)
                {
                    //compare the registration nos.
                    if(parkingSlot.getCar().getRegNo().equals(regNo))
                    {
                        carFound = true;
                        String owner = parkingSlot.getCar().getOwner();
                        boolean isStaff = parkingSlot.getCar().getIsStaff();
                        //owner is a visitor
                        if(!isStaff)
                        {
                            System.out.println("Car Founded.");
                            System.out.println("...........Car Information.......");
                            System.out.println("Registration No: "+regNo);
                            System.out.println("Owner name: "+owner);
                            System.out.println("Slot Id: "+ i);
                            System.out.println("Owner is a visitor");
                            System.out.println("..................................");
                        }
                        //owner is a staff.
                        else
                        {
                            System.out.println("Car Founded.");
                            System.out.println("...........Car Information.......");
                            System.out.println("Registration No: "+regNo);
                            System.out.println("Owner name: "+owner);
                            System.out.println("Slot Id: "+ i);
                            System.out.println("Owner is a staff");
                            System.out.println("..................................");
                        }
                    }
                }
            }
            //no car found
            if(!carFound)
            {
                System.out.println("A car with registration no " + regNo + " is not parked.");
            }
        }
        else
        {
            System.out.println("Parking slots have not been initialized.");
        }
    }
    
    /**
     * This method removes the car from the parking slot by the registration number
     *
     * @param  regNo  registration no of the car
     */
    public void removeCar(String regNo)
    {
        if(!this.map.isEmpty())
        {
            boolean carFound = false;
            //check all the slots
            for (String i : this.map.keySet())
            {
                ParkingSlot ps = this.map.get(i);
                //car is parked at slot
                if(ps.getCar() != null)
                {
                    //check its registration no.
                    if(ps.getCar().getRegNo().equals(regNo))
                    {
                        carFound = true;
                        ps.setCar(null);
                        this.map.put(i,ps);
                        System.out.println("Car has been removed from parking slot with slot id " + i);
                    }
                }
            }
            //no car is parked
            if(!carFound)
            {
                System.out.println("A car with registration no " + regNo + " is not parked.");
            }
        }
        else
        {
            System.out.println("Parking slots have not been initialized.");
        }
    }
    
    /**
     * This method basically list all the information about all the available parking slots. 
     *
     */
    public void listSlots()
    {
        System.out.println(".................Parking Slots Information.................");
        System.out.println();
        //iterate each parking slot
        for (String i : this.map.keySet()){
            ParkingSlot ps = this.map.get(i);
            //if a car is parked
            if(ps.getCar() != null){
                String regNo = ps.getCar().getRegNo();
                String owner = ps.getCar().getOwner();
                String slotType = ps.getSlotType();
                boolean isStaff = ps.getCar().getIsStaff();
                //owner of car is visitor
                if(!isStaff)
                {
                    System.out.println("Car Founded at slotId "+i);
                    System.out.println("...........Car Information.......");
                    System.out.println("Registration No: "+regNo);
                    System.out.println("Owner name: "+owner);
                    System.out.println("Slot Id: "+ i);
                    System.out.println("Slot Type: " + slotType);
                    System.out.println("Owner is a visitor");
                    System.out.println("..................................");
                    System.out.println();
                }
                //owner of car is staff
                else
                {
                    System.out.println("Car Founded at slotId "+i);
                    System.out.println("...........Car Information.......");
                    System.out.println("Registration No: "+regNo);
                    System.out.println("Owner name: "+owner);
                    System.out.println("Slot Id: "+ i);
                    System.out.println("Owner is a staff");
                    System.out.println("..................................");
                }
            }
            //no car is parked at the slot
            else{
                System.out.println("No car at slotId"+i);
                System.out.println("SlotType: "+ ps.getSlotType());
                System.out.println();
            }
        }
        System.out.println(".................Parking Slots Information.................");
    }

}
