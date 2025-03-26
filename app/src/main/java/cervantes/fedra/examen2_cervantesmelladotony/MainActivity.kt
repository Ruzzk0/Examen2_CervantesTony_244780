package cervantes.fedra.examen2_cervantesmelladotony

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cervantes.fedra.examen2_cervantesmelladotony.ui.CatalogActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.start_button)
        boton.setOnClickListener {
            Toast.makeText(this, "Botón presionado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
        }
    }
}
