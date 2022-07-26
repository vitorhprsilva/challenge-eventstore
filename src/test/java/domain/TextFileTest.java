package domain;

import junit.framework.TestCase;
import net.intelie.challenges.Event;

import java.io.*;
import java.util.*;

public class TextFileTest extends TestCase {

    TextFile textFile = new TextFile("testFileEvent");

    public void testInsert() throws IOException {
        Event eventTest = new Event("some_type", 13,"some_content");
        textFile.insert(eventTest);
        List<String> listWorlds = new ArrayList<>();
        FileReader file = new FileReader("testFileEvent.txt");
        BufferedReader readFile = new BufferedReader(file);
        String line = readFile.readLine();
        while (line != null) {
            if(line.contains("some_type")) {
                listWorlds.add(line);
            }
            line = readFile.readLine();
        }

        assertNotNull(listWorlds);
    }

    public void testRemoveAll() throws IOException {
        Event eventTest = new Event("some_type", 13,"some_content");
        textFile.insert(eventTest);
        textFile.removeAll("some_type");
        List<String> listWorlds = new ArrayList<>();
        FileReader file = new FileReader("testFileEvent.txt");
        BufferedReader readFile = new BufferedReader(file);
        String line = readFile.readLine();
        while (line != null) {
            if(line.contains("some_type")) {
                listWorlds.add(line);
            }
            line = readFile.readLine();
        }

        assertTrue(listWorlds.isEmpty());

    }
}