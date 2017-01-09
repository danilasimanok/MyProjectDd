package com.example.student2.myprojectdd;

import android.graphics.Canvas;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public abstract class Dino {
    int hp;
    float x,y,speed,rAttack,rEating,xNach;
    Instinct instinct=new Instinct();
    Sost sost;
    abstract void walk(Human human);
    abstract void attack(Human human);
    abstract void eat(Human human);
    abstract void draw(Canvas canvas);
    public void decide(LinkedList<Human>humen,Dino dino){instinct.decide(humen,dino);}
}
