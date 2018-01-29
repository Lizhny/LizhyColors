package com.lizhy.colors.utils

/**
 * My small util
 * Created by Lizhy on 2018/1/29.
 */
class LizhyUtil {
    companion object {
     fun int2HexString(b: Int): String {
        var hex = Integer.toHexString(b)
        if (hex.length == 1) {
            hex = '0' + hex
        }
        return hex.toUpperCase()
    }

    }
}