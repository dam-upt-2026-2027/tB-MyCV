package pt.uptomar.dam2026.mycv

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
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

        // controlar o evento 'click' do botão
        findViewById<Button>(R.id.button).setOnClickListener {
            showCV()
        }

    }

    /**
     * mostra o CV, ou não, após análise da resposta do utilizador
     */
    fun showCV() {
    /*
     * se na TextBox for escrito 'sim' ou 'yes'
     *    mostrar CV
     *    mostrar Nome
     *    esconder textbox
     *    esconder botão
     * senão
     *    não faz nada
     */

        // criar ponteiro para a TextBox
        var textBox=findViewById<EditText>(R.id.editTextText)

        // avaliar a resposta
        if(textBox.text.toString().lowercase().equals("sim") ||
            textBox.text.toString().lowercase().equals("yes")){
            findViewById<LinearLayout>(R.id.show_my_cv).visibility=View.VISIBLE
            findViewById<TextView>(R.id.my_name).visibility=View.VISIBLE
            findViewById<Button>(R.id.button).visibility=View.GONE
            textBox.visibility=View.GONE
        }



    }

}