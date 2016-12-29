package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by student2 on 28.12.16.
 */
public abstract class Human {
    abstract void sit();
    Intellect intellect;
    abstract void decide();
    Gun gun;
    public Sost sost;
    float x,y;
    Paint paint=new Paint(0xffffffff);
    public void draw(Canvas canvas){
        canvas.drawCircle(this.x,this.y,10,this.paint);
    }
    Human(float x,float y){
        this.x=x;
        this.y=y;
    }
}
