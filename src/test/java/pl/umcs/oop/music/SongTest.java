package pl.umcs.oop.music;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.umcs.oop.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @BeforeAll
    public static void setup() {
        DatabaseConnection.connect("songs.db");
    }

    @Test
    public void searchForSong() throws SQLException {
        Optional<Song> song;
        song = Song.Persistence.read(3);
        assertEquals("Stairway to Heaven", song.get().title());
    }

    @Test
    public void searchForSongIncorrectIndex() throws SQLException {
        Optional<Song> song;
        song = Song.Persistence.read(300);
        assertTrue(song.isEmpty());
    }

    @AfterAll
    public static void afterAll() {
        DatabaseConnection.disconnect();
    }
}