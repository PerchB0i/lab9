package pl.umcs.oop.music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    public Song atSecond (int seconds) {
        String message = "";
        if (seconds < 0) {
            message = message.concat("Podano ujemny czas!");
            throw new IndexOutOfBoundsException(message);
        }

        for(Song song : this) {
            seconds -= song.duration();
            if (seconds <= 0) {
                return song;
            }
        }
        throw new IndexOutOfBoundsException("Podano czas wykraczający poza czas trwania playlisty!");
    }
}
