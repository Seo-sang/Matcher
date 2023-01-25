package project.backend.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class Message {
    String chatId;
    String text;
    LocalDate date;
    LocalTime time;

    public Message(String chatId, String text, LocalDate date, LocalTime time) {
        this.chatId = chatId;
        this.text = text;
        this.date = date;
        this.time = time;
    }
}
