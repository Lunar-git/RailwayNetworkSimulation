package RailRoadCarTypes;

import Exceptions.LoadException;
import Interfaces.Electricity;

public class PostOfficeCar
        extends RailRoadCar
        implements Electricity {
    private static int mailsStack;
    private static int counter;
    private int id;
    private static final int maxMails;
    static {
        maxMails = 200;
        mailsStack = 0;
    }

    public PostOfficeCar(String shipper) {
        super(shipper);
        type = "Post";
        this.grossWeight = Math.round(Math.random()*10000 + 30000);
        this.id = counter++;
        //power
        securityInfo = ("Locks: Postal railroad cars have locks installed on the doors to prevent unauthorized access." +
                " These locks are designed to withstand tampering and are typically controlled by postal employees.\n" +
                "\n" +
                "Surveillance cameras: Many postal railroad cars have surveillance cameras installed inside to monitor" +
                " the activity and ensure the safety of postal workers and mail.\n" +
                "\n" +
                "Security personnel: Postal railroad cars are often accompanied by security personnel who are trained" +
                " to handle security threats and respond to emergencies.\n" +
                "\n" +
                "Alarms: Postal railroad cars may have alarms that are triggered in the event of a security breach," +
                " alerting postal workers and law enforcement authorities.\n" +
                "\n" +
                "GPS tracking: Some postal railroad cars are equipped with GPS tracking devices that allow" +
                " postal authorities to monitor their location and ensure they stay on their intended route.\n" +
                "\n" +
                "Restricted access: Access to postal railroad cars is restricted to authorized personnel only." +
                " Postal workers are required to undergo background checks and other" +
                " security screening measures before being granted access to these cars.");
    }

    public void receiveLetters(int numberOfLetters) throws LoadException {
        if(mailsStack == maxMails) {
            throw new LoadException("The mail Stack is full" + this.mailsStack);
        }
            this.mailsStack += numberOfLetters;
    }

    public void unloadLetters(int numberOfLetters) throws LoadException {
        if(maxMails <=0) {
            throw new LoadException("Unload failed! No letters to unload");
        }
        this.mailsStack -= numberOfLetters;
    }

    public int getNumberOfLetters() {
        return mailsStack;
    }

    @Override
    public String toString() {
        return "Type: Post Office Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
