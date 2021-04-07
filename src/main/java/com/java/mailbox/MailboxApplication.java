package com.java.mailbox;

import com.java.mailbox.model.Message;
import com.java.mailbox.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MailboxApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailboxApplication.class, args);
    }
    
    @Autowired
    private MessageRepository repository;

    @GetMapping({"/message"})
    public ResponseEntity<List<Message>> getAllMessage() {
        List<Message> messages = this.repository.findAll();
        return ResponseEntity.ok(messages);
    }

    @PostMapping({"/message"})
    public ResponseEntity<Message> addMessage() {
        Message message = new Message();
        message.setContent("Wartość");
        Message saved = (Message)this.repository.save(message);
        return ResponseEntity.ok(saved);
    }

    @PutMapping({"/message/{id}"})
    public ResponseEntity<Message> updateMessage(@PathVariable Long id) {
        Message messageById = (Message)this.repository.getOne(id);
        messageById.setContent("Wartość 2");
        Message saved = (Message)this.repository.save(messageById);
        return ResponseEntity.ok(saved);
    }

    @GetMapping({"/message/random/{count}"})
    public ResponseEntity<List<Message>> getRandomMessage(@PathVariable int count) {
        Random rand = new Random();
        List<Message> randomMessages = new ArrayList();
        List<Message> messages = this.repository.findAll();

        for(int i = 0; i < count; ++i) {
            int randomIndex = rand.nextInt(messages.size());
            Message randomElement = (Message)messages.get(randomIndex);
            randomMessages.add(randomElement);
        }

        return ResponseEntity.ok(randomMessages);
    }

}
