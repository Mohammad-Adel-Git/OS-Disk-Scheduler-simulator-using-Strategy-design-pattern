package disk_scheduler;

import java.util.LinkedList;

interface Scheduler {

    public String schedule(LinkedList<Integer> requestQueue, int headCurrentPosition);
}
