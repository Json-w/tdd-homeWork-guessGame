package com.jason.game;

import java.util.Scanner;

/**
 * Created by jason on 15-11-24.
 * 交互类  主要是负责输入与输出。
 * 写这个类的测试比写这个类本身花的时间多。 详细见InterActiveTest类
 */
public class InterActive {
    private Scanner scanner;

    public InterActive() {
        scanner = new Scanner(System.in);
    }

    public InterActive(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input() {
        return scanner.nextLine();
    }

    public void output(String content) {
        System.out.print(content);
    }

    public void outputln(String content){
        System.out.println(content);
    }
}
