package com.jason.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

/**
 * Created by jason on 15-11-21.
 * 产生随机数类的测试
 */
public class RandomNumberTest {

    private RandomNumber randomNumber;
    @Before
    public void setUp(){
        randomNumber = new RandomNumber();
    }

    @Test
    public void should_return_Num() {
        String result = randomNumber.random4Num();

        try{
            Integer.parseInt(result);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void test_num_length_is_4(){
        int result = randomNumber.random4Num().length();

        Assert.assertThat(result,is(4));
    }

    @Test
    public void test_digit_in_num_not_repeat(){
        String result = randomNumber.random4Num();
        Set<String> resultSplit = new HashSet<String>();

        String[] strArr = result.split("");
        for(String str:strArr){
            resultSplit.add(str);
        }
        Assert.assertThat(resultSplit.size(),is(4));
    }
    @Test
    public void test_randomNum_not_repeat_at_5times() {
        Set<String> results = new HashSet<String>();

        for (int i = 0; i < 5; i++) {
            String result = randomNumber.random4Num();
            results.add(result);
        }

        Assert.assertThat(results.size(),is(5));
    }
}
