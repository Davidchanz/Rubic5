package org.example;

import org.example.Rubic.Rubic;

import java.util.ArrayList;

public class Test {
    public Rubic rubic = new Rubic();
    public ArrayList<ShapeObject> ob = new ArrayList<>();
    Test(){
        rubic = new Rubic(2, 0,0,0);
        ob.addAll(rubic.get());
    }
    public static void main(String[] args) {
        new Test();
    }
}
