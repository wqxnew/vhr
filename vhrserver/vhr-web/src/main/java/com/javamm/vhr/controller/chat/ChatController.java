package com.javamm.vhr.controller.chat;

import com.javamm.vhr.model.Hr;
import com.javamm.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHrWithoutHrSelf(){
        return hrService.getAllHrWithoutHrSelf();
    }
}
