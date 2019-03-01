package com.company;

import com.company.Bed;

import java.util.ArrayList;
import java.util.List;

public class BedList {
    private List<Bed> bedList;

    public BedList(){
        bedList = new ArrayList<>();
    }

    private void addBedList(Bed bed){
        bedList.add(bed);
    }

    public List<Bed> getBedList(){
        return bedList;
    }

    public void addBed(Bed newBed){
            addBedList(newBed);
    }
}
