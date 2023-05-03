package RailRoadCarTypes;

import Exceptions.CapacityException;
import Interfaces.Electricity;

public class PassengerCar
        extends RailRoadCar
        implements Electricity {

    private static int seats;
    private static final int maxSeats;
    static {
        maxSeats = 120;
        seats = 0;
    }

    public PassengerCar(String shipper) {
        super(shipper);
        type = "Pass";
        grossLoad = 40; //Capacity/Seats
        grossWeight = Math.round(Math.random()*20000 + 40000); // kilograms (baggage)
        securityInfo = ("Unauthorized Access: Unauthorized access to the railroad car can lead to theft, tampering," +
                " or other malicious activities. To prevent unauthorized access, it's important to ensure" +
                " that the doors and windows of the car are secure and that" +
                " the car is properly locked when it's unattended.\n" +
                "\n" +
                "Cargo Security: Railroad cars can transport valuable goods or hazardous materials" +
                " that can pose a security risk. It's important to ensure that the cargo is properly secured" +
                " and that the car is only accessible to authorized personnel who" +
                " are properly trained and equipped to handle the cargo.\n" +
                "\n" +
                "Inspection and Maintenance: Railroad cars need to be regularly inspected and maintained" +
                " to ensure that they are in good working condition and that they are safe to operate." +
                " Any defects or damage to the car or its components should be promptly addressed and repaired.\n" +
                "\n" +
                "Communication and Tracking: It's important to have effective communication and tracking systems" +
                " in place to monitor the location and status of the railroad car and its cargo." +
                " This can help to detect and respond to any security threats or emergencies in a timely manner.\n" +
                "\n" +
                "Regulatory Compliance: Railroad cars and their operations are subject to various regulations" +
                " and standards, such as those related to safety, security, and environmental protection." +
                " Compliance with these regulations is critical to ensure the safe and secure operation of" +
                " the railroad car and to protect the public and the environment.");

    }

    public void boardPessanger(int n) throws CapacityException {
        if(n + 1 > maxSeats) {
            throw new CapacityException("Boarding failed! No seats left");
        }
        this.seats += n;
    }

    public void getOffPassenger(int n) throws CapacityException {
        if(maxSeats <= 0) {
            throw new CapacityException("Getting off failed! No reserved seats found");
        }
        this.seats -= n;
    }

    public int getCapacity() {
        return maxSeats;
    }

    public int getNumberOfPassangers() {
        return seats;
    }

    @Override
    public String toString() {
        return "Type : PassengerCar " + " ID " + this.getID() + " Current Weight Load " +
                this.grossWeight + " kilos";
    }


}
