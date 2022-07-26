package main;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventStore;
import java.util.*;


public class MainEvent {
    private final EventStore newEvent;
    Scanner read;

    public MainEvent( EventStore newEvent )
    {
        this.newEvent = newEvent;
        read = new Scanner(System.in);
    }

    public void addEvent(String typeEvent) {
        Event event = new Event(typeEvent, System.currentTimeMillis(), "event");
        this.newEvent.insert(event);
    }

    public void removeEvent(String typeEvent) {
        this.newEvent.removeAll(typeEvent);
    }

    public void makeEvent(int option) {
        String typeEvent;
        System.out.print("Digite o tipo: ");
        typeEvent = read.next();
        switch (option) {
            case 1:
                addEvent(typeEvent);
                break;
            case 2:
                removeEvent(typeEvent);
                break;
            case 3:
                break;
            default:
                System.out.println("Não foi possivel identificar a opção, tente novamente");
                break;
        }
    }
}
