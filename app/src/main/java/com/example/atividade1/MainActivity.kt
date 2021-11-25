package com.example.atividade1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.atividade1.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val activityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            when(it.resultCode){
                RESULT_OK->{
                    val params = it.data?.extras
                    val valor = params?.getString("VALOR")
                    binding.valorPeso.text = valor

                }
                RESULT_CANCELED->{
                    Toast.makeText(this, "CANCELOU", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val activityForResult2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            when(it.resultCode){
                RESULT_OK->{
                    val params = it.data?.extras
                    val valor = params?.getString("VALOR")
                    binding.valorAltura.text = valor
                }
                RESULT_CANCELED->{
                    Toast.makeText(this, "CANCELOU", Toast.LENGTH_SHORT).show()
                }
            }
        }



      binding.btnAlterarPeso.setOnClickListener {
           val intent = Intent(this, AlterarDados::class.java)
           activityForResult.launch(intent)

        }

      binding.btnAlterarAltura.setOnClickListener {
          var intent = Intent(this, AlterarDados::class.java)
          activityForResult2.launch(intent)
      }

        binding.btnCalcularImc.setOnClickListener {
         var valorPeso = binding.valorPeso.text.toString()
           var valorAltura = binding.valorAltura.text.toString()


           var peso = valorPeso.toFloat()
            var altura = valorAltura.toFloat()

           var  imc = peso/(altura*altura)
            Log.i("VALOR_PESO", "$peso")
            Log.i("VALOR_ALTURA", valorAltura)
            Log.i("VALOR_IMC", "$imc")

            if(imc < 16){
                binding.textResultadoImc.text = "Magreza grave"
            }else if (imc > 16 && imc < 17){
                binding.textResultadoImc.text = "Magreza moderada"
            }else if (imc > 17 && imc < 18.5){
                binding.textResultadoImc.text = "Magreza leve"
            }else if (imc > 18.5 && imc < 25){
                binding.textResultadoImc.text = "Saudável"
            }else if (imc > 25 && imc < 30){
                binding.textResultadoImc.text = "Sobrepeso"
            }else if (imc > 30 && imc < 35){
                binding.textResultadoImc.text = "Obesidade Grau I"
            }else if (imc > 35 && imc < 40){
                binding.textResultadoImc.text = "Obesidade Grau II (severa)"
            }else if (imc > 40){
                binding.textResultadoImc.text = "Obesidade Grau III (mórbida)"

            }



        }


    }

}