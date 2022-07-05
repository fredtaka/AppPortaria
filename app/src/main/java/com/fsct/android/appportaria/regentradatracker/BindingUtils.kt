
package com.fsct.android.appportaria.regentradatracker

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.fsct.android.appportaria.convertLongToDateString
import com.fsct.android.appportaria.cpfDigitadoNumero
import com.fsct.android.appportaria.database.Registro
import com.fsct.android.appportaria.horaEntradaFormatted

//sleepDurationFormatted
@BindingAdapter("HoraEntradaFormatted")
fun TextView.setHoraEntradaFormatted(item: Registro) {
    text = horaEntradaFormatted(item.horaEntradaMs,context.resources)
}


@BindingAdapter("CpfDigitadoNumero")
fun TextView.setCpfDigitadoNumero(item: Registro) {
    text = cpfDigitadoNumero(item.cpfPessoa,context.resources)
}


