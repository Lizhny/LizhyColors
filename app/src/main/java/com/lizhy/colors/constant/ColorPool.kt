package com.lizhy.colors.constant

import android.graphics.Color
import com.lizhy.colors.utils.LizhyUtil
import java.util.Random


/**
 * 颜色器
 * Created by Lizhy on 2018/1/28.
 */

class ColorPool {
    private val random = Random()
    private var position = 0
    private var ranColor:Int=0

    companion object {
        @JvmStatic
        val INSTANCE: ColorPool by lazy { ColorPool() }
    }

    val name: String
        get() = names[position]

    val color: Int
        get() = ranColor

    val alpha:Int
       get()=Color.alpha(ranColor)
    val red:Int
       get()=Color.red(ranColor)
    val blue:Int
       get()=Color.blue(ranColor)
    val green:Int
       get()=Color.green(ranColor)

    val hexAlpha:String
        get() = LizhyUtil.int2HexString(alpha)
    val hexRed:String
        get() = LizhyUtil.int2HexString(red)
    val hexBlue:String
        get() = LizhyUtil.int2HexString(blue)
    val hexGreen:String
        get() = LizhyUtil.int2HexString(green)

    private val size: Int
        get() = names.size

    private val names = arrayOf("蔚蓝", "蓝", "碧蓝", "靛青", "靛蓝", "花青", "宝蓝", "蓝灰色",
            "藏青", "藏蓝", "黛", "黛绿", "黛蓝", "黛紫", "紫色", "紫酱", "酱紫", "紫檀", "绀青",
            "紫棠", "青莲", "群青", "雪青", "藕色", "藕荷色", "朱砂", "火红", "朱膘", "妃色", "洋红",
            "品红", "粉红", "桃红", "海棠红", "樱桃色", "酡颜", "银红", "大红", "石榴红", "绛紫", "绯红",
            "胭脂", "朱红", "丹", "彤", "酡红", "炎", "茜色", "绾", "檀", "嫣红", "洋红Ⅱ")

    fun random(): ColorPool {
        position = random.nextInt(size)
        val random = Random()
        ranColor = -0x1000000 or random.nextInt(0x00ffffff)
        return this
    }
}
