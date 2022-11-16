package com.gradleKotlin.service

import com.gradleKotlin.model.IdentityCode
import org.springframework.stereotype.Service
import java.lang.Math.floor

@Service
class IdentityCodeService {
    fun checkIfValid(idData: IdentityCode): Boolean {
        val wholeId = idData.id

        if ((kotlin.math.floor((idData.birthYear / 100).toDouble()) * 2 - 34 - (if (idData.gender) 1 else 0)) != wholeId.subSequence(
                0,
                1
            ).toString().toDouble()
        ) {
            return false
        }
        if (wholeId.subSequence(1, 3).toString().toInt() != idData.birthYear.toString().takeLast(2).toInt()) {
            return false
        }
        if (wholeId.subSequence(3, 5).toString().toInt() in 1..12)
            when (wholeId.subSequence(3, 5).toString().toInt()) {
                1, 3, 5, 7, 8, 10, 12 -> if (wholeId.subSequence(5, 7).toString().toInt() !in 1..31) return false
                4, 6, 9, 11 -> if (wholeId.subSequence(5, 7).toString().toInt() !in 1..30) return false
                2 -> if (wholeId.subSequence(5, 7).toString().toInt() !in 1..29) return false
            }
        println(checkChecksum(wholeId))
        if (checkChecksum(wholeId) != wholeId.takeLast(1).toInt()) {
            return false
        }
        return true
    }

    private fun checkChecksum(code: String): Any {
        var b = 1
        var c = 3
        var d = 0
        var e = 0
        var digit : Int
        val code1 =code.dropLast(1)
        for (index in code1) {
            digit = index.digitToInt()
            d += digit * b
            e += digit * c
            b++
            println(b)
            c++
            if (b == 10){
                b = 1}
            if (c == 10) {
                c = 1}
        }
        println(d)
        d %= 11
        e %= 11

        return if (d < 10)
            d
        else if (e < 10)
            e
        else
            0
    }
}