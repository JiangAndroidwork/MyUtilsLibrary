package com.laojiang.utilslibrary.uitls;

import android.widget.TextView;

/**
 * 类介绍（必填）：根据时间获取当周的数据
 * Created by Jiang on 2017/3/23 10:09.
 */

public class WeekUtils {


    private String newMonthh;

    private void initWeek(long date, TextView tvMonth,TextView tvWeek1, TextView tvWeek2, TextView tvWeek3, TextView tvWeek4, TextView tvWeek5) {
        String month = DateUtil.getMonth(date);
        if (month.substring(0,1).equals("0")){
            newMonthh = month.substring(1);
            tvMonth.setText(newMonthh +"月");
        }else {
            newMonthh = month;
            tvMonth.setText(month + "月");
        }
        String year = DateUtil.getYear(date);
        String weekOne = DateUtil.getWeekForExam(date);
        String dayOne = DateUtil.getDay(date);
        if (dayOne.substring(0,1).equals("0")){
            dayOne = dayOne.substring(1);
        }
        int lastDay = DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh));
        switch (weekOne){
            case "星期一":
                tvWeek1.setText(dayOne);
                if (dayOne.equals(lastDay+"")){
                    tvWeek2.setText("1");
                    tvWeek3.setText("2");
                    tvWeek4.setText("3");
                    tvWeek5.setText("4");
                }else if (dayOne.equals(lastDay-1+"")){
                    tvWeek2.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek3.setText("1");
                    tvWeek4.setText("2");
                    tvWeek5.setText("3");
                }else if (dayOne.equals(lastDay-2+"")){
                    tvWeek2.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)+2+"");
                    tvWeek4.setText("1");
                    tvWeek5.setText("2");
                }else if (dayOne.equals(lastDay-3+"")){
                    tvWeek2.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)+2+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)+3+"");
                    tvWeek5.setText("1");
                }else{
                    tvWeek2.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)+2+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)+3+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)+4+"");
                }

                break;
            case "星期二":
                tvWeek2.setText(dayOne);
                if (dayOne.equals(lastDay+"")){
                    tvWeek1.setText(lastDay-1+"");
                    tvWeek3.setText("1");
                    tvWeek4.setText("2");
                    tvWeek5.setText("3");
                }else if (dayOne.equals(lastDay-1+"")){
                    tvWeek1.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek3.setText(lastDay+"");
                    tvWeek4.setText("1");
                    tvWeek5.setText("2");
                }else if (dayOne.equals(lastDay-2+"")){
                    tvWeek1.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek4.setText(lastDay+"");
                    tvWeek5.setText("1");
                }else if (dayOne.equals(lastDay-3+"")){
                    tvWeek1.setText(Integer.parseInt(dayOne)-4+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek5.setText(lastDay+"");
                }else if (dayOne.equals("1")){
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek3.setText("2");
                    tvWeek4.setText("3");
                    tvWeek5.setText("4");
                }else {
                    tvWeek1.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)+2+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)+3+"");
                }

                break;
            case "星期三":
                tvWeek3.setText(dayOne);
                if (dayOne.equals(lastDay+"")){
                    tvWeek1.setText(lastDay-2+"");
                    tvWeek2.setText(lastDay-1+"");
                    tvWeek4.setText("1");
                    tvWeek5.setText("2");
                }else if (dayOne.equals(lastDay-1+"")){
                    tvWeek2.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek1.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek4.setText(lastDay+"");
                    tvWeek5.setText("1");
                }else if (dayOne.equals("1")){
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek4.setText("2");
                    tvWeek5.setText("3");
                }else if (dayOne.equals("2")){
                    tvWeek2.setText("1");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek4.setText("3");
                    tvWeek5.setText("4");
                }else {
                    tvWeek2.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek1.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)+1+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)+2+"");
                }

                break;
            case "星期四":

                tvWeek4.setText(dayOne);
                if (dayOne.equals(lastDay+"")){
                    tvWeek1.setText(lastDay-3+"");
                    tvWeek2.setText(lastDay-2+"");
                    tvWeek3.setText(lastDay-1+"");
                    tvWeek5.setText("1");
                }else if (dayOne.equals("1")){
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek5.setText("2");
                }else if (dayOne.equals("2")){
                    tvWeek3.setText("1");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek5.setText("3");
                }else if (dayOne.equals("3")){
                    tvWeek3.setText("2");
                    tvWeek2.setText("1");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek5.setText("4");
                }else {
                    tvWeek3.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek2.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek1.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)+1+"");
                }
                break;
            case "星期五":
                tvWeek5.setText(dayOne);
                if (dayOne.equals("1")){
                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");
                }else if (dayOne.equals("2")){
                    tvWeek4.setText("1");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                }else if (dayOne.equals("3")){
                    tvWeek4.setText("2");
                    tvWeek3.setText("1");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                }else if (dayOne.equals("4")){
                    tvWeek4.setText("3");
                    tvWeek3.setText("2");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText("1");
                }else {
                    tvWeek4.setText(Integer.parseInt(dayOne)-1+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek2.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek1.setText(Integer.parseInt(dayOne)-4+"");
                }
                break;
            case "星期六":
                if (dayOne.equals("1")){
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek5.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-4+"");
                }else if (dayOne.equals("2")){
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek5.setText("1");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");

                }else if (dayOne.equals("3")){

                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek4.setText("1");
                    tvWeek5.setText("2");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                }else if (dayOne.equals("4")){
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek3.setText("1");
                    tvWeek4.setText("2");
                    tvWeek5.setText("3");
                }else if (dayOne.equals("5")){

                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText("1");
                    tvWeek3.setText("2");
                    tvWeek4.setText("3");
                    tvWeek5.setText("4");
                }else {
                    tvWeek1.setText(Integer.parseInt(dayOne)-5+"");
                    tvWeek2.setText(Integer.parseInt(dayOne)-4+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)-2+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)-1+"");
                }


                break;
            case "星期日":
                if (dayOne.equals("1")){
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-4+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");
                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek5.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-5+"");
                }else if (dayOne.equals("2")){
                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek5.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-4+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");

                }else if (dayOne.equals("3")){

                    tvWeek4.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek5.setText("1");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-3+"");
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                }else if (dayOne.equals("4")){
                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-1+"");
                    tvWeek3.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)-2+"");
                    tvWeek4.setText("1");
                    tvWeek5.setText("2");
                }else if (dayOne.equals("5")){

                    tvWeek2.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek3.setText("1");
                    tvWeek4.setText("2");
                    tvWeek5.setText("3");
                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                }else if (dayOne.equals("6")){

                    tvWeek1.setText(DateUtil.getLastDay(Integer.parseInt(year), Integer.parseInt(newMonthh)==1?12:Integer.parseInt(newMonthh)-1)+"");
                    tvWeek2.setText("1");
                    tvWeek3.setText("2");
                    tvWeek4.setText("3");
                    tvWeek5.setText("4");
                }else {


                    tvWeek1.setText(Integer.parseInt(dayOne)-6+"");
                    tvWeek2.setText(Integer.parseInt(dayOne)-5+"");
                    tvWeek3.setText(Integer.parseInt(dayOne)-4+"");
                    tvWeek4.setText(Integer.parseInt(dayOne)-3+"");
                    tvWeek5.setText(Integer.parseInt(dayOne)-2+"");
                }
                break;
        }
    }
}
