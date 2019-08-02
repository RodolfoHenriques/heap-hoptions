package org.academiadecodigo.brownies.heaphoptions;

import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.*;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Building;

import java.util.LinkedList;

public class ObjectFactory {

    public static LinkedList<AbstractBuilding> createBuildings(){

        LinkedList<AbstractBuilding> list = new LinkedList<>();

        CallCenter callCenter = new CallCenter();
        CoffeeShop coffeeShop = new CoffeeShop();
        Disco disco = new Disco();
        Home home = new Home();
        LostCubicle lostCubicle = new LostCubicle();
        School school = new School();
        Train train = new Train();
        University university = new University();

        home.setOpen(true);

        list.add(callCenter);
        list.add(coffeeShop);
        list.add(disco);
        list.add(home);
        list.add(lostCubicle);
        list.add(school);
        list.add(train);
        list.add(university);

        return list;
    }

}
