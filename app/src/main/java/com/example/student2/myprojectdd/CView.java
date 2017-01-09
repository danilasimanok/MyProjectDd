package com.example.student2.myprojectdd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

/**
 * Created by student2 on 28.12.16.
 */
public class CView extends View {
    Paint paint = new Paint();
    float x=0,y=0,xk=0,yk=0;
    int w;
    int h;
    LinkedList<Shot> shots=new LinkedList<Shot>();
    LinkedList<Shot> newShots=new LinkedList<Shot>();
    LinkedList<Shot> delShots=new LinkedList<Shot>();
    LinkedList<Dino> dinos=new LinkedList<Dino>();
    LinkedList<Human> humen=new LinkedList<Human>();
    Car car;
    boolean f=true;
    Player player;

    public CView(Context context){
        super(context);
    }

    protected void onDraw(Canvas canvas){
        paint.setColor(0xff0000ff);
        w=getWidth();
        h=getHeight();
        //рисуем поле стрельбы
        canvas.drawCircle(w/2,h,w/6,paint);
        player=new Player(w/2,h,new Rifle(w/2,h,true));
        //работаем со снарядами
        for(Shot shot:newShots){
            shots.add(shot);
        }
        newShots.clear();
        for(Shot shot:shots){
            shot.move();
            shot.draw(canvas);
            if(!shot.isInField())delShots.add(shot);
        }
        for(Shot shot:delShots){
            shots.remove(shot);
        }
        delShots.clear();
        //персонажи решают
        for(Dino dino:dinos)dino.decide(humen,dino,1,1);
        for(Human human:humen)if(human.getClass()!=Player.class)human.decide(dinos,car,newShots);
        //рисуем персонажей
        for(Human human:humen)human.draw(canvas);
        for(Dino dino:dinos)dino.draw(canvas);
        if(car!=null)car.draw(canvas);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event){
        if(f){
            dinos.add(new Raptor(2,1,w/2,h/2));
            humen.add(new HMishen(w/5,h/2));
        }
        else{
            dinos.clear();
            humen.clear();
            dinos.add(new Raptor(2,1,w/2,h/3));
            humen.add(new HMishen(w/5,h/2));
        }
        return super.onTouchEvent(event);
    }
}
