package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class Human {
    public boolean inCar=false;
    public Intellect intellect;
    public Gun gun;
    public Sost sost;
    public int hp=2,speed=1;
    float x,y;
    Paint paint=new Paint(0xffffffff);

    void move(Car car){
        if(this.x<car.x1)this.x+=this.speed;
        else this.x-=this.speed;
        this.gun.x=this.x;
    };
    void decide(LinkedList<Dino>dinos,Car car,LinkedList<Shot>newShots){this.intellect.decide(dinos,car,this,newShots);};
    public void shut(Dino dinoCel,LinkedList<Shot>newShots){
        this.gun.shut(dinoCel,newShots);
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(this.x,this.y,10,this.paint);
    }
    public Human(float x,float y,Intellect intellect,Gun gun){
        this.x=x;
        this.y=y;
        this.intellect=intellect;
        this.gun=gun;
    }
}
