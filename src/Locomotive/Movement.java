package Locomotive;

import Stations.Station;

import java.util.Collections;

public class Movement
        implements Runnable{

    private Locomotive locomotive;
    public boolean statistics;

    public Movement(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.statistics = false;
    }
    public void showStatistic(String message){
        if(statistics) {
            System.out.println(message);
        }
    }

    @Override
    public void run() {
        while(true) {
            for (Station station : locomotive.getRoute()) {
                if(station != locomotive.startStation){
                    showStatistic("TrainSet | " + TrainSet.getId() + " runs from "
                            + locomotive.currentStation + "to " + station + "\n");
                    double distToStation = station.distToStation(locomotive.currentStation);
                    while(locomotive.betweenDistance < distToStation ) {
                        synchronized (locomotive) {
                            locomotive.betweenDistance += locomotive.getSpeed();
                            showStatistic(Math.round(locomotive.betweenDistance)
                                    + " (" + Math.round(Math.min((locomotive.betweenDistance
                                    / distToStation) * 100, 100)) + "%)");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                            locomotive.notify();
                        }
                    }
                    showStatistic("\n");
                    showStatistic("TrainSet | " + TrainSet.getId() + " reached " + station + "\n");
                    locomotive.currentStation = station;
                    locomotive.betweenDistance = 0;
                    if(station == locomotive.endStation){
                        showStatistic(station + " reached last station ");
                        showStatistic("Waiting...");
                        Collections.reverse(locomotive.getRoute());
                        locomotive.endStation = locomotive.startStation;
                        locomotive.startStation = station;
                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                        }
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
