package disk_scheduler;

import java.util.LinkedList;
import java.util.Scanner;

public class Disk_Scheduler {
    private Scheduler scheduler;
    public void setScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }
    public String getScheduleSequence (LinkedList<Integer> requestQueue, int headCurrentPosition){
        return scheduler.schedule(requestQueue, headCurrentPosition);
    }
}

class SeekTimeAndSequence {

    public int seekTime;
    public String Sequence;

    public SeekTimeAndSequence(int seekTime, String Sequence) {
        this.seekTime = seekTime;
        this.Sequence = Sequence;
    }
}
