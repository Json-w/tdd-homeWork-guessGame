package com.jason.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by jason on 15-11-21.
 * 随机数字生成类
 */
public class RandomNumber {
    private Random random;

    public RandomNumber(Random random) {
        this.random = random;
    }

    public RandomNumber() {
        random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String random4Num() {
        String result = "";
        List<Integer> list = new LinkedList<Integer>();
        int[] digts = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : digts) {
            list.add(i);
        }

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(list.size());
            result += list.get(randomIndex);
            list.remove(randomIndex);
        }
        return result;
    }
}
