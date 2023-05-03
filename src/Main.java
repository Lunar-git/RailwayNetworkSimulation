import Exceptions.*;
import Generator.AppState;
import Generator.TrainSetGenerate;
import RailRoadCarTypes.RailRoadCar;
import Stations.*;
import Locomotive.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ConnectionException {
        Graph ns = new Graph(99);
        ArrayList<TrainSet> trainSets = TrainSetGenerate.generateTrainSets(ns, 2);
        for (TrainSet trainSet : trainSets){
            Thread speedThread = new Thread(trainSet.getLocomotive(), "Speed");
            Thread moveThread = new Thread(trainSet.getMovement(),"Move");
            speedThread.start();
            moveThread.start();
        }
        Thread logThread = new Thread(()->{
            while (true){
                for (TrainSet trainSet : trainSets) {
                    Collections.sort(trainSet.getCars(), new Comparator<RailRoadCar>() { // sort cars by GrossWeight
                        @Override
                        public int compare(RailRoadCar o1, RailRoadCar o2) {
                            return (int) ( o1.getGrossWeight() - o2.getGrossWeight());
                        }
                    });
                }
                Collections.sort(trainSets, new Comparator<TrainSet>() {
                    @Override
                    public int compare(TrainSet T1, TrainSet T2) {
                        return (int) (T2.getLocomotive().totalDistance - T1.getLocomotive().totalDistance);
                    }
                });
                System.out.println(trainSets);
                for (TrainSet trainSet : trainSets){
                    System.out.println(trainSet.getLocomotive().totalDistance);
                }
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                }
                for (TrainSet trainSet : trainSets) {
                    AppState.redirectConsoleToFile("AppState.txt.txt",trainSet.toString());
                }
            }
        });
        logThread.start();
/*        Thread speedThread = new Thread(loc, "Speed");
        Thread moveThread = new Thread(movement,"Move");
        speedThread.start();
        moveThread.start();*/

        //LocomotiveGenerate generate = new LocomotiveGenerate();
        //List<Locomotive> locomotives = generate.generateLocomotives(3);
        //Locomotive n = new Locomotive("Damn", ns);
        //n.getSpeed();
        //ns.test(Graph.generateStations(10));
        //Thread t3 = new Thread(n);
        //t3.start();

    }
}