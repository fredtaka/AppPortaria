
package com.fsct.android.appportaria

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fsct.android.appportaria.database.Registro
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * These functions create a formatted string that can be set in a TextView.
 */

private val ONE_MINUTE_MILLIS = TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES)
private val ONE_HOUR_MILLIS = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)

/**
 * Convert a duration to a formatted string for display.
 *
 * fscts:
 *
 * 6 seconds on Wednesday
 * 2 minutes on Monday
 * 40 hours on Thursday
 *
 * @param horaEntradaMs the start of the interval
 * @param horaSaidaMs the end of the interval
 * @param res resources used to load formatted strings
 */
fun convertDurationToFormatted(horaEntradaMs: Long, horaSaidaMs: Long, res: Resources): String {
    val durationMilli = horaSaidaMs - horaEntradaMs
    val weekdayString = SimpleDateFormat("EEEE", Locale.getDefault()).format(horaEntradaMs)
    return when {
        durationMilli < ONE_MINUTE_MILLIS -> {
            val seconds = TimeUnit.SECONDS.convert(durationMilli, TimeUnit.MILLISECONDS)
            res.getString(R.string.seconds_length, seconds, weekdayString)
        }
        durationMilli < ONE_HOUR_MILLIS -> {
            val minutes = TimeUnit.MINUTES.convert(durationMilli, TimeUnit.MILLISECONDS)
            res.getString(R.string.minutes_length, minutes, weekdayString)
        }
        else -> {
            val hours = TimeUnit.HOURS.convert(durationMilli, TimeUnit.MILLISECONDS)
            res.getString(R.string.hours_length, hours, weekdayString)
        }
    }
}

/**
* Returns a string representing the numeric quality rating.
*/
fun convertNumericQualityToString(quality: Int, resources: Resources): String {
    var qualityString = resources.getString(R.string.three_ok)
    when (quality) {
        -1 -> qualityString = "--"
        0 -> qualityString = resources.getString(R.string.pesquisador)
        1 -> qualityString = resources.getString(R.string.outros)

    }
    return qualityString
}

/**
 * Take the Long milliseconds returned by the system and stored in Room,
 * and convert it to a nicely formatted string for display.
 *
 * EEEE - Display the long letter version of the weekday
 * MMM - Display the letter abbreviation of the month
 * dd-yyyy - day in month and full year numerically
 * HH:mm - Hours and minutes in 24hr format
 */
@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(systemTime: Long): String {
    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
}

/**
 * Takes a list of SleepNights and converts and formats it into one string for display.
 *
 * For display in a TextView, we have to supply one string, and styles are per TextView, not
 * applicable per word. So, we build a formatted string using HTML. This is handy, but we will
 * learn a better way of displaying this data in a future lesson.
 *
 * @param   eventos - List of all SleepNights in the database.
 * @param   resources - Resources object for all the resources defined for our app.
 *
 * @return  Spanned - An interface for text that has formatting attached to it.
 *           See: https://developer.android.com/reference/android/text/Spanned
 */
fun formatRegistros(eventos: List<Registro>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.title))
        eventos.forEach {
            append("<br>")
            append(resources.getString(R.string.start_time))
            append("\t${convertLongToDateString(it.horaEntradaMs)}<br>")
            if (it.horaSaidaMs != it.horaEntradaMs) {
                append(resources.getString(R.string.end_time))
                append("\t${convertLongToDateString(it.horaSaidaMs)}<br>")
                append(resources.getString(R.string.quality))
                append("\t${convertNumericQualityToString(it.grupoPessoa, resources)}<br>")
                append(resources.getString(R.string.hours_slept))
                // Hours
                append("\t ${it.horaSaidaMs.minus(it.horaEntradaMs) / 1000 / 60 / 60}:")
                // Minutes
                append("${it.horaSaidaMs.minus(it.horaEntradaMs) / 1000 / 60}:")
                // Seconds
                append("${it.horaSaidaMs.minus(it.horaEntradaMs) / 1000}<br><br>")
            }
        }
    }
    // fromHtml is deprecated for target API without a flag, but since our minSDK is 19, we
    // can't use the newer version, which requires minSDK of 24
    //https://developer.android.com/reference/android/text/Html#fromHtml(java.lang.String,%20int)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(sb.toString())
    }
}

/**
 * ViewHolder that holds a single [TextView].
 *
 * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
 * to the RecyclerView such as where on the screen it was last drawn during scrolling.
 */
class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
