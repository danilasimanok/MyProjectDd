package com.example.student2.myprojectdd;

import java.util.LinkedList;

/**
 * Created by Андрей on 29.12.2016.
 */

public class Player extends Human {
    public Player(float x, float y, Gun gun) {
        super(x, y, new PlayerIntellect(), gun);
    }

    public void playerDecide(float x, float y, LinkedList<Shot> newShots, Player player) {
        this.intellect.playerDecide(x,y,newShots,player);
    }

    public void shut(float xtuk,float ytuk,Gun gun,LinkedList<Shot>newShots){gun.shut(xtuk, ytuk, newShots);}
}
