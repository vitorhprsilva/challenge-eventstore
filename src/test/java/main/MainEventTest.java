package main;

import domain.TextFile;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEventTest extends TestCase {

    MainEvent mainEvent = new MainEvent(new TextFile("testFileEvent"));
    public void testMakeEventAddEvent() throws IOException {
        mainEvent.addEvent("tome_type");
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

    public void testMakeRemoveEvent() throws IOException {
        mainEvent.addEvent("some_type");
        mainEvent.removeEvent("some_type");
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