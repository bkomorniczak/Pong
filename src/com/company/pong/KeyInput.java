package com.company.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private  Paddle paddle1;
    private Paddle paddle2;
    private boolean up1 = false;
    private  boolean down1 = false;
    private boolean up2 = false;
    private boolean down2 = false;
    public KeyInput(Paddle p1, Paddle p2) {
        paddle1 = p1;
        paddle2 = p2;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            paddle2.switchDirection(-1);
            up2 = true;

        }
        if(key == KeyEvent.VK_DOWN){
            paddle2.switchDirection(1);
            down2 = true;

        }
        if(key == KeyEvent.VK_W){
            paddle1.switchDirection(-1);
            up1 = true;

        }
        if(key == KeyEvent.VK_S){
            paddle1.switchDirection(1);
            down1 = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            paddle2.switchDirection(-1);
            up2 = false;

        }
        if(key == KeyEvent.VK_DOWN){
            paddle2.switchDirection(1);
            down2 = false;

        }
        if(key == KeyEvent.VK_W){
            paddle1.switchDirection(-1);
            up1 = false;

        }
        if(key == KeyEvent.VK_S){
            paddle1.switchDirection(1);
            down1 = false;

        }

        if(!up1&&!down2){
            paddle1.stop();
        }
        if(!up2 && !down2){
            paddle2.stop();
        }
    }
}
