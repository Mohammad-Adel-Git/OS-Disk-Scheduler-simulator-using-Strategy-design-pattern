
package disk_scheduler;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LinkedList<Integer> requestQueue = new LinkedList<>();
        System.out.print("Enter Request Queue: ");
        /* Sequence example: 38 180 130 10 50 15 190 90 150 */
        String sequence = cin.nextLine();
        System.out.print("Enter the initial head start cylinder: ");
        int initialHead = cin.nextInt();
//        System.out.println("");
        String[] splitedSequence = sequence.split(" ");
        for (String str : splitedSequence) {
            requestQueue.add(Integer.parseInt(str));
        }
        
        Disk_Scheduler diskScheduler = new Disk_Scheduler();
        diskScheduler.setScheduler(new FCFS_Scheduler());
        String schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new SSTF_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new Scan_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new C_Scan_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new Look_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new C_Look_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        diskScheduler.setScheduler(new Optimized_Scheduler());
        schedulerPerformanceInfo = diskScheduler.getScheduleSequence((LinkedList)requestQueue.clone(), initialHead);
        System.out.println(schedulerPerformanceInfo);
        

        
    }
}
