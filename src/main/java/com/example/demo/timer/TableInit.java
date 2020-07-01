package com.example.demo.timer;

import org.springframework.scheduling.annotation.Scheduled;

public class TableInit {
    /**
     * 项目启动时创建表并初始化数据
     */
    @Scheduled(cron="0 1/5 * * * ?")
    public void getGoodsByShopId() throws Exception {
    }
}
