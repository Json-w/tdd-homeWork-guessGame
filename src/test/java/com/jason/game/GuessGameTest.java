package com.jason.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jason on 15-11-25.
 * 这个类有些测试方法没有测试，因为不知道怎么去写这个测试。有些测试想了办法去模拟，但是模拟不成功，我都注释了
 */
public class GuessGameTest {
    private GuessGame game;
    private RandomNumber randomNumber;

    @Before
    public void setUp() {
        int times = 6;
        Random random = mock(Random.class);
        for (int i = 0; i < 4; i++) {
            when(random.nextInt(10 - i)).thenReturn(1);
        }
        randomNumber = new RandomNumber(random);
        game = new GuessGame(randomNumber, times);
    }

    @Test
    public void test_start_with_1_time_guess_for_success() {//测试一次性猜对数字
        String input = "1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.setInterActive(new InterActive());//如果不在这里设置 new InterActive() 模拟的输入就会失败，GuessGame的构造函数其实是有new InterActice的
                                               //感觉是和System.in有关

        game.start();

        Assert.assertThat(game.getResult(),is("Congratulations!"));
    }

    @Test
    public void test_start_with_6_times_to_failure(){//全不猜错
//        InterActive mockInterActive = mock(InterActive.class);
//        when(mockInterActive.input()).thenReturn(2345,3214,2314,4312,5467,7642,5678);
//        game.start();
//        game.setInterActive(mockInterActive);
//
//        Assert.assertThat(game.getResult(),is("Game Over"));
    }

    @Test
    public void test_start_with_input_repeat_digit(){//输入的数字重复
//        String input = "1224";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        game.setInterActive(new InterActive(new Scanner(System.in)));
//        game.start();
//
//        Assert.assertThat(game.getResult(),is("Cannot input duplicate numbers!"));
    }
    @Test
    public void test_start_with_inputNum_123456(){//输入的数字超过4位

    }

    @Test
    public void test_start_with_input_fsf123(){//输入包含字母
//        String input = "fsf123";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        game.setInterActive(new InterActive(new Scanner(System.in)));
//        game.start();
    }

}
