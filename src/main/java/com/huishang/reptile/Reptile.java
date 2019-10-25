package com.huishang.reptile;

import java.util.*;

/**
 * 爬虫主程序
 * @author zhang_fei
 * @create 2019-10-23 15:50
 */
public class Reptile {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        Analyze analyze = new Analyze();
        for (int i = 327; i <= 328; i++) {
            Course course = analyze.regexMain(String.valueOf(i));
            if (course != null) {
                courses.add(course);
                System.out.println("课程id\tid:" + course.getId() + "\t标题:" + course.getTitle()+"\t原价:" + course.getOriPrice()  +"\t优惠价:" + course.getSalePrice()  +"\t讲师:" + course.getLecturer()+"\t适合人群:"+course.getPeop()+"\t技术要求:"+course.getTecRreq()+"\t环境参数:"+course.getEnvPara());
            }
        }
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }
}



