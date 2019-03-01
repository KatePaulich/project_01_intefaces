package com.company;



import com.company.Lamp;

import java.util.ArrayList;
import java.util.List;

public class LampList {
    private List<Lamp> lampLists;

    public LampList(){
        lampLists = new ArrayList<>();
    }

    public void addLampList(Lamp lamp){
        lampLists.add(lamp);
    }

    public List<Lamp> getLampLists(){
        return lampLists;
    }
}
