package com.jill.logger.LogProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  不断产生日志的线程类
 */
@Component
public class LogRunner implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(LogRunner.class);

    /**
     *  运行次数（日志条数）
     */
    private int runTime = 20;

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    volatile boolean keepRunning = true;


    @Autowired
    LogContent logContent;

    @Override
    public void run() {
        int count = 0;
        while (keepRunning){
            count++;
            logger.info(logContent.getContent());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == runTime){
                keepRunning = false;
            }
        }
    }

}
