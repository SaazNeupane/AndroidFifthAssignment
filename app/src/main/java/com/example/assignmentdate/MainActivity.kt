package com.example.assignmentdate

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var btnjoin:Button
    private lateinit var tvjoin:TextView
    private lateinit var btndob:Button
    private lateinit var tvdob:TextView
    private lateinit var tvyear:TextView
    private lateinit var tvage:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnjoin=findViewById(R.id.btnjoin)
        tvjoin=findViewById(R.id.tvjoin)
        btndob=findViewById(R.id.btndob)
        tvdob=findViewById(R.id.tvdob)
        tvyear=findViewById(R.id.tvyear)
        tvage=findViewById(R.id.tvage)

        btnjoin.setOnClickListener{
            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        tvjoin.text = "Selected Date:$dayOfMonth/${monthOfYear + 1}/$year"
                    },
                    year,
                    month,
                    day
            )
            datePickerDialog.show()
        }
        btndob.setOnClickListener{
            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        val date = "$dayOfMonth/${monthOfYear + 1}/$year"
                        tvdob.text = "Selected Date: $date"
                    },
                    year,
                    month,
                    day
            )
            datePickerDialog.show()
            calculateAge(c.timeInMillis)
        }
    }
    fun calculateAge(date: Long) {
        val dob = Calendar.getInstance()
        dob.timeInMillis = date
        val today = Calendar.getInstance()
        val d=dob[Calendar.YEAR]
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        tvage.text="$d"
    }

}