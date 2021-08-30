package com.hackyeon.canvasreview

import android.graphics.Color
import android.graphics.Paint
import java.util.logging.Handler

class Ball(
    var x: Int,
    var y: Int,
    var color: Int,
    var size: Int,
    var moveX: Int,
    var moveY: Int,
    var style: Paint.Style = Paint.Style.FILL
)