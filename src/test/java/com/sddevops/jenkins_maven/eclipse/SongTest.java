/**
 * 
 */
package com.sddevops.jenkins_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class SongTest {
	private Song song;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		song = new Song("005", "Nice day!", "Ling", 5.66);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		song = null;
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.Song#Song(java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	void testSong() {
		// test song constructor
		Song song = new Song("005", "Nice day!", "Ling", 5.66);
		assertNotNull(song);
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.Song#getId()}.
	 */
	@Test
	void testGetId() {
		assertEquals("005", song.getId());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.Song#setId(java.lang.String)}.
	 */
	@Test
	void testSetId() {
		song.setId("006");
		assertEquals("006", song.getId());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.Song#getTitle()}.
	 */
	@Test
	void testGetTitle() {
		assertEquals("Nice day!", song.getTitle());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.Song#setTitle(java.lang.String)}.
	 */
	@Test
	void testSetTitle() {
		song.setTitle("Caring");
		assertEquals("Caring", song.getTitle());
	}



}
