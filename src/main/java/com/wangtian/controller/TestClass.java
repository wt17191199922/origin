package com.wangtian.controller;

import com.wangtian.entity.Station;
import com.wangtian.service.MoneyService;
import com.wangtian.service.PersonAtm;
import com.wangtian.service.PersonCounter;

import java.math.BigDecimal;
import java.text.DateFormat;

/**
 * @author wang1 多线程卖票测试类
 */
public class TestClass {

        /**
         * java多线程同步锁的使用
         * 示例：三个售票窗口同时出售10张票
         * */
//        public static void main(String[] args) {
//            //实例化站台对象，并为每一个站台取名字
//            Station station1=new Station("窗口1");
//            Station station2=new Station("窗口2");
//            Station station3=new Station("窗口3");
//
//            // 让每一个站台对象各自开始工作
//            station1.start();
//            station2.start();
//            station3.start();
//
//        }

        /**
         * java多线程取钱atm机和柜台同时取钱
         * */
    public static void main(String[] args) {
        /**
         * 实例化一个银行对象使两个人去的是同一家银行使用人中的构造方法传入
//         * */
//        MoneyService moneyService = new MoneyService();
//        PersonCounter personCounter = new PersonCounter(moneyService);
//        PersonAtm personAtm = new PersonAtm(moneyService);
//        personAtm.start();
//        personCounter.start();

        BigDecimal bigDecimal = new BigDecimal(1000);

        System.out.println(bigDecimal);


    }




}
