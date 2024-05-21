package com.wangtian.service;

/**
 * @author wang1 银行类取钱的atm机和柜台方法
 */
public class MoneyService {

    /**
     * 银行卡剩余金额 这里使用静态的修饰可以直接用类名进行调用
     */
    public static int money = 1000;

    /**
     * 柜台取钱方法
     */
    public void Counter(int money) {
        //先将全局money-去传过来要取的钱再将剩余的钱赋值给银行卡静态money
        MoneyService.money -= money;
        System.out.println("柜台取走了" + money + "钱,余额还剩" + MoneyService.money + "钱");

    }

    public void ATM(int money) {
        MoneyService.money -= money;
        System.out.println("ATM机取走了" + money + "钱,余额还剩" + MoneyService.money + "钱");
    }

}
