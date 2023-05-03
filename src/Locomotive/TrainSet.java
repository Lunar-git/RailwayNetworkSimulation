package Locomotive;

import RailRoadCarTypes.RailRoadCar;
import Generator.*;

import java.util.ArrayList;

public class TrainSet {
    private ArrayList<RailRoadCar> cars;
    protected Locomotive locomotive;
    protected Movement movement;
    protected boolean statistics;
    private static int id;
    private static int counter;


    static {
        counter = 1;
        id = 0;
    }

    public TrainSet(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.movement = new Movement(locomotive);
        this.cars = RailRoadGenerate.generateCars("test");
        this.id = counter++;
        this.statistics = false;
    }

    public static int getId() {
        return id;
    }

    public void setCars(ArrayList<RailRoadCar> cars) {
        this.cars = cars;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public ArrayList<RailRoadCar> getCars() {
        return cars;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public Movement getMovement() {
        return movement;
    }

    @Override
    public String toString() {
        return "\n TrainSet{ \n " + " cars= " + cars + ",\n locomotive= " + locomotive + " " + '}';
    }
}
