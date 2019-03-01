package com.company;

import com.company.Sofa;

import java.util.ArrayList;
import java.util.List;

public class SofaList {
    private List<Sofa> sofaList;

    public SofaList(){
        sofaList = new ArrayList<>();
    }

    private void addSofaList(Sofa sofa){
        sofaList.add(sofa);
    }

    public List<Sofa> getSofaList(){
        return sofaList;
    }

    public void addSofa(Sofa newSofa){
        addSofaList(newSofa);
    }
}
