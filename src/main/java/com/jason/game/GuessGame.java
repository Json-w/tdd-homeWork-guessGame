package com.jason.game;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jason on 15-11-25.
 * 游戏类 整合的作用  整合各个模块,实现功能 (对这个类测试的时候遇到很多问题，无法实现测试，详细见GuessGameTest)
 */
public class GuessGame {
    private String result;
    private String randomAnswer;
    private int times;
    private RandomNumber randomNumber;
    private NumberCompare numberCompare;
    private InterActive interActive;

    public GuessGame(RandomNumber randomNumber, int times) {
        this.randomNumber = randomNumber;
        this.times = times;
        numberCompare = new NumberCompare();
        interActive = new InterActive();
        randomAnswer = randomNumber.random4Num();

    }

    public void start() {
        interActive.outputln("Welcome");

        for(int i =0;i<times;i++) {
            interActive.output("Please input your number("+(times-i)+"):");
            String inputNum = interActive.input();
            try {
                Integer.parseInt(inputNum);  //这里处理感觉不恰当 把逻辑处理放到异常中了
            }catch (NumberFormatException e){
                interActive.outputln("please input legal number:");
                continue;
            }
            if(inputNum.length()!=4){
                interActive.outputln("the length of input number is not equal 4");
                continue;
            }

            if(checkInputNUmIsRepeat(inputNum)){
                interActive.outputln("Cannot input duplicate numbers!");
                continue;
            }

            String compareResult = numberCompare.compare(randomAnswer, inputNum);
            if (compareResult.equals("4A0B")) {
                result = "Congratulations!";
                interActive.outputln(result);
                return;
            } else {
                interActive.outputln(compareResult);
            }
        }
        result = "Game Over";
        interActive.outputln(result);
        interActive.output("rightAnswer:"+randomAnswer);
    }

    private boolean checkInputNUmIsRepeat(String number){
        boolean flag = true;
        Set<String> resultSplit = new HashSet<String>();

        String[] strArr = number.split("");
        for(String str:strArr){
            resultSplit.add(str);
        }
        if(resultSplit.size()==4){
            flag = false;
        }
        return  flag;
    }


    public String getResult() {
        return result;
    }

    public void setInterActive(InterActive interActive) {
        this.interActive = interActive;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
