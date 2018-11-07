package com.fanger.jib.controller;

import com.fanger.jib.annotation.DateFormatter;
import com.fanger.jib.tools.FS;
import com.fanger.jib.tools.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags="测试接口")
public class HelloController {

    @DateFormatter
    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation("测试")
    public String sendMsg() {
        return "this is test msg.";
    }


    @DateFormatter
    @RequestMapping(value = "/models", method = {RequestMethod.POST})
    @ApiOperation("获取文件列表")
    public Model[] getModels(@RequestParam("path") String path) {
        return FS.getAllJavaModels(path);
    }

}
