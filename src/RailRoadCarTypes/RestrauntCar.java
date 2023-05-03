package RailRoadCarTypes;

import Exceptions.LoadException;
import Interfaces.Electricity;

public class RestrauntCar
        extends RailRoadCar
        implements Electricity {
    private static int chairs, tables;
    private static final int maxNumChairs, maxNumTables;
    static {
        maxNumChairs = 120;
        maxNumTables = 60;
        chairs = 0;
        tables = 0;
    }
    public RestrauntCar(String shipper) {
        super(shipper);
        this.type = "Restaurant";
        this.grossWeight = Math.round(Math.random()*20000 + 40000);
        //power
        securityInfo = ("Access Control: It's important to ensure that only authorized personnel" +
                " have access to the restaurant railroad car, especially during operating hours." +
                " This can include using access cards, security codes, or physical locks to restrict access.\n" +
                "\n" +
                "Cash Management: The restaurant railroad car may handle cash and other valuable items, such as" +
                " credit card information, which makes it a potential target for theft. Adequate security measures," +
                " such as secure cash registers, video surveillance, and background checks on employees" +
                " can help to prevent theft and fraudulent activity.\n" +
                "\n" +
                "Fire Safety: Due to the nature of the restaurant business, there is a potential risk of fire." +
                " Proper fire safety measures such as smoke detectors, fire alarms, fire extinguishers," +
                " and training for employees on how to respond in case of a fire" +
                " can help to prevent accidents and minimize damage.\n" +
                "\n" +
                "Cybersecurity: Restaurant railroad cars may also be vulnerable to cyber threats such as hacking," +
                " data breaches, and other types of cyber attacks. Ensuring the security of" +
                " the restaurant's computer systems and networks, such as using strong passwords," +
                " regularly updating software, and installing antivirus software," +
                " can help to prevent these types of attacks.\n" +
                "\n" +
                "Food Safety: The restaurant must also maintain strict hygiene and sanitation standards to ensure" +
                " the safety of its customers. This includes proper handling and storage of food," +
                " regular cleaning of kitchen equipment, and ensuring" +
                " that employees follow safe food handling practices.\n" +
                "\n" +
                "Emergency Preparedness: Having a well-defined emergency response plan," +
                " such as a plan for evacuating the car in case of an emergency or disaster," +
                " can help to ensure the safety of employees and customers in the event of an emergency.");
    }

    public void bookTable(int chairs, int tables) throws LoadException {
        if(chairs + 1 > maxNumChairs || tables + 1 > maxNumTables) {
            throw new LoadException("There are no free chairs or tables left" +
                    "\n" + "Current number of chairs: " + this.chairs +
                    "\n" + "Current number of tables: " + this.tables);
        }
            this.chairs = this.chairs + chairs;
            this.tables = this.tables + tables;
    }

    public void cancellBooking(int chairs, int tables) throws LoadException {
        if(maxNumTables <= 0 || maxNumChairs <=0) {
            throw new LoadException("Reservation failed! No tables booked");
        }
        this.chairs = this.chairs - chairs;
        this.tables = this.tables - tables;
    }

    public int getNumChairs() {
        return chairs;
    }

    public int getNumTables() {
        return tables;
    }

    @Override
    public String toString() {
        return "Type : Restaurant Car " + "ID " + this.getID() + " Current Weight Load " +
                this.grossWeight + " kilos";
    }
}
