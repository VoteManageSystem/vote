package com.schedule;

import java.util.Date;
/**
 * 
 * @ClassName: Job
 * @Description: 定时业务逻辑类
 * @author Mobile Web Group-Administrator
 * @date 2016年6月12日 上午11:25:35
 *
 */
public class ExpireJobTask {
    /** Logger */
    //private static final Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
 
    /**
     * 业务逻辑处理
     */
    public void doBiz() {
        System.out.println("你好"+new Date());
    }
}  