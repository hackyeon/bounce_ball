package com.hackyeon.canvasreview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.hackyeon.canvasreview.CompanionObjectClass.Companion.ballList
import com.hackyeon.canvasreview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var myCanvas: MyCanvas
    private var isFirst = true // 핸들러 한번만 보내기용
    private var handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {
                for (i in ballList) {
                    if(i.x >= 1000-i.size || i.x <= 100) i.moveX *= -1
                    if(i.y >= 1600-i.size || i.y <= 200) i.moveY *= -1
                    i.x += i.moveX
                    i.y += i.moveY
                }
                myCanvas.invalidate()
                sendEmptyMessageDelayed(0, 25)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myCanvas = MyCanvas(this)
        setContentView(myCanvas)

        myCanvas.setOnClickListener {
            var x = Random.nextInt(2, 7) * 100
            var y = Random.nextInt(3, 13) * 100
            var randomColor = Random.nextInt(0, 8)
            var color = when (randomColor) {
                0 -> Color.YELLOW
                1 -> Color.BLACK
                2 -> Color.BLUE
                3 -> Color.RED
                4 -> Color.GRAY
                5 -> Color.MAGENTA
                6 -> Color.WHITE
                else -> Color.CYAN
            }
            var size = Random.nextInt(10, 20) * 10
            var moveX = Random.nextInt(5, 15)
            var moveY = Random.nextInt(5, 15)
            ballList.add(Ball(x, y, color, size, moveX, moveY))
            myCanvas.invalidate() // 굳이 없어도 될거같기도
            if (isFirst) {
                handler.sendEmptyMessage(0)
                isFirst = false
            }
        }
    }

}