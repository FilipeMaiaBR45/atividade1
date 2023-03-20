package com.example.atividade1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.atividade1.databinding.ActivityAlterarDadosBinding

class AlterarDados : AppCompatActivity() {

    lateinit var binding: ActivityAlterarDadosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alterar_dados)

//        val params = intent.extras
//        val texto = params?.getString("NOME", "Nome n enviado")
//
//        val textoRecebido: TextView = findViewById(R.id.textoRecebido)
//        textoRecebido.text = texto


        binding.buttonAlterar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("VALOR", binding.valorParaCalculo.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
        binding.buttonFechar.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }
}

//    fun doFechar(v:View){
//        val intent = Intent()
//        intent.putExtra("DADOS", "DEU CERTO")
//        setResult(Activity.RESULT_OK, intent)
//        finish()
//    }
