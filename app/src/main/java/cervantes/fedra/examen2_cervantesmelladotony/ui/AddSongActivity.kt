package cervantes.fedra.examen2_cervantesmelladotony.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import cervantes.fedra.examen2_cervantesmelladotony.R
import cervantes.fedra.examen2_cervantesmelladotony.Song


class AddSongActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_song)

        val songNameEditText: EditText = findViewById(R.id.song_name)
        val artistNameEditText: EditText = findViewById(R.id.artist_name)
        val durationEditText: EditText = findViewById(R.id.duration)
        val albumNameEditText: EditText = findViewById(R.id.album_name)
        val saveButton: Button = findViewById(R.id.save_button)

        saveButton.setOnClickListener {
            val songName = songNameEditText.text.toString()
            val artistName = artistNameEditText.text.toString()
            val duration = durationEditText.text.toString()
            val albumName = albumNameEditText.text.toString()

            if (songName.isNotBlank() && artistName.isNotBlank() && duration.isNotBlank() && albumName.isNotBlank()) {
                val song = Song(songName, artistName, duration, albumName, R.drawable.default_image)
                (applicationContext as MyApplication).addSong(song)
                Toast.makeText(this, "Canción agregada exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
