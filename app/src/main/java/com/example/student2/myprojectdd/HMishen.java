package com.example.student2.myprojectdd;

import android.graphics.Canvas;

import java.util.LinkedList;

/**
 * Created by Андрей on 30.12.2016.
 */

//для тестов с динозаврами
public class HMishen extends Human {
    public HMishen(float x, float y) {
        super(x, y, null, null);
    }

    @Override
    void decide(LinkedList<Dino> dinos, Car car, LinkedList<Shot> newShots) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
