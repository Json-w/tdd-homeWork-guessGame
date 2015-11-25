package com.jason.game;

/**
 * Created by jason on 15-11-21.
 * 数字比较类
 */
public class NumberCompare {
    public String compare(String randomNum, String inputNum) {
        int ACount = 0;
        int BCount = 0;

        if (randomNum.equals(inputNum)) {
            return "4A0B";
        }

        String[] randomStrArr = randomNum.split("");
        String[] inputStrArr = inputNum.split("");

        for (int i = 0; i < randomStrArr.length; i++) {
            if (inputNum.contains(randomStrArr[i])) {
                for (int j = 0; j < inputStrArr.length; j++) {
                    if (i == j && randomStrArr[i].equals(inputStrArr[j])) {
                        ACount++;
                    } else if (randomStrArr[i].equals(inputStrArr[j])) {
                        BCount++;
                    }
                }
            }
        }


        return ACount + "A" + BCount + "B";
    }
}
