package com.jason.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;

/**
 * Created by jason on 15-11-24.
 * 交互类的测试
 * 这个测试类比实现类花了太多时间。  而且模拟的这些方法觉得并不好，这个类是不是需要这种测试？
 * 像这种交互类，是不是直接在main函数里面跑起来手工测试更合适。
 */
public class InterActiveTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private InterActive interActive;

    @Test
    public void test_inputNum_should_return_1234_when_input_1234(){
        String input = "1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));//模拟输入
        interActive = new InterActive();

        String result = interActive.input();

        Assert.assertThat(result,is("1234"));
    }

    @Test
    public void test_output_should_return_Welcomeln_when_parameter_is_Welcome(){
        System.setOut(new PrintStream(outContent));//模拟输出
        interActive = new InterActive();

        interActive.output("Welcome");

        Assert.assertThat(outContent.toString(),is("Welcome"));
    }

}
