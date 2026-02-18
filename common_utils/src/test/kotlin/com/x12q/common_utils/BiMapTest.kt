package com.x12q.common_utils

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import kotlin.test.*

class BiMapTest {


    lateinit var bimap: BiMap<Int, String>

    @BeforeTest
    fun bt() {
        bimap = BiMap(
            map = (1..100).map {
                it to makeText(it)
            }.toMap(),
            reversedMap = (1 .. 100).map {
                makeText(it) to it

            }.toMap()
        )
    }

    @Test
    fun containsKey_containsValue(){
        bimap.containsKey(23).shouldBeTrue()
        bimap.containsKey(1000).shouldBeFalse()
        bimap.containsValue(makeText(23)).shouldBeTrue()
        bimap.containsValue(makeText(1000)).shouldBeFalse()
    }


    @Test
    fun filter() {
        val fm = bimap.filter { num, text ->
            num >= 50
        }

        fm.keys shouldBe (50 .. 100).toSet()
        fm.values shouldBe (50 .. 100).map { makeText(it) }.toSet()

    }

    @Test
    fun getByKey(){
        bimap.getByKey(22) shouldBe  makeText(22)
        bimap.getByKey(1000).shouldBeNull()
    }

    @Test
    fun getByValue(){
        bimap.getByValue(makeText(44)) shouldBe 44
        bimap.getByValue(makeText(1000)).shouldBeNull()
    }

    @Test
    fun add(){
        bimap.getByKey(1000) shouldBe null
        bimap.containsValue(makeText(1000)).shouldBeFalse()
        bimap.containsKey(1000).shouldBeFalse()

        val m1 = bimap.add(1000, makeText(1000))
        m1.getByKey(1000) shouldBe makeText(1000)
        m1.getByValue(makeText(1000)) shouldBe 1000
        m1.containsValue(makeText(1000)).shouldBeTrue()
        m1.containsKey(1000).shouldBeTrue()


        val m2 = bimap.add(listOf(
            1000 to makeText(1000)
        ))
        m2.getByKey(1000) shouldBe makeText(1000)
        m2.getByValue(makeText(1000)) shouldBe 1000
    }

    @Test
    fun removeByKey(){
        val key1 = 76
        val value1 = makeText(76)
        bimap.containsKey(key1).shouldBeTrue()
        bimap.containsValue(value1).shouldBeTrue()

        val key2 = 11
        val value2 = makeText(11)
        bimap.containsKey(key2).shouldBeTrue()
        bimap.containsValue(value2).shouldBeTrue()

        val m1 = bimap.removeByKey(listOf(key1,key2))

        m1.containsValue(value1).shouldBeFalse()
        m1.containsKey(key2).shouldBeFalse()
        m1.containsKey(key1).shouldBeFalse()
        m1.containsValue(value2).shouldBeFalse()
    }

    @Test
    fun removeByValue(){
        val key1 = 76
        val value1 = makeText(76)
        bimap.containsKey(key1).shouldBeTrue()
        bimap.containsValue(value1).shouldBeTrue()

        val key2 = 11
        val value2 = makeText(11)
        bimap.containsKey(key2).shouldBeTrue()
        bimap.containsValue(value2).shouldBeTrue()

        val m1 = bimap.removeByValue(listOf(value1,value2))

        m1.containsKey(key1).shouldBeFalse()
        m1.containsValue(value1).shouldBeFalse()
        m1.containsKey(key2).shouldBeFalse()
        m1.containsValue(value2).shouldBeFalse()
    }

    fun makeText(num:Int):String{
        return "text_$num"
    }

}
