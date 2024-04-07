package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test (expected=FileNotFoundException.class)
	public void testOpenNonExistentFile() throws IOException {
		try(FileReader fr = new FileReader("labirinto.txt")) {
			assertEquals(-1, fr.read());
		}
	}
	
	@Test
	public void testOpenExistentFile() throws IOException {
		char[] cbuf;
		try(FileReader fr = new FileReader("./resource/labirinto.txt")) {
			cbuf = new char[1024];
			char[] ciao ={ 'C', 'i', 'a', 'o' }; 
			fr.read(cbuf);
			assertEquals((new String(ciao)).trim(), (new String(cbuf)).trim());
		}
	}
}