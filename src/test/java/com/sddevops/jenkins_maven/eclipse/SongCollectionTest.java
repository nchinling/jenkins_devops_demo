/**
 * 
 */
package com.sddevops.jenkins_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class SongCollectionTest {
	private SongCollection sc;
	private SongCollection sc_with_size;
	private SongCollection sc_with_size_1;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
//	private Song s5;
	private final int SONG_COLLECTION_SIZE=4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sc=new SongCollection();
		sc_with_size = new SongCollection(5);
		sc_with_size_1 = new SongCollection(1);
		s1 = new Song("001","good 4 u","Olivia Rodrigo",3.59);
		s2 = new Song("002","Peaches","Justin Bieber",3.18);
		s3 = new Song("003","MONTERO","Lil Nas",2.3);
		s4 = new Song("004","bad guy","billie eilish",3.14);
//		s5 = new Song("005", "Levitating", "Dua Lipa", 3.23); // Additional song for testing
		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#getSongs()}.
	 */
	@Test
	void testGetSongs() {
		List<Song> testSc=sc.getSongs();
		 testSc = sc.getSongs();
	        assertEquals(SONG_COLLECTION_SIZE, testSc.size(), "Song collection should contain 4 songs");

	        // Verify that the songs in the collection are the ones that were added
	        assertTrue(testSc.contains(s1), "Song collection should contain 'good 4 u'");
	        assertTrue(testSc.contains(s2), "Song collection should contain 'Peaches'");
	        assertTrue(testSc.contains(s3), "Song collection should contain 'MONTERO'");
	        assertTrue(testSc.contains(s4), "Song collection should contain 'bad guy'");
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#addSong(com.sddevops.junit_maven.eclipse.Song)}.
	 */
	@Test
	void testAddSong() {
		List<Song> testSc=sc.getSongs();
		//Assert that Song Collection is equals to Song Collection Size : 4
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
		//Act
		sc.addSong(s1);
		//Assert that Song Collection is equals to Song Collection Size + 1 : 5
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE+1);
		
		sc_with_size_1.addSong(s1);
		sc_with_size_1.addSong(s2);
		
		assertEquals(1, sc_with_size_1.getSongs().size());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsByTitle()}.
	 */
	@Test
	void testSortSongsByTitle() {

		List<Song> sortedSongs = sc.sortSongsByTitle();

		assertEquals("MONTERO", sortedSongs.get(0).getTitle());
		assertEquals("Peaches", sortedSongs.get(1).getTitle());
		assertEquals("bad guy", sortedSongs.get(2).getTitle());
		assertEquals("good 4 u", sortedSongs.get(3).getTitle());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsBySongLength()}.
	 */
	@Test
	void testSortSongsBySongLength() {

        List<Song> sortedSongs = sc.sortSongsBySongLength();

        assertEquals(3.59, sortedSongs.get(0).getSongLength());
        assertEquals(3.18, sortedSongs.get(1).getSongLength());
        assertEquals(3.14, sortedSongs.get(2).getSongLength());
        assertEquals(2.3, sortedSongs.get(3).getSongLength());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongsById(java.lang.String)}.
	 */
	@Test
	void testFindSongsById() {
//		sc.addSong(s1);
//        sc.addSong(s2);
//        sc.addSong(s3);
//        sc.addSong(s4);

        Song foundSong = sc.findSongsById("003");
        Song notFoundSong = sc.findSongsById("005");
        assertNotNull(foundSong, "Song with ID '003' should be found");
        assertNull(notFoundSong, "No song with id '005' found");
        assertEquals(s3, foundSong, "The song should be 'MONTERO'");
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongByTitle(java.lang.String)}.
	 */
	@Test
	void testFindSongByTitle() {
		sc.addSong(s1);
        sc.addSong(s2);
        sc.addSong(s3);
        sc.addSong(s4);

        Song foundSong = sc.findSongByTitle("good 4 u");
        assertNotNull(foundSong, "Song with the title 'good 4 u' should be found");
        assertEquals(s1, foundSong, "The song should be 'good 4 u'");
	}

}
