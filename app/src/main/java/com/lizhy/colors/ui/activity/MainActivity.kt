package com.lizhy.colors.ui.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lizhy.colors.R
import com.lizhy.colors.constant.ColorConstant
import com.lizhy.colors.constant.Colors
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mRed = 0
    private var mBlue = 0
    private var mGreen = 0
    private var mAlpha= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeColor(window.decorView)
    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

    }

    fun changeColor(view: View) {
        val random = Random()
        val ranColor = -0x1000000 or random.nextInt(0x00ffffff)

        view.setBackgroundColor(ranColor)
        mRed = Color.red(ranColor)
        mBlue = Color.blue(ranColor)
        mGreen = Color.green(ranColor)
        mAlpha = Color.alpha(ranColor)
        val sb = StringBuffer()
        sb.append(int2HexString(mRed)).append(int2HexString(mBlue)).append(int2HexString(mGreen))

        tv_colorValue.text = sb

        changeUI()
    }

    private fun changeUI() {
        tv_colorName.text = Colors.getInstance().random().name
        tv_colorRedValue.text = mRed.toString()
        tv_colorBlueValue.text = mBlue.toString()
        tv_colorGreenValue.text = mGreen.toString()
        tv_colorAlphaValue.text = mAlpha.toString()

        pb_colorRedValue.progress = mRed
        pb_colorBlueValue.progress = mBlue
        pb_colorGreenValue.progress = mGreen
        pb_colorAlphaValue.progress = mAlpha
    }

    private val delta = 0x9fa1 - 0x4e00 + 1
    private fun getRandomString(length: Int): String {
        val buffer = StringBuffer()
        val ran = Random()
        for (i in 0 until length) {
            buffer.append((0x4e00 + ran.nextInt(delta)).toChar())
        }
        return buffer.toString()
    }

    private fun int2HexString(b: Int): String {
        var hex = Integer.toHexString(b)
        if (hex.length == 1) {
            hex = '0' + hex
        }
        return hex.toUpperCase()
    }

}
