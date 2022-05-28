package disk_scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Scan_Scheduler implements Scheduler{
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
        /* overhead of reaching the bound 0 */
        seekTime += Math.abs(headCurrentPosition - 0);
        headCurrentPosition = 0;
        sequence += " - " + headCurrentPosition;
        while(!requestQueue.isEmpty()){
            seekTime += Math.abs(headCurrentPosition - requestQueue.peek());
            headCurrentPosition = requestQueue.poll();
            sequence += " - " + headCurrentPosition;
        }
        SeekTimeAndSequence myResult = new SeekTimeAndSequence(seekTime, sequence);
        String algorithmResult  = "Scan Sequence is: " + myResult.Sequence 
                    + "\nScan Seek Time is: " + myResult.seekTime;
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

class reqeustComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer request1, Integer request2) {
        return request1 - request2;
    }
}
