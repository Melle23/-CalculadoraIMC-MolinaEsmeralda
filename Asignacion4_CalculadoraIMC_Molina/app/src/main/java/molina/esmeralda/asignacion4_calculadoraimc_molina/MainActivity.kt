package molina.esmeralda.asignacion4_calculadoraimc_molina

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val weight: EditText = findViewById(R.id.editTextNumberDecimal2)
        val height: EditText = findViewById(R.id.editTextNumberDecimal)
        val calculateButton: Button = findViewById(R.id.btnCalcular)
        val imcTextView: TextView = findViewById(R.id.textView3)
        val rangeTextView: TextView = findViewById(R.id.textView4)


        calculateButton.setOnClickListener {
            val weightValue = weight.text.toString().toFloatOrNull()
            val heightValue = height.text.toString().toFloatOrNull()

            if (weightValue != null && heightValue != null && heightValue > 0) {
                val imc = weightValue / (heightValue * heightValue)
                imcTextView.text = "IMC: %.2f".format(imc)

                when {
                    imc < 18.5 -> {
                        rangeTextView.text = "Bajo peso"
                        rangeTextView.setBackgroundColor(Color.BLUE)
                    }

                    imc in 18.5..24.9 -> {
                        rangeTextView.text = "Normal"
                        rangeTextView.setBackgroundColor(Color.GREEN)
                    }

                    imc in 25.0..29.9 -> {
                        rangeTextView.text = "Sobrepeso"
                        rangeTextView.setBackgroundColor(Color.YELLOW)
                    }

                    imc in 30.0..34.9 -> {
                        rangeTextView.text = "Obesidad grado 1"
                        rangeTextView.setBackgroundColor(Color.parseColor("#FFA500"))
                    }

                    imc in 35.0..39.9 -> {
                        rangeTextView.text = "Obesidad grado 2"
                        rangeTextView.setBackgroundColor(Color.RED)
                    }

                    else -> {
                        rangeTextView.text = "Obesidad grado 3"
                        rangeTextView.setBackgroundColor(Color.parseColor("#8B0000"))
                    }
                }
            } else {
                imcTextView.text = "Por favor, introduce valores válidos"
                rangeTextView.text = ""
                rangeTextView.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }
}