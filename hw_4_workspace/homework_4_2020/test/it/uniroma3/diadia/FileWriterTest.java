package it.uniroma3.diadia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileWriterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWriteNonExistentFile() throws IOException{
		try(FileWriter fw = new FileWriter("labirinto.txt")) {
			fw.write("Ciao Mondo!");
		}
	}

	@Test
	public void testAAWriteExistentFile() throws IOException{
		try(FileWriter fw = new FileWriter("./resource/labirinto.txt")) {
			fw.write("Ciao Mondo!");
		}
	}
	
	@Test
	public void testAppendToExistentFile() throws IOException{
		try(FileWriter fw = new FileWriter(new File("./resource/labirinto.txt"), true)) {
			fw.append("Ciao Mondo!");
		}
	}
}
