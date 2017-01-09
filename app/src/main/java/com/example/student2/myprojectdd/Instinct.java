package com.example.student2.myprojectdd;

import android.util.Log;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class Instinct {
    public void decide(LinkedList<Human>humen,Dino dino){
        //инструменты
        float r=Float.MAX_VALUE;
        Human humanCel=new Human(0,0,new PlayerIntellect(),new Rifle(0,0,true));
        for(Human human:humen){
            if(human.sost!=Sost.DEAD){
                humanCel=human;
                break;
            }
        }
        //решаем,что делать
        for(Human human:humen){
            if(human.sost==Sost.DEAD)continue;
            float r1=(human.x-dino.x)*(human.x-dino.x)+(human.y-dino.y)*(human.y-dino.y);
            if(r1<=dino.rEating*dino.rEating){
                dino.sost=Sost.EATING;
                humanCel=human;
                break;
            }
            else if(r1<=dino.rAttack*dino.rAttack&&human.sost!=Sost.EATING){
                dino.sost=Sost.ATTACKING;
                humanCel=human;
                dino.xNach=dino.x;
                break;
            }
            else if(r>r1&&human.sost!=Sost.EATING){
                humanCel=human;
                r=r1;
            }
        }
        if(dino.hp<=0)dino.sost=Sost.DEAD;
        //действуем
        if(dino.sost==Sost.LIVING){
            dino.walk(humanCel);
        }
        else if(dino.sost==Sost.ATTACKING){
            dino.attack(humanCel);
        }
        else if(dino.sost==Sost.EATING){
            dino.eat(humanCel);
        }
    };
}
