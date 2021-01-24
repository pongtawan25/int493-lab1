package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageController {
    public HashMap<String, Message> messages = new HashMap<>();
    Data data = new Data();

    @GetMapping("/messages")
    public Data getMessages() {
        data.setData(new ArrayList<>(messages.values()));
        return data;
    }

    @PostMapping("/messages")
    public void postMessage(@RequestBody Message message) {
        if (!messages.containsKey(message.getText())) {
            message.setCount(1);
        } else {
            int count = messages.get(message.getText()).getCount();
            message.setCount(count + 1);
        }
        messages.put(message.getText(), message);
    }
}
