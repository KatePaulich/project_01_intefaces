package com.company;

import com.company.Chair;

import java.util.ArrayList;
import java.util.List;

public class ChairList {
    private List<Chair> chairList;

    public ChairList(){
        chairList = new ArrayList<>();
    }

    private void addChairList(Chair chair){
        chairList.add(chair);
    }

    public List<Chair> getChairList(){
        return chairList;
    }

    public void addChair(Chair newChair){
                   addChairList(newChair);
    }
}
