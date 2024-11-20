package dev.rendrap.app.movienight.core.database.converter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class InstantConverterTest : FunSpec({
    val sut = InstantConverter()

    test("longToInstant should return Instant") {
        val long = 73264271044L

        val actual = sut.longToInstant(long)

        actual.shouldBeInstanceOf<Instant>()
    }

    test("longToInstant should handle null") {
        val actual = sut.longToInstant(null)

        actual.shouldBeNull()
    }

    test("instantToLong should return Long") {
        val instant = Clock.System.now()

        val actual = sut.instantToLong(instant)

        actual.shouldBeInstanceOf<Long>()
    }

    test("instantToLong should handle null") {
        val actual = sut.instantToLong(null)

        actual.shouldBeNull()
    }
})