package com.example.mall.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @author Ming
 * @date 2021/12/9 16:37
 */
@Component
public class SpringTaskTest {

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每1分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
/*    @Scheduled(cron = "0 0/1 * ? * ?")
    private void cancelTimeOutOrder() {
        // TODO: 2019/5/3 此处应调用取消订单的方法，具体查看mall项目源码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }*/
}
