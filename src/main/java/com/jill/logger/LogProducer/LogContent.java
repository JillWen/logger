package com.jill.logger.LogProducer;

/**
 *  抽象日志内容接口
 */
public interface LogContent {
    /**
     * 返回日志内容串
     * @return 模拟日志记录内容
     */
    String getContent();
}
