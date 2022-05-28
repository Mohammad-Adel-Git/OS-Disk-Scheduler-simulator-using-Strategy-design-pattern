
package disk_scheduler;

import java.util.LinkedList;

public class FCFS_Scheduler implements Scheduler{
    @Override
    public String schedule(LinkedList<Integer> requestQueue, int headCurrentPosition) {

        String sequence = headCurrentPosition + "";
        int seekTime = 0;
        while (!requestQueue.isEmpty()) {
            seekTime += Math.abs(headCurrentPosition - requestQueue.peek());
            headCurrentPosition = requestQueue.poll();
            sequence += " - " + headCurrentPosition ;
        }
        SeekTimeAndSequence myResult = new SeekTimeAndSequence(seekTime, sequence);
        String algorithmResult = "FCFS Sequence is: " + myResult.Sequence
                    + "\nFCFS Seek Time is: " + myResult.seekTime;
        return algorithmResult;
    }
}
