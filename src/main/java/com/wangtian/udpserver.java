package com.wangtian;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class udpserver {

//    public static void main(String[] args) throws Exception {
//        String a="2022-12-23 11:11:11";
////        String b ="2022-12-20";
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        System.out.println(sdf.parse(a));
////        System.out.println(sdf.format(b));
//
//        SimpleDateFormat sdfTeeTime = new SimpleDateFormat("yyyy-MM-dd");
////        SimpleDateFormat sdfArrivalTime = new SimpleDateFormat("HH:mm");
//        System.out.println("aaaaaaaaaaaaaaa"+sdfTeeTime.format(a));
////        System.out.println(sdfArrivalTime.format(a));
//
//    }

//    public static void main(String[] args) {
//       String a="NB_DK";
//        String[] split = a.split(",");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }
//
//
//    }


    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public static Date getLastPeroid(int type, Date date){
        Calendar c = Calendar.getInstance();
        if (1 == type){
            //未来20年
            c.setTime(date);
            c.add(Calendar.YEAR, 20);
            return  c.getTime();
        }else if (2 == type){
            //过去20年
            c.setTime(date);
            c.add(Calendar.YEAR, -20);
            return c.getTime();
        }
        return null;

    }


    public static void main(String[] args) {
//        "http://10.172.30.181:8200/facility/api/facility/FineBI/getSingleTimeData?pointIds=[WinCC_OA.XBC00F013C07PT0105.In.values.value,WinCC_OA.XBC00F013C07PT0106.In.values.value]&time=2021-01-01 05:45:03"
//        "http://10.172.30.181:8200/facility/api/facility/FineBI/getMultiTimeData?pointId=WinCC_OA.XBC00F013C07PT0105.In.values.value&start=2021-12-31 10:43:00&end=2022-01-01 10:45:00"
//        "http://10.172.30.181:8200/facility/api/facility/FineBI/getSingleTimeData?pointIds=WinCC_OA.XBC00F013C07PT0105.In.values.value&time=2021-01-01 05:45:03"
//        "http://10.21.140.2:51664/facility/api/facility/FineBI/getMultiTimeData?pointId=WinCC_OA.XBC00F013C07PT0105.In.values.value&start=2021-12-31 10:43:00&end=2022-01-01 10:45:00"
//        "http://10.21.140.2:49170/facility/api/facility/FineBI/getMultiTimeData?pointId=WinCC_OA.XBC00F013C07PT0105.In.values.value&start=2021-12-31 10:43:00&end=2022-01-01 10:45:00"

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sss = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//
//        Date date = new Date();
//            try {
//                date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse("2023-06-27T11:05:00+08:00");
//
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                System.out.println(format.format(date));
//
//            } catch (ParseException e) {
//                //LOGGER.error("时间转换错误, string = {}", s, e);
//            }
////        System.out.println(date);
//
//        String S1 = "1234";
//        String S2 = "你好";
//        System.out.println(isNumber(S1));
//        System.out.println("-----------");
//        System.out.println(isNumber(S2));
//        SimpleDateFormat edmStartime = new SimpleDateFormat("yyyy-MM-dd 07:55:00");
//        SimpleDateFormat edmEndtime = new SimpleDateFormat("yyyy-MM-dd 08:10:00");
////        String format = edmStartime.format(new Date());
//        String format2 = edmEndtime.format(new Date());
////        long time1 = 0;
////        try {
////            time1 = edmStartime.parse(format).getTime() / 1000;
////        } catch (ParseException e) {
////            throw new RuntimeException(e);
////        }
//        long time2 = 0;
//        try {
//            System.out.println(edmEndtime.parse(format2));
//            System.out.println(edmEndtime.parse(format2).getTime());
//            time2 = edmEndtime.parse(format2).getTime() / 1000;
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
////        System.out.println(format+"~~~~~~~~~~~~~~~~~~~~~"+time1);
//        System.out.println(format2+"~~~~~~~~~~~~~~~~~~~~~"+time2);
//        String startOfDay = getStartOfDay(new Date());
//        SimpleDateFormat edmStartime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date parse = edmStartime.parse(startOfDay);
//            System.out.println(parse.getTime());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(startOfDay);


//        int[] ints = {2, 34, 55, 22, 11};
//        long[] longs = {1, 2, 3};
//        double[] doubles = {1, 2, 3};
//        String[] asd={"fgx", "lzy","17784554076"};
//        Arrays.stream(ints).boxed().collect(Collectors.toList());
//        Arrays.stream(longs).boxed().collect(Collectors.toList());
//        Arrays.stream(doubles).boxed().collect(Collectors.toList());
//        List<String> collect = Arrays.stream(asd).collect(Collectors.toList());
//        for (int i = 0; i < collect.size(); i++) {
//            System.out.println(collect.get(i));
//        }

//        String s="heoowangia王甜";
//        boolean falg = s.contains("heoowangia王甜");
//        System.out.println(falg);
        List<String> pointIdsList = new ArrayList<>();
        List<String> pointIdsList2 = new ArrayList<>();
        pointIdsList2.add("int-yt1.realtime.db.analog.nihao.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.DWX00A001LIT1106.curval");
        pointIdsList2.add("int-yt1.realtime.db.analog.wangtian.curval");
        String pointIds = "";
        for (int i = 0; i < pointIdsList2.size(); i++) {
            String pointId = pointIdsList2.get(i);
            if (pointIds!=null&&pointIds!="") {
                pointIds = pointIds + "," + pointId;
            } else {
                pointIds = pointId;
            }
            if (i>=25&&i%25==0){
                pointIdsList.add(pointIds);
                pointIds="";
            }
        }
        pointIdsList.add(pointIds);
        for (int i = 0; i < pointIdsList.size(); i++) {
            System.out.println(pointIdsList.get(i));
        }

    }
    public static String getStartOfDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

        private static final Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]*");


        public static boolean isNumber(String str) {

            Matcher m = pattern.matcher(str);

            return m.matches();
        }




}

