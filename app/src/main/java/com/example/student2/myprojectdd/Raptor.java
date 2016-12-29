package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class Raptor extends Dino {
    //public int hp,timeNach;
    //public float speed,x,y,rAttack,rEating,xNach;
    //public Sost sost;
    private Paint paint=new Paint(0xff0000ff);

    public void walk(Human human,int timeNach,int time){
        if(human.y==this.y){
            if(human.x<this.x)this.x+=-this.speed;
            else this.x+=this.speed;
        }
    };
    public void attack(Human human){
        //NB
        this.x=human.x;
        this.y=human.y;
        //NB
    };
    public void eat(Human human,int timeNach,int time){};
    @Override
    public void draw(Canvas canvas){
        switch (sost){
            case ATTACKING:{
                this.paint.setColor(0xffff0000);
                canvas.drawCircle(this.x,this.y,10,this.paint);
                break;
            }
            case LIVING:{
                this.paint.setColor(0xff0000ff);
                canvas.drawCircle(this.x,this.y,10,this.paint);
                break;
            }
            case EATING:{
                this.paint.setColor(0xffffff00);
                canvas.drawCircle(this.x,this.y,10,this.paint);
                break;
            }
            case DEAD:{
                this.paint.setColor(0xf00000ff);
            }
        }
    }
    public void decide(LinkedList<Human>humen,Dino dino,int time,int timeNach){instinct.decide(humen,dino,time,timeNach);}
    Raptor(int hp,float speed,float x,float y){
        this.hp=hp;
        this.speed=speed;
        this.x=x;
        this.y=y;
        this.rAttack=360;
        this.rEating=1;
        this.sost=Sost.LIVING;
    }

    @Override
    public String toString() {
        return "Raptor{" +
                "hp=" + hp +
                ", timeNach=" + timeNach +
                ", speed=" + speed +
                ", x=" + x +
                ", y=" + y +
                ", rAttack=" + rAttack +
                ", rEating=" + rEating +
                ", xNach=" + xNach +
                ", sost=" + sost +
                ", paint=" + paint +
                '}';
    }
}
