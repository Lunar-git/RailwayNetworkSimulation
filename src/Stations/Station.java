package Stations;

import Locomotive.Locomotive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Station {
    private String name;
    private Locomotive train;
    private int id;
    private static int counter;
    protected static HashMap<Station,Double> intersectsWith;
    private static ArrayList<Station> stations = new ArrayList<Station>();


    public Station(String name) {
        this.name = name;
        intersectsWith = new HashMap<>();
        this.id =  1 + counter++;
    }
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrain(Locomotive train) {
        this.train = train;
    }

    public Locomotive getTrain() {
        return train;
    }
    //Methods


    public HashMap<Station, Double> getIntersectsWith(Station station) {
        return intersectsWith;
    }

    public static ArrayList<Station> getStations() {
        return stations;
    }


    public void addIntersectionWith(Station station, double distance) {
        this.intersectsWith.put(station, (double) Math.round(distance));
        station.intersectsWith.put(this, (double) Math.round(distance));
    }

    public double distToStation(Station station){
        for(Map.Entry<Station, Double> entry : intersectsWith.entrySet()){
            if(entry.getKey().equals(station)){
                return entry.getValue();
            }
        }
        return 0;
    }
    @Override
    public String toString() {
        return ("[ID] " + getID() + " | Station | " + getName() + " | ");
    }
}
