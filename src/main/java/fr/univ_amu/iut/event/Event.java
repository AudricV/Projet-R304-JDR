package fr.univ_amu.iut.event;

import com.opencsv.bean.*;

// Suppress unused warnings, as setters are not used in the project but used by OpenCSV
@SuppressWarnings("unused")
public class Event {
    @CsvBindByName(required = true, column = "TYPE")
    private EventType eventType;
    @CsvBindByName(required = true, column = "NAME")
    private String name;
    @CsvBindByName(required = true, column = "TEXT EVENT")
    private String textEvent;

    public Event() {
        // No arguments needed in the constructor
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextEvent() {
        return textEvent;
    }

    public void setTextEvent(String textEvent) {
        this.textEvent = textEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", name='" + name + '\'' +
                ", textEvent='" + textEvent + '\'' +
                '}';
    }
}
