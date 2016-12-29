package com.example.student2.myprojectdd;

/**
 * Created by Андрей on 29.12.2016.
 */

public class Player extends Human {
    Player(float x,float y,Gun gun){
        this.x=x;
        this.y=y;
        this.intellect=new PlayerIntellect();
        this.gun=gun;
    }
}
