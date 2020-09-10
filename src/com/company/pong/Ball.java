package com.company.pong;

import java.awt.*;

public class Ball {

    public static final int SIZE = 16;

    private int x;
    private int y;

    private int xVelocity;
    private int yVelocity;
    private int speed = 5;


    public Ball() {
        reset();
    }

    private void reset() {
        x = Game.WIDTH/2 - SIZE/2;
        y = Game.HEIGHT/2 - SIZE/2;

        //initialize velocity
        xVelocity = Game.sign(Math.random() * 2.0 -1);
        yVelocity = Game.sign(Math.random() * 2.0 -1);



    }

    public void changeYDirection(){
        yVelocity *= -1;
    }

    public void changeXDirection(){
        xVelocity += -1;
    }


    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,y, SIZE, SIZE);
    }

    public void update(Paddle paddle1, Paddle paddle2) {
        x += xVelocity * speed;
        y += yVelocity * speed;

        //collisions
        if(y + SIZE  >= Game.HEIGHT || y <= 0) changeYDirection();

        if(x + SIZE >= Game.WIDTH){
            paddle1.addPoint();
            reset();
        }

        if(x <= 0){
            paddle2.addPoint();
            reset();
        }

    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
