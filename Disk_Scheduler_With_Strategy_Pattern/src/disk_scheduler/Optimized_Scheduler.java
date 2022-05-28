package disk_scheduler;

import java.util.Collections;
import java.util.LinkedList;
/*
this algorithm has 3 basic operation to do
1- sort the input queue in ascending order
2- make the head initialy at trak 0
3- service the requests sequentaly on his way until he reaches the last request
*/
public class Optimized_Scheduler implements Scheduler{
    @Override
    public  String schedule(LinkedList<Integer> requestQueue, int headCurrentPosition) {
        headCurrentPosition = 0;
        Collections.sort(requestQueue);
        String sequence = headCurrentPosition +"";
        int seekTime = 0;
        while(!requestQueue.isEmpty()){
            seekTime += Math.abs(headCurrentPosition - requestQueue.peek());
            headCurrentPosition = requestQueue.poll();
            sequence += " - " + headCurrentPosition ;
        }
        SeekTimeAndSequence myResult = new SeekTimeAndSequence(seekTime, sequence);
        String algorithmResult  = "Optimized Algorithm Sequence is: " + myResult.Sequence 
                    + "\nOptimized Algorithm Seek Time is: " + myResult.seekTime;
        return algorithmResult;        
    }
}
