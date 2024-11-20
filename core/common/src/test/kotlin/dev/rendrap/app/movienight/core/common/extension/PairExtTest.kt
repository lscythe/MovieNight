package dev.rendrap.app.movienight.core.common.extension

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldBeTypeOf
import kotlin.math.exp

class PairExtTest : FunSpec({
    test("pairOf should create Pair") {
        val expected = Pair(1, 2)

        val actual = pairOf(1, 2)

        actual.shouldBeInstanceOf<Pair<Int, Int>>()
        actual.first.shouldBe(expected.first)
        actual.second.shouldBe(expected.second)
    }
    test("tripleOf should create Triple") {
        val expected = Triple(1, 2, 3)

        val actual = tripleOf(1, 2, 3)

        actual.shouldBeInstanceOf<Triple<Int, Int, Int>>()
        actual.shouldBe(expected)
    }
    test("pairOf should handle null") {
        val expected = Pair(null, 1)

        val actual = pairOf(null, 1)

        actual shouldBe expected
    }
    test("tripleOf should handle null") {
        val expected = Triple(1,2,null)

        val actual = tripleOf(1,2,null)

        actual shouldBe expected
    }
})