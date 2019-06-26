package cn.jiuyoung;

import java.util.Arrays;

/**
 * SchedulingProblem
 */
public class SchedulingProblem {

    public static void main(String[] args) {
        Job[] jobs = {
            new Job("j1", 15),
            new Job("j2", 8),
            new Job("j3", 3),
            new Job("j4", 10)
        };
        double avertime = schedule(jobs);
        System.out.println("最小平均完成时间为：" + avertime);
        System.out.println("调度顺序为：");
        for(Job job : jobs) {
            System.out.print(job.name + "  ");
        }
    }

    public static double schedule(Job[] jobs) {
        Job[] jobnew = new Job[jobs.length];
        Arrays.sort(jobs);
        int alltimes = 0;
        for(int i = 0; i < jobs.length; i++) {
            jobnew[i] = jobs[i];
            for(int j = i; j >=0; j--) {
                alltimes += jobs[j].time;
            }
        }
        jobs = jobnew;
        return alltimes / jobs.length;
    }


    static class Job implements Comparable<Job>{
        String name;
        int time;

        public Job(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Job o) {
            int x = this.time - o.time;
            return x < 0 ? -1 : (x == 0 ? 0 : 1);
        }
    }
}