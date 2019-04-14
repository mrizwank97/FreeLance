import java.util.Scanner;
/**
 * This interface contain main method of the application which allow user to interact with system functionalities.
 *
 * @author (your name)
 * @version 1.0
 */
public interface Application
{

    public 
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  String args[] is the input parameters
     */
    static void main(String args[])
    {
        //Variables:
        //variable to end while loop
        boolean exit = true;
        //temp variable to hold car registration no.
        String regNo;
        //temp variable to hold name of owner.
        String owner;
        //temp variable to hold staff type
        String staff;
        //temp variable to hold slotId
        String slotId;
        //temp variable to hold slot type.
        String slotType;
        //variable for slot type comparison
        boolean isStaff=true;           
        //scaner variable            
        Scanner input = new Scanner(System.in);

        System.out.println(".....................Welcome to the Car Park System.....................");

        //Object of parking slot class
        ParkingSlot parkingSlot;  
        //object car park class
        CarPark carPark = new CarPark();  

        while(exit){
            
            System.out.println();
            System.out.println("Press 1 to Add a parking slot");
            System.out.println("Press 2 to Delete a parking slot");
            System.out.println("Press 3 to list all slots");
            System.out.println("Press 4 to park car");
            System.out.println("Press 5 to find a car");
            System.out.println("Press 6 to remove a car");
            System.out.println("Press 7 to exit");
            System.out.println();
            
            //variable for switch case statements
            int choice;
            choice = input.nextInt();

            switch (choice) {

                case 1:
                System.out.println("Enter parking slot id like A01, D06");
                slotId = input.next();
                if(slotId.length() == 3 && Character.isUpperCase(slotId.charAt(0)) && isNumeric(slotId)){
                    
                    System.out.println("Enter slot typer i.e. staff or visitor");
                    slotType = input.next();
                    
                    //adding new parking slot
                    parkingSlot = new ParkingSlot(slotId,slotType.toLowerCase());
                    carPark.addSlot(parkingSlot);
                }
                break;

                case 2:
                System.out.println("Enter parking slot id like A01, D06");                
                slotId = input.next();
                
                //check for slot id and remove the parking slot
                if(slotId.length() == 3 && Character.isUpperCase(slotId.charAt(0)) && isNumeric(slotId))
                {
                    carPark.removeSlot(slotId);

                }
                break;
                
                case 3:
                //print info about all availabale slots
                System.out.println("All Slots are:");
                carPark.listSlots();
                break;
                
                case 4:
                System.out.println("Enter Your Name:");
                owner =  input.next();
                System.out.println("Enter registration no. like A0123, D0655");                
                regNo = input.next();
                
                if(isCharacter(regNo))
                {
                    System.out.println("Enter parking slot id like A01, D06");
                    slotId = input.next();
                    
                    //parking a car at valid parking spot
                    if(slotId.length() == 3 && Character.isUpperCase(slotId.charAt(0)) && isNumeric(slotId))
                    {
                        System.out.println("Are you a visitor or a staff");
                        System.out.println("Press 1 for Staff");
                        System.out.println("Press 2 for Visitor");
                        slotType = input.next();
                        
                        //user is a staff
                        if(slotType .equals( "1"))
                        {
                            isStaff = true;
                            parkingSlot = new ParkingSlot(slotId);
                            parkingSlot.setSlotType("staff");
                        }
                        
                        //user is a visitor
                        else
                        {
                            isStaff = false;
                            parkingSlot = new ParkingSlot(slotId);
                            parkingSlot.setSlotType("visitor");
                        }

                        //find slot and park a car
                        if(slotId.equals(carPark.findSlot(parkingSlot)))
                        {
                            Car car = new Car(regNo,owner,isStaff);
                            parkingSlot.setCar(car);
                            carPark.parkCar(parkingSlot);
                        }
                    }
                }
                break;
                
                case 5:
                System.out.println("Enter registration no. like A0123, D0655");                
                regNo = input.next();
                
                //finding car if a car is parked
                if(isCharacter(regNo))
                {
                    carPark.findCar(regNo);
                }
                break;
                
                case 6:
                System.out.println("Enter Car Registration Number(registration number always starts with a capital letter, followed by a four-digit number):");
                regNo = input.next();
                
                //removing car from the parking slot
                if(isCharacter(regNo))
                {
                    carPark.removeCar(regNo);
                }
                break;
                
                case 7:
                exit = false;

            }
        }
    }
    
    /**
     * This method basically check the validity of the input type, i.e. whether id should be accepted or not
     *
     * @param  regNo  registration no. of the car
     * @return    the boolean variable reflecting validity 
     */
    public static boolean isCharacter(String regNo){
        
        boolean flag = false;
        //validity of the input 
        if(regNo.length() == 5 && Character.isUpperCase(regNo.charAt(0)) && isNumeric(regNo) )
        {
            flag = true;
        }
        
        else
        {
            System.out.println("Kindly Enter Valid Registration number");
            flag = false;
        }
        return flag;
    }

    /**
     * This method check whether the last four characters of an id are digits aur not
     *
     * @param  regNo  a sample parameter for a method
     * @return    bolean variable reflecting validity
     */
    public static boolean isNumeric(String regNo){
        boolean flag = false;
        for(int i=1;i<regNo.length();i++)
        {
            //checking character if it is a digit
            flag = Character.isDigit(regNo.charAt(i));
            if (flag)
            {
                flag = true;
            }
            else
            {
                flag = false;
            }
        }
        return flag;
    }
}