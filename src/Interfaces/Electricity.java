package Interfaces;


import java.util.UUID;

public interface Electricity {
    default boolean isConnected(boolean isConnected) {
        return isConnected;
    }

    default boolean connect(int id) {
        System.out.println("Successfully connected car with ID: " + id + " to the grid");
        return true;
    }
}
