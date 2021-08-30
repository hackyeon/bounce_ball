package com.hackyeon.canvasreview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.hackyeon.canvasreview.CompanionObjectClass.Companion.ballList

class MyCanvas(context: Context): View(context) {
    private var paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setBackgroundColor(Color.LTGRAY)
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        paint.textSize = 100f
        canvas.drawText("${ballList.size}", 500f, 130f, paint)


        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 10F
        canvas.drawRect(100F, 200F, 1000F, 1600F, paint)

        for(i in ballList){
            createBall(canvas, i.style, i.color, i.x, i.y, i.size)
        }
    }

    private fun createBall(canvas: Canvas, style:Paint.Style, color: Int, x: Int, y: Int, size: Int){
        paint.style = style
        paint.color = color
        canvas.drawOval(x.toFloat(), y.toFloat(), (x+size).toFloat(), (y+size).toFloat(), paint)
    }
}