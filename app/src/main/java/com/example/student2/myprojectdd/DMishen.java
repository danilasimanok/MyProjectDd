package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by Андрей on 30.12.2016.
 */

public class DMishen extends Dino {
    Paint paint=new Paint(0xff00ff00);
    @Override
    void walk(Human human, int timeNach, int time) {

    }

    @Override
    void eat(Human human, int timeNach, int time) {

    }

    @Override
    void attack(Human human) {

    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawCircle(this.x,this.y,10,paint);
    }

    @Override
    public void decide(LinkedList<Human> humen, Dino dino, int time, int timeNach) {

    }
    public DMishen(float x,float y){
        this.x=x;
        this.y=y;
    }
}
