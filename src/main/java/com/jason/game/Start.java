package com.jason.game;

/**
 * Created by jason on 15-11-25.
 * 启动游戏类
 */
public class Start {
    public static void main(String[] args){
        new GuessGame(new RandomNumber(),6).start();
    }
}
