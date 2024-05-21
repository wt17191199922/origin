package com.wangtian.service;


/**
 * @author wang1
 */
public class PersonAtm extends Thread{
    /**
     * 每次取出的钱
    */
     public final static int MONEY=100;

     MoneyService moneyService;

     public PersonAtm(MoneyService moneyService){
         this.moneyService=moneyService;
     }

     @Override
    public void run(){
         while (MoneyService.money>=MONEY){
//             moneyService.ATM(MONEY);
             MoneyService.money -= MONEY;
             System.out.println("ATM机取走了" + MONEY + "钱,余额还剩" + MoneyService.money + "钱");
             try {
                 sleep(1000);
             } catch (InterruptedException e) {
                 System.out.println("ATM机取钱出错");
                 throw new RuntimeException(e);
             }
         }
     }

}
