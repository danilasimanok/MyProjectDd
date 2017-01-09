package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by Андрей on 29.12.2016.
 */

public class Rifle extends Gun {
    public Rifle(float x,float y,boolean isPlayer){
        this.x=x;
        this.y=y;
        this.speed=100;
        this.rad=1000;
        this.reload=180;
        this.gotov=this.reload;
        if(isPlayer)this.rSpeed=60;
        else this.speed=1;
    }

    @Override
    void shut(float xtuk, float ytuk,LinkedList<Shot> newShots) {
        if(this.gotov==this.reload){
            newShots.add(new Shot(xtuk,ytuk,this));
            this.gotov=0;
        }
        else this.gotov+=this.rSpeed;
    }
}
