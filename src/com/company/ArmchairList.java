package com.company;

import com.company.Armchair;

import java.util.ArrayList;
import java.util.List;

public class ArmchairList {
    private List<Armchair> armchairList;

    public ArmchairList(){
        armchairList = new ArrayList<>();
    }

    private void addArmchairList(Armchair armchair){
        armchairList.add(armchair);
    }

    public List<Armchair> getArmchairList(){
        return armchairList;
    }

    public void addArmchair(Armchair newArmchair){
            addArmchairList(newArmchair);
    }
}
