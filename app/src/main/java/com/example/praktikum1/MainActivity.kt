package com.example.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLebar: EditText
    private lateinit var edtPanjang: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btncalculate: Button
    private lateinit var tvresult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLebar = findViewById(R.id.edt_Lebar)
        edtPanjang = findViewById(R.id.edt_Panjang)
        edtTinggi = findViewById(R.id.edt_Tinggi)
        btncalculate = findViewById(R.id.btn_calculate)
        tvresult = findViewById(R.id.tv_result)

        btncalculate.setOnClickListener(this);
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {

            var inputPanjang: String =
                edtPanjang.getText().toString().trim();

            var inputLebar: String =
                edtLebar.getText().toString().trim();

            var inputTinggi: String =
                edtTinggi.getText().toString().trim();

            var isEmptyFields = false
            var isInvalidDouble = false

            if (TextUtils.isEmpty(inputPanjang)) {
                isEmptyFields = true
                edtPanjang.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputLebar)) {
                isEmptyFields = true
                edtLebar.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true
                edtTinggi.error = "Field ini tidak boleh kosong"

            }
            val length = convertToDouble(inputPanjang);
            val width = convertToDouble(inputLebar);
            val height = convertToDouble(inputTinggi);

            if (length == null) {
                isInvalidDouble = true
                edtPanjang.error = "nilai tidak valid"
            }
            if (width == null) {
                isInvalidDouble = true
                edtLebar.error = "nilai tidak valid"
            }

            if (height == null) {
                isInvalidDouble = true
                edtTinggi.error = "nilai tidak valid"
            }

            if (!isEmptyFields && !isInvalidDouble) {
                val volume = height!!.toDouble() * length!!.toDouble() * width!!.toDouble()
                tvresult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(STATE_RESULT, tvresult.text.toString())
    }
    private fun convertToDouble(str: String):Double?{
        return try {
            str.toDouble()
        }catch (e : NumberFormatException){
            null
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }
}





