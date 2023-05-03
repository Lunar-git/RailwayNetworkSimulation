package RailRoadCarTypes;

import Exceptions.LoadException;

public class BaggageAndMailCar extends RailRoadCar {
    private static int mails, baggage;
    private static final int maxNumBaggage, maxNumMails;
    static {
        maxNumBaggage = 20000;
        maxNumMails = 2000;
        mails = 0;
        baggage = 0;
    }

    public BaggageAndMailCar(String shipper) {
        super(shipper);
        type = "Baggage";
        powered = true;
        this.grossWeight = Math.round(Math.random() * 60000 + 80000);
        securityInfo = ("Access Control: Baggage and mail railroad cars may contain sensitive and valuable items" +
                " such as mail, luggage, and other personal belongings. To prevent unauthorized access," +
                " it's important to ensure that the doors and windows of the car are secure and " +
                "that the car is properly locked when it's unattended.\n" +
                "\n" +
                "Cargo Security: The car may carry high-value items, such as cash or expensive electronics," +
                " which make it a potential target for theft. It's important to ensure that the cargo" +
                " is properly secured and that the car is only accessible to authorized personnel" +
                " who are properly trained and equipped to handle the cargo.\n" +
                "\n" +
                "Inspection and Maintenance: Baggage and mail railroad cars need to be regularly inspected" +
                " and maintained to ensure that they are in good working condition and that they are safe to operate." +
                " Any defects or damage to the car or its components should be promptly addressed and repaired.\n" +
                "\n" +
                "Communication and Tracking: It's important to have effective communication and tracking systems" +
                " in place to monitor the location and status of the baggage and mail railroad car and its cargo." +
                " This can help to detect and respond to any security threats or emergencies in a timely manner.\n" +
                "\n" +
                "Regulatory Compliance: Baggage and mail railroad cars and their operations are subject to various" +
                " regulations and standards, such as those related to safety, security, and privacy." +
                " Compliance with these regulations is critical to ensure the safe and secure operation of the baggage" +
                " and mail railroad car and to protect the public and their personal belongings.");
    }

    public void loadBaggage(int numberOfBaggage) throws LoadException {
       if(baggage == maxNumBaggage) {
           throw new LoadException("Loading failed! No capacity left");
       }
       this.baggage += numberOfBaggage;
    }

    public void unloadBaggage(int numberOfBaggage) throws LoadException {
        if(baggage <= 0) {
            throw new LoadException("Unloading failed! No baggage left");
        }
        this.baggage -= numberOfBaggage;
    }

    public void loadMail(int numberOfMail) throws LoadException {
        if(mails == maxNumMails) {
            throw new LoadException("Loading failed! No capacity left");
        }
        this.mails += numberOfMail;
    }

    public void unloadMail(int numberOfMail) throws LoadException {
        if(this.grossLoad == 0) {
            throw new LoadException("Loading failed! No mails left");
        }
            this.mails -= numberOfMail;
            System.out.println("Unloaded " + numberOfMail + " mail. Total number of mail: " + this.grossLoad);
    }

    public double getNumberOfBaggage() {
        return baggage;
    }

    public int getNumberOfMail() {
        return mails;
    }

    public String toString() {
        return "Type : Baggage and Mail Car " + " ID " + this.getID() + " Current Weight Load " +
                this.grossWeight + " kilos";
    }
}
