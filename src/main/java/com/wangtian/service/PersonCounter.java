package com.wangtian.service;


/**
 * @author wang1 柜台取钱调用方法类
 */
public class PersonCounter extends Thread {
    public final static int MONEY=200;

    MoneyService moneyService;

    /**
     * 构造器引入证明进入的是同一家银行
     */
    public PersonCounter(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    /**
     * 重写run方法进行开启线程进行取钱
     */
    @Override
    public void run() {
        while (MoneyService.money>=MONEY){
            //每次取200块
//            moneyService.Counter(MONEY);
            MoneyService.money -= MONEY;
            System.out.println("柜台取走了" + MONEY + "钱,余额还剩" + MoneyService.money + "钱");
            //取完之后线程休息1秒
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("柜台取钱出错");
                throw new RuntimeException(e);
            }
        }
    }

}
