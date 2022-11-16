package com.example.praktikum1

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainactivityBiodata : AppCompatActivity(), View.OnClickListener {
    lateinit var etTanggal : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainbiodata)

        val btnSimpan:Button = findViewById(R.id.btn_simpan)
        btnSimpan.setOnClickListener(this)

        etTanggal=findViewById(R.id.et_input_tanggal)
        etTanggal.setOnClickListener{
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                this, {view, year, monthOfYear, dayOfMonth ->
                    val dat = dayOfMonth.toString() +"-"+ (monthOfYear + 1) + "-" + year
                    etTanggal.setText(dat)
                },
                year, month, day
            )

            datePickerDialog.show()

        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_simpan -> {
                val etNamaDepan : EditText = findViewById(R.id.et_input_namaDepan)
                val etnamaBelakang : EditText = findViewById(R.id.et_input_namaBelakang)
                val etTanggal : EditText = findViewById(R.id.et_input_tanggal)
                val etAlamat : EditText = findViewById(R.id.et_input_alamat)
                val etNomor : EditText = findViewById(R.id.et_input_nomor)

                val tvNama : TextView = findViewById(R.id.tv_output_nama)
                val tvTanggal : TextView = findViewById(R.id.tv_output_tanggal)
                val tvAlamat : TextView = findViewById(R.id.tv_output_alamat)
                val tvNomor : TextView = findViewById(R.id.tv_output_nomor)

                val textNama = "Nama : ${etNamaDepan.getText().toString()} ${etnamaBelakang.getText().toString()}"
                val textTanggal = "Tanggal Lahir : ${etTanggal.getText().toString()}"
                val textAlamat = "Alamat : ${etAlamat.getText().toString()}"
                val textNomor = "Nomor Telepon : ${etNomor.getText().toString()}"

                tvNama.text=textNama
                tvTanggal.text=textTanggal
                tvAlamat.text=textAlamat
                tvNomor.text=textNomor

            }
        }
    }
}