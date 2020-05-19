package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMan {

    // 1、创建任务调度器（好比公交调度站）
    public static Scheduler createScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        return scheduler;
    }


    // 2、创建一个任务（好比某一个公交车的出行）
    public static JobDetail createJob() {
        JobBuilder jobBuilder = JobBuilder.newJob(DemoJob.class); // TODO 自定义任务类
        jobBuilder.withIdentity("jobName","myJob");
        JobDetail jobDetail = jobBuilder.build();
        return jobDetail;
    }


    /**
     * 3、创建作业任务时间触发器（类似于公交车出车时间表）
     * cron表达式由七个位置组成，空格分隔
     * 1、Seconds（秒）  0~59
     * 2、Minutes（分）  0~59
     * 3、Hours（小时）  0~23
     * 4、Day of Month（天）1~31,注意有的月份不足31天
     * 5、Month（月） 0~11,或者 JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC
     * 6、Day of Week(周)  1~7,1=SUN或者  SUN,MON,TUE,WEB,THU,FRI,SAT
     * 7、Year（年）1970~2099  可选项
     *示例：
     * 0 0 11 * * ? 每天的11点触发执行一次
     * 0 30 10 1 * ? 每月1号上午10点半触发执行一次
     */
    public static Trigger createTrigger() {
        // 创建时间触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName","myTrigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")).build();
        return cronTrigger;
    }



    /**
     * main函数中开启定时任务
     * @param args
     */
    public static void main(String[] args) throws SchedulerException {
        // 1、创建任务调度器（好比公交调度站）
        Scheduler scheduler = QuartzMan.createScheduler();
        // 2、创建一个任务（好比某一个公交车的出行）
        JobDetail job = QuartzMan.createJob();
        // 3、创建任务的时间触发器（好比这个公交车的出行时间表）
        Trigger trigger = QuartzMan.createTrigger();
        // 4、使用任务调度器根据时间触发器执行我们的任务
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }
}
