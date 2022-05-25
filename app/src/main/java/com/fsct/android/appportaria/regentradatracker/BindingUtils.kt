
package com.fsct.android.appportaria.regentradatracker

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.fsct.android.appportaria.convertDurationToFormatted
import com.fsct.android.appportaria.database.Registro

//sleepDurationFormatted
@BindingAdapter("permanenciaFormatted")
fun TextView.setPermanenciaFormatted(item: Registro) {
    text = convertDurationToFormatted(item.horaEntradaMs, item.horaSaidaMs, context.resources)
}





