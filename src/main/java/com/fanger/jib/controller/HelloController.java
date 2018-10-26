package com.fanger.jib.controller;

import com.fanger.jib.tools.FS;
import com.fanger.jib.tools.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HelloController {

    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public String sendMsg() {
        return "this is test msg.";
    }


    @RequestMapping(value = "/models", method = {RequestMethod.POST})
    public Model[] getModels(@RequestParam("path") String path) {
        return FS.getAllJavaModels(path);
    }

}
