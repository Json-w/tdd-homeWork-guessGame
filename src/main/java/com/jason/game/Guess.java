package com.jason.game;

/**
 * Created by jason on 15-11-22.
 * 这个类是用来整合测试 产生随机数的类(RandomCompare)和比较两个数字的类(NumberCompare)
 *
 */
public class Guess {
    private NumberCompare numberCompare;
    private RandomNumber randomNumber;

    public Guess(NumberCompare numberCompare, RandomNumber randomNumber) {
        this.numberCompare = numberCompare;
        this.randomNumber = randomNumber;
    }

    public String guessNum(String inputNum) {

        return numberCompare.compare(randomNumber.random4Num(), inputNum);
    }



}
