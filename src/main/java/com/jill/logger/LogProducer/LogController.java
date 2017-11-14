package com.jill.logger.LogProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  输出日志信息的Controller
 */
@RestController
@RequestMapping(value = "/logger")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    LogRunner runner;

    @RequestMapping(value = "/output", method = RequestMethod.GET)
    public void writeLog(){
        runner.setRunTime(10);
        runner.run();
    }
}
