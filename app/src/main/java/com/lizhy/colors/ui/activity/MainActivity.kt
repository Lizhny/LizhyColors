package com.lizhy.colors.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lizhy.colors.R
import com.lizhy.colors.constant.ColorPool
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        val colorInstance: ColorPool = ColorPool.INSTANCE.random()
        view.setBackgroundColor(colorInstance.color)

        val sb = StringBuffer()
        sb.append(colorInstance.hexAlpha).append(colorInstance.hexRed).append(colorInstance.hexBlue)
                .append(colorInstance.hexGreen)
        tv_colorValue.text = sb

        changeUI(colorInstance)
    }

    private fun changeUI(colorInstance: ColorPool) {
        tv_colorName.text = colorInstance.name
        tv_colorRedValue.text = colorInstance.red.toString()
        tv_colorBlueValue.text = colorInstance.blue.toString()
        tv_colorGreenValue.text = colorInstance.green.toString()
        tv_colorAlphaValue.text = colorInstance.alpha.toString()

        pb_colorRedValue.progress = colorInstance.red
        pb_colorBlueValue.progress = colorInstance.blue
        pb_colorGreenValue.progress = colorInstance.green
        pb_colorAlphaValue.progress = colorInstance.alpha
    }
}
