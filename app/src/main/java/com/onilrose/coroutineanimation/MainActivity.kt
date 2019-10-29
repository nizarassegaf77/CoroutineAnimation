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
            if (goDown) {
                performAnimation()
            } else {
                performAnimation2()
            }
            goDown = !goDown
        }
    }

    private fun performAnimation2() {
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

    private fun performAnimation() {
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


}
