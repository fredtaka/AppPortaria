package com.fsct.android.appportaria;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b\u001a\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000e\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"ONE_HOUR_MILLIS", "", "ONE_MINUTE_MILLIS", "convertDurationToFormatted", "", "horaEntradaMs", "horaSaidaMs", "res", "Landroid/content/res/Resources;", "convertLongToDateString", "systemTime", "convertNumericQualityToString", "quality", "", "resources", "formatRegistros", "Landroid/text/Spanned;", "eventos", "", "Lcom/fsct/android/appportaria/database/Registro;", "app_debug"})
public final class UtilKt {
    
    /**
     * These functions create a formatted string that can be set in a TextView.
     */
    private static final long ONE_MINUTE_MILLIS = 0L;
    private static final long ONE_HOUR_MILLIS = 0L;
    
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
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String convertDurationToFormatted(long horaEntradaMs, long horaSaidaMs, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources res) {
        return null;
    }
    
    /**
     * Returns a string representing the numeric quality rating.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String convertNumericQualityToString(int quality, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
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
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    public static final java.lang.String convertLongToDateString(long systemTime) {
        return null;
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
     *          See: https://developer.android.com/reference/android/text/Spanned
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.text.Spanned formatRegistros(@org.jetbrains.annotations.NotNull()
    java.util.List<com.fsct.android.appportaria.database.Registro> eventos, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
}