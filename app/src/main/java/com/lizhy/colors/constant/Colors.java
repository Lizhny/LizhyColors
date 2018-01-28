package com.lizhy.colors.constant;

import java.util.Random;



/**
 * 颜色器
 * Created by Lizhy on 2018/1/28.
 */

public class Colors {
    private static Colors instance;
    private Random random = new Random();
    private int postion = 0;

    public static Colors getInstance() {
        if (instance == null) {
            instance = new Colors();
        }
        return instance;
    }


    public Colors random(){
        postion = random.nextInt(getSize());
        return this;
    }
    public String getName() {
        return names[postion];
    }



    public int getSize() {
        return names.length;
    }

    private String[] names = new String[]{"蔚蓝", "蓝", "碧蓝", "靛青", "靛蓝", "花青", "宝蓝", "蓝灰色", "藏青", "藏蓝",
            "黛", "黛绿", "黛蓝", "黛紫", "紫色", "紫酱", "酱紫", "紫檀", "绀青", "紫棠", "青莲", "群青",
            "雪青", "藕色", "藕荷色", "朱砂", "火红", "朱膘", "妃色", "洋红", "品红", "粉红", "桃红",
            "海棠红", "樱桃色", "酡颜", "银红", "大红", "石榴红", "绛紫", "绯红", "胭脂", "朱红", "丹",
            "彤", "酡红", "炎", "茜色", "绾", "檀", "嫣红", "洋红Ⅱ"};

}
