package cervantes.fedra.examen2_cervantesmelladotony.ui

import android.app.Application
import cervantes.fedra.examen2_cervantesmelladotony.Song


class MyApplication : Application() {
    private val songs = ArrayList<Song>()

    fun addSong(song: Song) {
        songs.add(song)
    }

    fun removeSong(song: Song) {
        songs.remove(song)
    }

    fun getSongs(): List<Song> {
        return songs
    }
}
