package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public abstract class Intellect {
    public abstract void decide(LinkedList<Dino> dinos, Car car,Human thisHuman,LinkedList<Shot>newShots);
    public abstract void playerDecide(float x, float y, LinkedList<Shot> newShots, Player player);
}
