package com.onilrose.coroutineanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.lang.Math.random

class MainActivity : AppCompatActivity() {

    private lateinit var avatar: View
    private var goDown = true
    lateinit var kotlin: View
    lateinit var coroutine: View
    lateinit var move: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlin = findViewById<View>(R.id.kotlin)
        coroutine = findViewById<View>(R.id.coroutine)
        avatar = findViewById<View>(R.id.avatar)
        move = findViewById<View>(R.id.move)

        move.setOnClickListener {
            //performAnimation()
            if (goDown) {
                performAnimationDown()
            } else {
                performAnimationTop()
            }
            goDown = !goDown
        }
    }

    private fun performAnimationTop() {
        animation(avatar) { rotation = 180f }
        animation(avatar) {
            top = avatar.y - avatar.height
        }
        animation(kotlin) {
            left = kotlin.x - avatar.width / 2
        }
        animation(coroutine) {
            left = coroutine.x + avatar.width / 2
        }
    }

    private fun performAnimationDown() {
        animation(avatar) { rotation = 360f }
        animation(avatar) {
            top = avatar.x + avatar.height
        }
        animation(kotlin) {
            left = kotlin.x + avatar.width / 2
        }
        animation(coroutine) {
            left = coroutine.x - avatar.width / 2
        }
    }

    private fun performAnimation() {
        GlobalScope.launch {
            animation(avatar, duration = 1000L) {
                scaleX = 0.5f
                scaleY = 0.5f
            }
            animation(avatar, duration = 500L) { centerY = 200f }.join()
            floatAnimation(avatar, from = 1f, to = 0.5f, duration = 500L) { view, value ->
                view.alpha = value
            }
            animation(avatar, duration = 500L) { centerX = 200f }.join()
            animation(avatar, duration = 500L) { centerY = 400f }.join()
            animation(avatar, duration = 500L) { centerY = 600f }.join()
            floatAnimation(avatar, from = 1f, to = 1f, duration = 500L) { view, value ->
                view.alpha = value
            }
            animation(avatar, duration = 1000L) {
                scaleX = 1f
                scaleY = 1f
            }
            animation(avatar, duration = 500L) { centerX = 540f }.join()
        }

    }


}
