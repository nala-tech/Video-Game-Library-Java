import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoGameLibraryTest {
    @BeforeEach
    void setUp() {
        VideoGameLibrary.libraryStart = VideoGameLibrary.initializeLibrary();
        VideoGameLibrary.gameMap.clear();
        VideoGameLibrary.gameMap.put(1, new VideoGame() {{
            title = "The Legend of Zelda: Breath of the Wild";
            genre = "Action-Adventure";
            id = 1;
        }});
        VideoGameLibrary.gameMap.put(2, new VideoGame() {{
            title = "Elden Ring";
            genre = "RPG";
            id = 2;
        }});
        VideoGameLibrary.gameMap.put(3, new VideoGame() {{
            title = "Minecraft";
            genre = "Sandbox";
            id = 3;
        }});
    }

    @Test
    void testMergeSortByTitle() {
        VideoGameLibrary.libraryStart = VideoGameLibrary.mergeSortByTitle(VideoGameLibrary.libraryStart);
        assertNotNull(VideoGameLibrary.libraryStart);
        assertEquals("Elden Ring", VideoGameLibrary.libraryStart.title);
    }

    @Test
    void testSortGamesById() {
        VideoGameLibrary.libraryStart = VideoGameLibrary.sortGamesById(VideoGameLibrary.libraryStart);
        assertNotNull(VideoGameLibrary.libraryStart);
        assertEquals(1, VideoGameLibrary.libraryStart.id);
    }

    @Test
    void testDisplayGames() {
        assertDoesNotThrow(() -> VideoGameLibrary.displayGames(VideoGameLibrary.libraryStart));
    }

    @Test
        void testInitializeLibrary() {
        VideoGameLibrary.libraryStart = VideoGameLibrary.initializeLibrary();
        assertNotNull(VideoGameLibrary.libraryStart);
        assertEquals("The Legend of Zelda: Breath of the Wild", VideoGameLibrary.libraryStart.title);
        assertEquals(1, VideoGameLibrary.libraryStart.id);
        assertNotNull(VideoGameLibrary.gameMap.get(1));
        assertEquals("Action-Adventure", VideoGameLibrary.gameMap.get(1).genre);
    }

    @Test
    void testEmptyLibrary() {
        VideoGameLibrary.libraryStart = null;
    
        assertDoesNotThrow(() -> VideoGameLibrary.displayGames(VideoGameLibrary.libraryStart));
        assertDoesNotThrow(() -> VideoGameLibrary.inGenre(VideoGameLibrary.libraryStart));
    }
    
}
