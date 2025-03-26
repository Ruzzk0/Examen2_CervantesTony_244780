package cervantes.fedra.examen2_cervantesmelladotony.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import cervantes.fedra.examen2_cervantesmelladotony.R
import cervantes.fedra.examen2_cervantesmelladotony.Song


class SongDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songdetail)

        val title: TextView = findViewById(R.id.title_song)
        val artist: TextView = findViewById(R.id.artist_song)
        val duration: TextView = findViewById(R.id.duration_song)
        val album: TextView = findViewById(R.id.album_song)
        val playButton: Button = findViewById(R.id.play_button)
        val deleteButton: Button = findViewById(R.id.delete_button)

        val songName = intent.extras?.getString("song_name") ?: "Sin título"
        val songArtist = intent.extras?.getString("song_artist") ?: "Sin artista"
        val songDuration = intent.extras?.getString("song_duration") ?: "--:--"
        val songAlbum = intent.extras?.getString("song_album") ?: "Sin álbum"

        title.text = songName
        artist.text = songArtist
        duration.text = songDuration
        album.text = songAlbum

        playButton.text = "Play $songName"
        playButton.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("song_title", songName)
            }
            startActivity(intent)
        }

        deleteButton.setOnClickListener {
            val song = Song(songName, songArtist, songDuration, songAlbum, R.drawable.default_image)
            (applicationContext as MyApplication).removeSong(song)
            Toast.makeText(this, "$songName eliminada", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
