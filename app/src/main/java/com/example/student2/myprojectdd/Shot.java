package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by student2 on 28.12.16.
 */
public class Shot {
    private float sin,cos;
    public Paint paint=new Paint(0xffff0000);
    public float x,y,rad,xn,yn,speed;
    public int dmg;
    public Shot(float xtuk,float ytuk,Gun gun){
        this.speed=gun.speed;
        float a,b,c;
        a=xtuk-gun.x;
        b=ytuk-gun.y;
        c=(float) Math.sqrt(a*a+b*b);
        this.sin=b/c;
        this.cos=a/c;
        this.x=gun.x;
        this.y=gun.y;
        this.xn=this.x;
        this.yn=this.y;
        this.dmg=gun.dmg;
        this.rad=gun.rad;
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(this.x,this.y,30,paint);
    };
    public void move(){
        this.x+=this.speed*this.cos;
        this.y+=this.speed*this.sin;
    };
    public boolean isInField(){
        return this.rad*this.rad>=(this.x-this.xn)*(this.x-this.xn)+(this.y-this.yn)*(this.y-this.yn);
    }
}
