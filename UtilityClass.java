package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

public class UtilityClass {
    int entryNum;
    Galamsey[] galamseys;
    boolean isFull;
    int numOperations;

    UtilityClass() {
        entryNum = 0;
        galamseys = new Galamsey[0];
    }

    UtilityClass(int entryNum) {
        this.entryNum = entryNum;
        galamseys = new Galamsey[entryNum];
    }

    //ACCESSOR AND MUTATOR METHODS
    public int getEntryNum() {
        return entryNum;
    }

    public void setEntryNum(int entryNum) {
        this.entryNum = entryNum;
    }

    public Galamsey[] getGalamseys() {
        return galamseys;
    }

    public void setGalamseys(Galamsey[] galamseys) {
        this.galamseys = galamseys;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getNumOperations() {
        return numOperations;
    }

    public void setNumOperations(int numOperations) {
        this.numOperations = numOperations;
    }

    boolean isEmpty() {
        return numOperations == 0;
    }

    boolean isFull() {
        return numOperations == entryNum;
    }


    void addEntry(Galamsey operation) {
        if (isEmpty()) {
            galamseys[0] = operation;
            numOperations++;
        } else if (!isEmpty())
            for (int i = 1; i < galamseys.length; i++) {
                if (galamseys[i] == null) {
                    galamseys[i] = operation;
                    numOperations++;
                    break;
                }
            }
    }

    void removeEntry(Galamsey operation) {
        if (isEmpty()) {
            System.out.print("No operation available");
        } else
            for (int i = 0; i <= numOperations; i++) {
                if (galamseys[i].equals(operation)) {
                    galamseys[i] = null;
                    numOperations--;
                }
            }
    }

    String allOperations() {

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < numOperations; i++) {
            newString.append("Operation ").append(i + 1).append(operationList().get(i).toString()).append("\n\n");
        }
        return newString.toString();
    }

    public ArrayList<Galamsey> operationList() {
        ArrayList<Galamsey> operations = new ArrayList<>(numOperations);
        for (Galamsey galamsey : galamseys) {
            if (galamsey != null) {
                operations.add(galamsey);
            }
        }
        return operations;
    }

    void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\Galamsey Data.txt");
        fileWriter.write("GALAMSEY OPERATIONS\n");
        fileWriter.write(allOperations());
        fileWriter.close();
        System.out.println("Galamsey Data Done");
    }
}