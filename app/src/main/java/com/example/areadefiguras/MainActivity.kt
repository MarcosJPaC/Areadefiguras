package com.example.areadefiguras
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etSide: EditText
    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etBase: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSide = findViewById(R.id.et_side)
        etLength = findViewById(R.id.et_length)
        etWidth = findViewById(R.id.et_width)
        etBase = findViewById(R.id.et_base)
        etHeight = findViewById(R.id.et_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val side = etSide.text.toString().toDoubleOrNull()
        val length = etLength.text.toString().toDoubleOrNull()
        val width = etWidth.text.toString().toDoubleOrNull()
        val base = etBase.text.toString().toDoubleOrNull()
        val height = etHeight.text.toString().toDoubleOrNull()

        var area = 0.0

        when {
            side != null -> area = side.pow(2)
            length != null && width != null -> area = length * width
            base != null && height != null -> area = 0.5 * base * height
        }

        tvResult.text = "Area: $area"
    }
}
