package com.huishang.reptile;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 利用正则来解析 HTML
 * @author zhang_fei
 * @create 2019-10-23 15:46
 */
public class Analyze {
    private Course course;

    public Course regexMain(String uid) {
        String url = "https://coding.imooc.com/class/" + uid + ".html";
        String result = ConnectionUtil.Connect(url); // 获取 html
        course = getCourseInfo(result, uid);
        return course;
    }

    private Course getCourseInfo(String targetStr, String uid) {

        // 提取标题
        Pattern titlePattern = Pattern.compile("title-box.*?</h1>");
        Matcher titleMatcher = titlePattern.matcher(targetStr);
        if (titleMatcher.find()) {
            String titleString = titleMatcher.group();
            int start = titleString.indexOf("<h1>"); // 计算字符串位置
            int end = titleString.indexOf("</h1>");
            String str = titleString.substring(start + 4, end).trim(); // 获取标题，去掉空格
            str = str.replaceAll("<br/>", " "); // 去掉标签
            course.setTitle(str);
        }
        // 优惠价
        Pattern salePricePattern = Pattern.compile("sale-price.*?</div>");
        Matcher salePriceMatcher = salePricePattern.matcher(targetStr);
        if (salePriceMatcher.find()) {
            String salePriceString = salePriceMatcher.group();
            int start = salePriceString.indexOf("￥");  // 计算字符串位置
            int end = salePriceString.indexOf("</div>");
            course.setSalePrice(Double.parseDouble(salePriceString.substring(start + 1, end)));
        } else {
            // System.out.println("无效id:" + uid); // 该课程没有优惠。。。
            return null;
        }

        // 原价
        Pattern oriPricePattern = Pattern.compile("ori-price.*?</div>");
        Matcher oriPriceMatcher = oriPricePattern.matcher(targetStr);
        if (oriPriceMatcher.find()) {
            String oriPriceString = oriPriceMatcher.group();
            int start = oriPriceString.indexOf("￥");
            int end = oriPriceString.indexOf("</div>");
            course.setOriPrice(Double.parseDouble(oriPriceString.substring(start + 1, end)));
        }

        //讲师
        Pattern nicknamePattern = Pattern.compile("<div class=\"nickname\">.*?</div>");
        Matcher nicknameMatcher = nicknamePattern.matcher(targetStr);
        if (nicknameMatcher.find()) {
            String nicknameString = nicknameMatcher.group();
            course.setLecturer(nicknameString.substring(22, nicknameString.length() - 6));
        }

        //模板测试
/*        Pattern peoplePattern = Pattern.compile("<p class=\"p-content\">.*?</p>");
        Matcher peopleMatcher = peoplePattern.matcher(targetStr);
        if (nicknameMatcher.find()) {
            String peopleString = peopleMatcher.group();
            course.setLecturer(peopleString.substring(22, peopleString.length() - 6));
        }*/

        //适合人群
        Pattern peoplePattern = Pattern.compile("<p class=\"p-content\">.*?</p>");
        Matcher peopleMatcher = peoplePattern.matcher(targetStr);
        if (titleMatcher.find()) {
            String titleString = titleMatcher.group();
            String str = titleString.substring(4,1).trim(); // 获取内容，去掉空格
            str = str.replaceAll("<br/>", " "); // 去掉标签
            course.setTitle(str);
        }


        //技术储备要求

        //环境参数

        course.setId(Integer.valueOf(uid));
        return course;

    }
}
