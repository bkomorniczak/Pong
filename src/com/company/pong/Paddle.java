package com.company.pong;

import java.awt.*;

public class Paddle {

    private int x;
    private int y;

    private int velocity;
    private int speed = 10;
    private int width =22;
    private int height = 85;
    private int score =0;
    private Color color;
    private boolean left;

    public Paddle(Color c, boolean left) {
        color = c;
        this.left = left;
        if(left) x=0;
        else x = Game.WIDTH - width;
        y = Game.HEIGHT/2 - height/2;
    }

    public void addPoint(){
        score++;
    }

    public void draw(Graphics g) {
        //draw paddle
        g.setColor(color);
        g.fillRect(x,y,width,height);

        //draw score
        int sx;
        String scoreText = Integer.toString(score);
        Font font = new Font("Roboto", Font.PLAIN, 50);

        int strWidth = g.getFontMetrics(font).stringWidth(scoreText) + 1;
        int padding = 25;

        if(left) sx = Game.WIDTH/2 - padding - strWidth;
        else sx = Game.WIDTH/2 + padding;

        g.setFont(font);
        g.drawString(scoreText, sx, 50);



    }

    public void update(Ball ball) {
        y = Game.ensureRange(y += velocity, 0, Game.HEIGHT - height);

        int xBall = ball.getX();
        int yBall = ball.getY();

        //collisions with ball

        if(left){
            if(xBall <= width  && yBall + Ball.SIZE >= y && yBall <=  y + height) ball.changeXDirection();
        }else{
            if(xBall + Ball.SIZE >= Game.WIDTH - width && yBall + Ball.SIZE >= y && yBall <= y + height) ball.changeXDirection();

        }
    }

    public void switchDirection(int direction) {
        velocity = speed * direction;

    }
    public void stop(){
        velocity = 0;
    }
}
