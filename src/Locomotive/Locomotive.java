package Locomotive;

import Exceptions.RailroadHazard;
import RailRoadCarTypes.*;
import Stations.Graph;
import Stations.Station;

import java.util.ArrayList;
import java.util.Random;

public class Locomotive
        extends Thread
        implements Runnable{
    private String name;
    private Graph route;
    private ArrayList<RailRoadCar> carlist;
    public ArrayList<Station> stations;
    public ArrayList<Station> stationArrayListMap;
    public boolean statistics;
    private static int counter;
    public Station startStation;
    public Station currentStation;
    public Station endStation;
    private int id;
    private static int maxWeight;
    private static int maxConnected;
    private static int maxCars;
    private static double speed;
    protected double betweenDistance;
    public double totalDistance;
    private static final Random random = new Random();

    static {
        counter = 1;
        maxCars = 11;
        maxWeight = 500000;
        maxConnected = 5;
        speed = Math.round(Math.random() * 20 + 80);
    }


    public Locomotive(String name, Graph route) {
        this.name = name;
        this.route = route;
        this.startStation = route.getRandomStartingStation();
        this.endStation = route.getRandomEndStation(startStation);
        this.currentStation = startStation;
        this.carlist = new ArrayList<RailRoadCar>();
        this.id = counter++;
        this.stationArrayListMap = route.buildRoute(startStation, endStation);
        this.betweenDistance = 0;
        this.totalDistance = Graph.getDistanceBetweenStations(stationArrayListMap);
        this.statistics = false;
    }

    public void showStatistic(String message){
        if(statistics) {
            System.out.println(message);
        }
    }
    public ArrayList<Station> getRoute() {
        return stationArrayListMap;
    }

    public double getSpeed() {
        return speed;
    }


    public void speedChange() throws RailroadHazard {
        if (this.speed < 200) {
            if (random.nextBoolean()) {
                this.speed += Math.round((this.speed * 3) / 100);
            } else {
                this.speed -= Math.round((this.speed * 3) / 100);
            }
        } else {
            throw new RailroadHazard("Train with id " + this.id + " exceeds the speed limit (200)");
        }
    }

    public int getID() {
        return id;
    }

    @Override
    public void run() {
        while(true) {
            try {
                speedChange();
                //System.out.println("TrainId: " + id + " Speed: " + speed);
                synchronized (this) {
                    wait();
                }
            } catch (RailroadHazard | InterruptedException e) {
               break;
            }
        }
    }

    public String toString() {
        return " Name | " + this.name + " | ID | " + this.stationArrayListMap;
    }
}
/*

 */
