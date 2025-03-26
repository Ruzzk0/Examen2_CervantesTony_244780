package cervantes.fedra.examen2_cervantesmelladotony.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cervantes.fedra.examen2_cervantesmelladotony.R
import cervantes.fedra.examen2_cervantesmelladotony.Song

class CatalogActivity : AppCompatActivity() {

    private val songs = (applicationContext as MyApplication).getSongs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val gridView = findViewById<GridView>(R.id.songs_catalog)
        val adapter = SongAdapter(this, songs)
        gridView.adapter = adapter

        val addButton = findViewById<Button>(R.id.add_song_button)
        addButton.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java)
            startActivity(intent)
        }
    }

    inner class SongAdapter(private val context: CatalogActivity, private val songs: List<Song>) : BaseAdapter() {

        override fun getCount(): Int = songs.size

        override fun getItem(position: Int): Any = songs[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val song = songs[position]
            val view = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false)

            val imageView = view.findViewById<ImageView>(R.id.song_image)
            val nameTextView = view.findViewById<TextView>(R.id.song_name)
            val artistTextView = view.findViewById<TextView>(R.id.song_artist)

            imageView.setImageResource(song.image)
            nameTextView.text = song.name
            artistTextView.text = song.artist

            view.setOnClickListener {
                val intent = Intent(context, SongDetail::class.java).apply {
                    putExtra("song_name", song.name)
                    putExtra("song_artist", song.artist)
                    putExtra("song_duration", song.duration)
                    putExtra("song_album", song.album)
                    putExtra("song_image", song.image)
                }
                context.startActivity(intent)
            }

            return view
        }
    }
}
