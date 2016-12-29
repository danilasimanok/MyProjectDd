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

    public CView(Context context){
        super(context);
    }

    protected void onDraw(Canvas canvas){
        paint.setColor(0xff0000ff);
        w=getWidth();
        h=getHeight();
        //рисуем поле стрельбы
        canvas.drawCircle(w/2,h,w/6,paint);
        //работаем со снарядами
        for(Shot shot:newShots){
            shots.add(shot);
        }
        newShots.clear();
        for(Shot shot:shots){
            shot.move();
            shot.draw(canvas);
            if(shot.y<=-10||shot.x<=-10||shot.x>=w+10)delShots.add(shot);
        }
        for(Shot shot:delShots){
            shots.remove(shot);
        }
        delShots.clear();
        //персонажи решают
        for(Dino dino:dinos)dino.decide(humen,dino,1,1);
        for(Human human:humen)human.decide(dinos,new Car());
        //рисуем персонажей
        for(Human human:humen)human.draw(canvas);
        for(Dino dino:dinos)dino.draw(canvas);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event){
        x=event.getX();
        y=event.getY();
        if((x-w/2)*(x-w/2)+(y-h)*(y-h)<=w*w/36.0){
            newShots.add(new Shot(w/2,h,x,y,1,1,Math.max(w,h)));
        }
        return super.onTouchEvent(event);
    }
}
