package domain;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;
import net.intelie.challenges.EventStore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile implements EventStore {

    private final String nameFile;

    public TextFile(String nameFile) {
        this.nameFile = nameFile+ ".txt";
        new File(this.nameFile);
    }
    @Override
    public void insert(Event event) {
        try {
            FileWriter myFileWrite = new FileWriter(this.nameFile, true);
            myFileWrite.write(event.content()+" ");
            myFileWrite.write(event.type()+" ");
            myFileWrite.write((event.timestamp())+"\n");
            myFileWrite.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll(String type) {
        List<String> listWorlds = new ArrayList<>();
        try {
            FileReader file = new FileReader(this.nameFile);
            BufferedReader readFile = new BufferedReader(file);
            String line = readFile.readLine();
            while (line != null) {
                if(!line.contains(type)) {
                    listWorlds.add(line);
                }
                line = readFile.readLine();
            }
            FileWriter fileWriter = new FileWriter(this.nameFile);

            fileWriter.write("");
            fileWriter.close();
            FileWriter newFileWriter = new FileWriter(this.nameFile, true);
            for(String lineToAdd : listWorlds) {
                newFileWriter.write(lineToAdd+"\n");
            }
            newFileWriter.close();
            file.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public EventIterator query(String type, long startTime, long endTime) {
        return null;
    }
}
