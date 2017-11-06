package com.ztechnologie.mastarch.cerclecalcule

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    class Calculateurs{
        fun aire(r: Double): Double{
            return 3.141592 * r * r
        }
        fun circonference(r: Double): Double{
            return 2.0 * 3.141592 * r
        }
    }
    fun parseDouble(str: String): Double? {
        return str.toDoubleOrNull()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.mesure_array, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter
    }

    @SuppressLint("SetTextI18n")

    fun onAnswerClick(view: View) {

        val answer = editText_result.text.toString()
        var rayon = parseDouble(answer)


        if (rayon == null) {
            val toasty = Toast.makeText(applicationContext, "Ce nombre est nul !", Toast.LENGTH_SHORT)
            toasty.show()
            return
        }
        if (rayon < 0) {
            val toasty = Toast.makeText(applicationContext, "Ce nombre est négatif !", Toast.LENGTH_SHORT)
            toasty.show()
        } else if (rayon > 0) {
            val c = Calculateurs()
            if (spinner.getSelectedItem() == "Diamètre"){
                rayon = rayon / 2.0
            }
            cire.text = c.circonference(rayon).toString()
            aire.text = c.aire(rayon).toString()
        }
    }

}


