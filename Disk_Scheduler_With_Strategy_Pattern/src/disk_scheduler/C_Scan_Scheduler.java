package disk_scheduler;

import java.util.Collections;
import java.util.LinkedList;

public class C_Scan_Scheduler implements Scheduler{
    @Override
    public  String schedule(LinkedList<Integer> requestQueue, int headCurrentPosition) {
        Collections.sort(requestQueue);
        String sequence = headCurrentPosition + "";
        int seekTime = 0;
        int predecessorIndex = getSuccessorIndex(requestQueue, headCurrentPosition);
        for (; predecessorIndex >= 0; predecessorIndex--) {
            seekTime += Math.abs(headCurrentPosition - requestQueue.get(predecessorIndex));
            headCurrentPosition = requestQueue.remove(predecessorIndex);
            sequence += " - " + headCurrentPosition;
        }
        /* overhead of reaching the bound 0  and back to the bound 200*/
        seekTime += Math.abs(headCurrentPosition - 0) + 200;
        sequence += " - 0 - 200";
        headCurrentPosition = 200;
        while(!requestQueue.isEmpty()){
            seekTime += Math.abs(headCurrentPosition - requestQueue.peekLast());
            headCurrentPosition = requestQueue.pollLast();
            sequence += " - " + headCurrentPosition;
        }
        SeekTimeAndSequence myResult = new SeekTimeAndSequence(seekTime, sequence);
        String algorithmResult  = "C_Scan Sequence is: " + myResult.Sequence 
                    + "\nC_Scab Seek Time is: " + myResult.seekTime;
        return algorithmResult;
    }
    private static int getSuccessorIndex(LinkedList<Integer> requestQueue, int headCurrentPosition) {
        int predecessorIndex = 0, i = 0;
        int predecessorValue = Integer.MIN_VALUE;
        for (int request : requestQueue) {
            if (request > predecessorValue && request < headCurrentPosition) {
                
                    predecessorValue = request;
                    predecessorIndex = i;
            }                   
            else
                break;            
            i++;
        }
        return predecessorIndex;
    }
}
