package com.example.student2.myprojectdd;

import android.util.Log;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class Instinct {
    public void decide(LinkedList<Human>humen,Dino dino,Integer time,Integer timeNach){
        //инструменты
        float r=Float.MAX_VALUE;
        Human humanCel=new Human(0,0) {
            @Override
            void sit() {

            }

            @Override
            void decide() {

            }
        };
        for(Human human:humen){
            if(human.sost!=Sost.DEAD){
                humanCel=human;
                break;
            }
        }
        //решаем,что делать
        for(Human human:humen){
            float r1=(human.x-dino.x)*(human.x-dino.x)+(human.y-dino.y)*(human.y-dino.y);
            if(r1<=dino.rEating*dino.rEating){
                if(dino.sost!=Sost.EATING)dino.timeNach=time;
                dino.sost=Sost.EATING;
                humanCel=human;
                break;
            }
            else if(r1<=dino.rAttack*dino.rAttack&&human.sost!=Sost.EATING&&human.sost!=Sost.DEAD){
                dino.sost=Sost.ATTACKING;
                humanCel=human;
                dino.xNach=dino.x;
                break;
            }
            else if(r>r1&&human.sost!=Sost.EATING&&human.sost!=Sost.DEAD){
                humanCel=human;
                r=r1;
            }
        }
        Log.d("simanok", "" +dino.sost);
        //действуем
        if(dino.sost==Sost.LIVING){
            Log.d("simanok", "in if" +dino);
            dino.walk(humanCel,timeNach,time);
        }
        else if(dino.sost==Sost.ATTACKING){
            dino.attack(humanCel);
        }
        else if(dino.sost==Sost.EATING){
            dino.eat(humanCel,timeNach,time);
        }
    };
}
