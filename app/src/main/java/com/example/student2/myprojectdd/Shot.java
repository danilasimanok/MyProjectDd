package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by student2 on 28.12.16.
 */
public class Shot {
    public int speed;
    private float sin,cos;
    public Paint paint=new Paint(0xffff0000);
    public float x,y;
    public int dmg;
    public Shot(float xc,float yc,float xtuk,float ytuk,int speed,int dmg){
        this.speed=speed;
        float a,b;
        a=xtuk-xc;
        b=ytuk-yc;
        this.sin=b/speed;
        this.cos=a/speed;
        this.x=xc;
        this.y=yc;
        this.dmg=dmg;
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(this.x,this.y,30,paint);
    };
    public void move(){
        this.x+=this.speed*this.cos;
        this.y+=this.speed*this.sin;
    };
}
