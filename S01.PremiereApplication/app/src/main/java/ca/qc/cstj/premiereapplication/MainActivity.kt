package ca.qc.cstj.premiereapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    //Méthode de création de notre Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R = dossier res
        setContentView(R.layout.activity_main)

        //val == const en javascript
        //findViewById retrouve un contrôle (view) avec le id passé en paramètre
        val btnShow = findViewById<Button>(R.id.btnShow)
        val edtMessage = findViewById<EditText>(R.id.edtMessage)

        btnShow.setOnClickListener {
            //Toast = affiche un popup avec le text (2e paramètre)
            //val message = edtMessage.text.toString()
            Toast.makeText(this, edtMessage.text.toString(), Toast.LENGTH_LONG).show()
        }

    }
}