package com.onilrose.coroutineanimation

import android.provider.Browser.sendString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testcoroutine() {
        runBlocking {
            println("Init")
            val time = measureTimeMillis {
                foo().forEach { println(it) }
            }
            println("Completed in $time ms")
        }
    }

    fun foo3(): Flow<Int> = (1..40).asFlow()

    fun foo(): Sequence<Int> = sequence {
        // sequence builder
        for (i in 1..40) {
            Thread.sleep(100) // pretend we are computing it
            yield(i) // yield next value
        }
    }

    suspend fun foo2(): List<Int> {
        val i: MutableList<Int> = mutableListOf()
        for (data in 1..40) {
            i.add(data)
        }
        delay(1000) // pretend we are doing something asynchronous here
        return i
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(2000L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(3000L) // pretend we are doing something useful here, too
        return 29
    }

}
