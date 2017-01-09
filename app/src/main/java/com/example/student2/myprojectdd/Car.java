package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by Андрей on 29.12.2016.
 */
public class Car {
    public float x1,y1,x2,y2,speed;
    public LinkedList<Human>inCar;
    private Paint paint=new Paint(0xff0000ff);
    public Car(float x1,float y1,float speed){
        this.x1=x1;
        this.y1=y1;
        this.x2=this.x1+30;
        this.y2=this.y1+20;
        this.speed=speed;
        this.inCar=new LinkedList<Human>();
    }

    public void draw(Canvas canvas) {
        // ??  canvas.drawRect(x1,y2,x2,y1,paint);
    }
}
