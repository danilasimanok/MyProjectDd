package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by Андрей on 29.12.2016.
 */
public class PlayerIntellect extends Intellect {
    @Override
    public void decide(LinkedList<Dino> dinos, Car car, Human thisHuman, LinkedList<Shot> newShots) {}
    public void playerDecide(float xtuk,float ytuk, LinkedList<Shot>newShots,Player player){
        //решаем, что делать
        if(player.hp==0)player.sost=Sost.DEAD;
        if(player.sost!=Sost.EATING&&player.sost!=Sost.DEAD){
            player.sost=Sost.ATTACKING;
        }
        //действуем
        if(player.sost==Sost.ATTACKING)player.shut(xtuk,ytuk,player.gun,newShots);
    }
}

