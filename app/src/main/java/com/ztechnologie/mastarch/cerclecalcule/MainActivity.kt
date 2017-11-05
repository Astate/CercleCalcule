package com.ztechnologie.mastarch.cerclecalcule

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


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

    @SuppressLint("SetTextI18n")
    fun onAnswerClick(view: View) {

        val answer = (findViewById<EditText>(R.id.editText2) as EditText).text.toString()
        val spinner = findViewById<View>(R.id.spinner) as Spinner



        //var rayon = java.lang.Double.parseDouble(answer)
        var rayon = parseDouble(answer)
        if (rayon == null) {
            println("Mauvais format'$rayon'")
            return
        }

        if (spinner.getSelectedItem() == "Diamètre"){
            rayon = rayon *2
        }


        if (rayon < 0) {
            val toasty = Toast.makeText(applicationContext, "Ce nombre est négatif !", Toast.LENGTH_SHORT)
            toasty.show()
        } else if (rayon > 0) {
            val c = Calculateurs()
            val tc = findViewById<TextView>(R.id.cire) as TextView
            tc.text = "" + c.circonference(rayon)
            val ta = findViewById<TextView>(R.id.aire) as TextView
            ta.text = "" + c.aire(rayon)
        } else {
            val toasty = Toast.makeText(applicationContext, "Ce nombre est nul !", Toast.LENGTH_SHORT)
            toasty.show()
        }


    }


   // lateinit var editText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner) as Spinner
   //     editText2 = findViewById<EditText>(R.id.editText2) as EditText
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.mesure_array, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter

    }
/*
    override fun onResume() {
        super.onResume()
        editText2.setOnEditorActionListener( { textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                println("------------------------------Tu viens de cliquer sur OK-----------------------------------------")
                var crotte = onAnswerClick()
                println(crotte)
                handled = true
            }
            handled
        })
    }
*/
}


