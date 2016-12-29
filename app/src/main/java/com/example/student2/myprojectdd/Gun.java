package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public abstract class Gun {
    public float x,y,speed,rad;
    abstract void shut(float xtuk, float ytuk, LinkedList<Shot>newShots);
    void shut(Dino dinoCel,LinkedList<Shot>newShots){shut(dinoCel.x,dinoCel.y,newShots);};
}
