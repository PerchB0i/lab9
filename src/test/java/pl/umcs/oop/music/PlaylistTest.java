package pl.umcs.oop.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    @Test
    public void testIfNewPlaylistEmpty () {
        Playlist newPlaylist = new Playlist();
        assertTrue(newPlaylist.isEmpty());
    }

    @Test
    public void testIfAfterAppendSizeIs1 () {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        newPlaylist.add(someSong);
        assertEquals(1, newPlaylist.size());
    }

    @Test
    public void testIfSameSongInPlaylist() {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        Song someSong1 = new Song("Some Guy", "SoemSnog", 240);
        newPlaylist.add(someSong);
        assertTrue(newPlaylist.contains(someSong1));
    }

    @Test
    public void atSecond() {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        Song someSong1 = new Song("Some Guy", "SoemSnog vol.2: Electric Boogaloo", 300);
        newPlaylist.add(someSong);
        newPlaylist.add(someSong1);

        assertEquals(someSong1, newPlaylist.atSecond(270));
    }

    @Test
    public void atSecondThrowsException () {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        Song someSong1 = new Song("Some Guy", "SoemSnog vol.2: Electric Boogaloo", 300);
        newPlaylist.add(someSong);
        newPlaylist.add(someSong1);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    newPlaylist.atSecond(900);
                }
        );
    }

    @Test
    public void atSecondThrowsExceptionNegativeTime () {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        Song someSong1 = new Song("Some Guy", "SoemSnog vol.2: Electric Boogaloo", 300);
        newPlaylist.add(someSong);
        newPlaylist.add(someSong1);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    newPlaylist.atSecond(-900);
                },
                "Podano ujemny czas!"
        );
    }

    @Test
    public void atSecondThrowsExceptionOutOfTime () {
        Playlist newPlaylist = new Playlist();
        Song someSong = new Song("Some Guy", "SoemSnog", 240);
        Song someSong1 = new Song("Some Guy", "SoemSnog vol.2: Electric Boogaloo", 300);
        newPlaylist.add(someSong);
        newPlaylist.add(someSong1);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    newPlaylist.atSecond(900);
                },
                "Podano czas wykraczający poza czas trwania playlisty!"
        );
    }
}