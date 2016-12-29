package com.example.student2.myprojectdd;

/**
 * Created by Андрей on 29.12.2016.
 */

public class Rifle extends Gun {
    public Rifle(Human master){
        this.x=master.x;
        this.y=master.y;
        this.speed=0.5f;
        this.rad=300;
    }

    @Override
    void shut(float xtuk, float ytuk) {

    }
}
