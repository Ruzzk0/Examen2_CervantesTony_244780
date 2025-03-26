package cervantes.fedra.examen2_cervantesmelladotony.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import cervantes.fedra.examen2_cervantesmelladotony.R

class PlayerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val songTitle: TextView = findViewById(R.id.song_playing)
        val stopButton: Button = findViewById(R.id.stop_button)

        songTitle.text = "Reproduciendo: " + (intent.extras?.getString("song_title") ?: "Sin título")

        stopButton.setOnClickListener {
            finish()
        }
    }
}
