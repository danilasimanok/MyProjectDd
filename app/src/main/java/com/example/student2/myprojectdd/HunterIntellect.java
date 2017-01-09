package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by Андрей on 29.12.2016.
 */

public class HunterIntellect extends Intellect {
    @Override
    public void playerDecide(float x, float y, LinkedList<Shot> newShots, Player player) {}

    @Override
    public void decide(LinkedList<Dino> dinos, Car car, Human thisHuman,LinkedList<Shot>newShots) {
        thisHuman.inCar=thisHuman.x>car.x1&&thisHuman.x<car.x2;
        Dino dinoCel=new Raptor(0,0,0,0);
        float minr=Float.MAX_VALUE;
        for(Dino dino:dinos){
            if(dino.sost!=Sost.DEAD){
                dinoCel=dino;
                break;
            }
        }
        //решаем, что делать
        if(thisHuman.sost!=Sost.EATING){
            if(dinos.isEmpty())thisHuman.sost=Sost.LIVING;
            else thisHuman.sost=Sost.ATTACKING;
            for (Dino dino:dinos){
            if(dino.sost==Sost.DEAD)continue;
            float r=(thisHuman.x-dino.x)*(thisHuman.x-dino.x)+(thisHuman.y-dino.y)*(thisHuman.y-dino.y);
            if(r<minr){
                dinoCel=dino;
                minr=r;
            }
            }
        }
        if(thisHuman.hp<=0)thisHuman.sost=Sost.DEAD;
        //действуем
        switch (thisHuman.sost){
            case LIVING:{
                if(!thisHuman.inCar)thisHuman.move(car);
                if(thisHuman.gun.gotov!=thisHuman.gun.reload)thisHuman.shut(dinoCel,newShots);
                break;
            }
            case ATTACKING:{
                thisHuman.shut(dinoCel,newShots);
                if(!thisHuman.inCar)thisHuman.move(car);
                break;
            }
        }
    }
}
