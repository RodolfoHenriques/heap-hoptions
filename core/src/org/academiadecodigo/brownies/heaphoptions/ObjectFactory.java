package org.academiadecodigo.brownies.heaphoptions;

import org.academiadecodigo.brownies.heaphoptions.menus.Lost;
import org.academiadecodigo.brownies.heaphoptions.menus.Win;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.*;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Building;

import java.util.LinkedList;

public class ObjectFactory {

    private CallCenter callCenter;
    private CoffeeShop coffeeShop;
    private Disco disco;
    private Home home;
    private LostCubicle lostCubicle;
    private School school;
    private Train train;
    private University university;
    private Lost lost;
    private Win win;


    public LinkedList<AbstractBuilding> createBuildings() {

        LinkedList<AbstractBuilding> list = new LinkedList<>();

        callCenter = new CallCenter();
        coffeeShop = new CoffeeShop();
        disco = new Disco();
        home = new Home();
        lostCubicle = new LostCubicle();
        school = new School();
        train = new Train();
        university = new University();
        lost = new Lost();
        win = new Win();

        home.setOpen(true);

        bootstrap();

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

    private void bootstrap() {

    disco.setSchool(school);

    home.setSchool(school);

    lostCubicle.setLost(lost);

    school.setDisco(disco);
    school.setUniversity(university);
    school.setCallCenter(callCenter);
    school.setCoffeeShop(coffeeShop);

    train.setWin(win);

    university.setCallCenter(callCenter);
    university.setCoffeeShop(coffeeShop);
    university.setWin(win);

    }


}
