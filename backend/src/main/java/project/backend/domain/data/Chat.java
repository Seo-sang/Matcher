package project.backend.domain.data;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Getter
public class Chat {
    String chatId;
    LocalDate date;
    LocalTime time;
    ArrayList<Message> messages;

    public Chat(String chatId, LocalDate date, LocalTime time, ArrayList<Message> messages) {
        this.chatId = chatId;
        this.date = date;
        this.time = time;
        this.messages = messages;
    }
}
