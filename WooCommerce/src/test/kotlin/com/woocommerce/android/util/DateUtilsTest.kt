package com.woocommerce.android.util

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DateUtilsTest {
    @Test
    fun `getNumberOfDaysInMonth() returns correct values`() {
        // General case
        assertEquals(31, DateUtils.getNumberOfDaysInMonth("2018-05-22"))

        // February
        assertEquals(28, DateUtils.getNumberOfDaysInMonth("2018-02-23"))

        // Leap year February
        assertEquals(29, DateUtils.getNumberOfDaysInMonth("2020-02-07"))

        // Year and month only
        assertEquals(29, DateUtils.getNumberOfDaysInMonth("2020-02"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `getNumberOfDaysInMonth() throws exception on invalid string`() {
        assertEquals(29, DateUtils.getNumberOfDaysInMonth("invalid"))
    }

    @Test
    fun `getShortMonthDayString() returns correct values`() {
        assertEquals("Jul 3", DateUtils.getShortMonthDayString("2018-07-03"))
        assertEquals("Jul 28", DateUtils.getShortMonthDayString("2018-07-28"))

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("2018-22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("-07-41")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("")
        }
    }

    @Test
    fun `getShortMonthDayStringForWeek() returns correct values`() {
        assertEquals("Mar 12", DateUtils.getShortMonthDayStringForWeek("2018-W11"))
        // Jan 1 2018 happened to be a Monday, so the first day of the first week happens to also be
        // the first day of the year
        assertEquals("Jan 1", DateUtils.getShortMonthDayStringForWeek("2018-W1"))
        assertEquals("Jan 2", DateUtils.getShortMonthDayStringForWeek("2017-W1"))

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("2018-22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("-07-41")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("")
        }
    }

    @Test
    fun `getShortMonthString() returns correct values`() {
        assertEquals("Jul", DateUtils.getShortMonthString("2018-07"))
        assertEquals("Jan", DateUtils.getShortMonthString("2017-01"))

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("2018-22")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("-07-41")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortMonthDayString("")
        }
    }

    @Test
    fun `getDateString() returns correct values`() {
        assertEquals("2019-05-09", DateUtils.getDateString("May 9, 2019"))
        assertEquals("2018-12-31", DateUtils.getDateString("Dec 31, 2018"))
        assertEquals("2019-01-01", DateUtils.getDateString("Jan 01, 2019"))
        assertEquals("2019-02-28", DateUtils.getDateString("Feb 28, 2019"))

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getDateString("Dec 30 2018")
        }

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getDateString("2019-12-31")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getDateString("-07-41")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getDateString("")
        }
    }

    @Test
    fun `getShortHourString() returns correct values`() {
        assertEquals("12am", DateUtils.getShortHourString("2019-05-09 00"))
        assertEquals("12pm", DateUtils.getShortHourString("2019-05-09 12"))
        assertEquals("1am", DateUtils.getShortHourString("2018-12-31 01"))
        assertEquals("5am", DateUtils.getShortHourString("2019-07-15 05"))
        assertEquals("2pm", DateUtils.getShortHourString("2019-01-01 14"))
        assertEquals("11pm", DateUtils.getShortHourString("2019-02-28 23"))
        assertEquals("4pm", DateUtils.getShortHourString("2019-02-28 16"))
        assertEquals("9am", DateUtils.getShortHourString("2019-02-28 09"))

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortHourString("Dec 30 2018")
        }

        // Test for invalid value handling
        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortHourString("2019-12-31")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortHourString("-07-41")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortHourString("")
        }

        assertFailsWith(IllegalArgumentException::class) {
            DateUtils.getShortHourString("5am")
        }
    }
}
