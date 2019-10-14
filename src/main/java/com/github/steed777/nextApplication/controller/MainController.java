package com.github.steed777.nextApplication.controller;

import com.github.steed777.nextApplication.domain.Message;
import com.github.steed777.nextApplication.repos.MessagePepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
@Autowired
private MessagePepo messagePepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messagePepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
Message message = new Message();
message.setText(text);
message.setTag(tag);
messagePepo.save(message);
Iterable<Message> messages = messagePepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
     Iterable<Message> messages;
if (filter != null && !filter.isEmpty()){
    messages = messagePepo.findByTag(filter);
}else {
    messages = messagePepo.findAll();
}
model.put("messages", messages);
        return "main";
    }
}