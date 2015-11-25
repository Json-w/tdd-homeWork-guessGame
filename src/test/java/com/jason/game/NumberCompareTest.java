package com.jason.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by jason on 15-11-21.
 * 数字比较测试类
 */
public class NumberCompareTest {
    private NumberCompare numberCompare;
    @Before
    public void setUp(){
        numberCompare = new NumberCompare();
    }

    @Test
    public void should_return_0A4B_when_1234_compare_2341() {
        String randomNum = "1234";
        String inputNum = "2341";

        String result = numberCompare.compare(randomNum, inputNum);

        Assert.assertThat(result, is("0A4B"));
    }

    @Test
    public void should_return_4A0B_when_1234_compare_1234() {
        String randomNum = "1234";
        String inputNum = "1234";

        String result = numberCompare.compare(randomNum, inputNum);

        Assert.assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_4A0B_when_2345_compare_2345(){
        String randomNum = "2345";
        String inputNum = "2345";

        String result = numberCompare.compare(randomNum,inputNum);

        Assert.assertThat(result,is("4A0B"));
    }

    @Test
    public void should_return_0A0B_when_1234_compare_5678(){
        String randomNum = "1234";
        String inputNum = "5678";

        String result = numberCompare.compare(randomNum,inputNum);

        Assert.assertThat(result,is("0A0B"));
    }

    @Test
    public void should_return_2A2B_when_2345_compare_2354(){
        String randomNum = "2345";
        String inputNum = "2354";

        String result = numberCompare.compare(randomNum,inputNum);

        Assert.assertThat(result,is("2A2B"));
    }
}
