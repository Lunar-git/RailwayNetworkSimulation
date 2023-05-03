package RailRoadCarTypes;


public abstract class RailRoadCar {
    //Main
    private static int counter;
    private int id;
    protected String shipper;
    protected String securityInfo;
    protected double netWeight;
    protected double grossWeight;
    protected boolean powered = true;
    protected int grossLoad;
    protected int netLoad;
    protected boolean isPowered;
    protected String type;



    public RailRoadCar(String shipper) {
        this.shipper = shipper;
        this.id = counter++;
        this.grossWeight = 0;
    }

    public int getID() {
        return id;
    }

    public String getShipper() {
        return shipper;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public double getNetWeight() {
        return this.netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public int getGrossLoad() {
        return grossLoad;
    }

    public int getNetLoad() {
        return this.netLoad;
    }


    public String displayInfo() {
        return String.format("Shipper: %s \nMax weight: %d %s,\nMax Load: %d,\nConnected to electrical grid: %b",
                shipper, grossWeight, grossLoad, powered);
    }
}
