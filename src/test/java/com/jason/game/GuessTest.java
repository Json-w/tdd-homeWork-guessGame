package com.jason.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jason on 15-11-21.
 * 整合类测试
 * 个人认为实现代码为了测试代码做了妥协
 * 比如Random类，实际上可以封装在RandomNumber类内部，不暴露出来，但是为了mock测试，就必须暴露出来。
 */
public class GuessTest {
    Guess guess;
    RandomNumber randomNumber;

    @Before
    public void setUp() {
        randomNumber = new RandomNumber();
        guess = new Guess(new NumberCompare(), randomNumber);
    }

    @Test
    public void test_guess_return_4A0B_with_inputNum_1234() {
        String inputNum = "1234";
        Random random = mock(Random.class);
        randomNumber.setRandom(random);

        for (int i = 0; i < 4; i++) {
            when(random.nextInt(10-i)).thenReturn(1);
        }

        Assert.assertThat(guess.guessNum(inputNum), is("4A0B"));
    }
}
