package com.example.student2.myprojectdd;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class Raptor extends Dino {
    //public int hp;
    //public float speed,x,y,rAttack,rEating,xNach;
    //public Sost sost;
    private Paint paint=new Paint(0xff0000ff);
    private float xCel=-1,yCel=-1;
    private float a,b,c;
    public float hAttack;
    private int znak=0;

    public void walk(Human human){
        this.hAttack=this.y-360;
        if(human.y==this.y){
            if(human.x<this.x)this.x+=-this.speed;
            else this.x+=this.speed;
        }
    };
    public void attack(Human human){
        // ???
        this.hAttack=this.y-360;
        if(this.xCel<0){
            //определяем параболу
            this.xCel=human.x;
            this.yCel=human.y;
            float t1,t2,t3,xAttack=(this.x+human.x)/2;
            t1=(this.y-this.hAttack)*(xAttack*xAttack-xCel*xCel)/(this.x*this.x-xAttack*xAttack);
            t2=xAttack-xCel+(xCel*xCel-xAttack*xAttack)/(this.x+xAttack);
            t3=this.hAttack-human.y;
            this.b=(t3-t1)/t2;
            this.a=((this.y-this.hAttack)-b*(this.x-xAttack))/(this.x*this.x-xAttack*xAttack);
            this.c=this.y-b*this.x-a*this.x*this.x;
            //движемся
            if(human.x<this.x){
                this.x+=-this.speed;
                this.znak=-1;
            }
            else {
                this.x+=this.speed;
                this.znak=1;
            }
        }
        else {
            this.x+=this.znak*this.speed;
            this.y=this.a*this.x*this.x+this.b*this.x+this.c;
            if(this.y<this.yCel){
                this.y=this.yCel;
                this.xCel=-1;
                this.yCel=-1;
            }
        }
    };
    public void eat(Human human){human.sost=Sost.EATING;}
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
    public void decide(LinkedList<Human>humen,Dino dino){instinct.decide(humen,dino);}
    Raptor(int hp,float speed,float x,float y){
        this.hp=hp;
        this.speed=speed;
        this.x=x;
        this.y=y;
        this.rAttack=360;
        this.rEating=2;
        this.sost=Sost.LIVING;
    }

    @Override
    public String toString() {
        return "Raptor{" +
                "hp=" + hp +
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
