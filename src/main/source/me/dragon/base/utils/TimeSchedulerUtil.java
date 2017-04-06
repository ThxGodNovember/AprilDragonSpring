package me.dragon.base.utils;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by dragon on 4/6/2017.
 */
@Component
public class TimeSchedulerUtil {
    private final Logger logger = Logger.getLogger(this.getClass());

    // 每分钟执行一次
    // @Scheduled(fixedRate=5000)
    @Scheduled(cron="0 0/1 * * * ?")
    public void statusCheck() {
        logger.info("每分钟执行一次。");
    }

}