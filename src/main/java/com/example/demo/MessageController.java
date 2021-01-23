package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    private int count = 0;
    ArrayList<Message> dataArr = new ArrayList<>();
    Data data = new Data();

    @PostMapping("/messages")
    void postMessage(@RequestBody Message message) {
        if (message.getText().equals("Hello")) {
            count += 1;
            Message m = new Message(message.getText(), count);
            dataArr.add(m);
            data.setData(dataArr);
        }
    }

    @GetMapping("/messages")
    Data getMessages() {
        return data;
    }

}
