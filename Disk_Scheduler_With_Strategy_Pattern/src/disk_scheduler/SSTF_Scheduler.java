package disk_scheduler;

import java.util.LinkedList;

public class SSTF_Scheduler implements Scheduler{
    @Override
    public  String schedule(LinkedList<Integer> requestQueue, int headCurrentPosition) {
        String sequence = headCurrentPosition + "";
        int seekTime = 0;
        while (!requestQueue.isEmpty()) {
            int shortestSeekTimeIndex = getShortestSeekTimeIndex(requestQueue, headCurrentPosition);
            seekTime += Math.abs(headCurrentPosition - requestQueue.get(shortestSeekTimeIndex));
            headCurrentPosition = requestQueue.remove(shortestSeekTimeIndex);
            sequence += " - " + headCurrentPosition;
        }
        SeekTimeAndSequence myResult = new SeekTimeAndSequence(seekTime, sequence);
        String algorithmResult  = "SSTF Sequence is: " + myResult.Sequence
                    + "\nSSTF Seek Time is: " + myResult.seekTime;
        return algorithmResult;
    }

    private static int getShortestSeekTimeIndex(LinkedList<Integer> requestQueue,
            int headCurrentPosition) {
        int nearestRequestIndex = 0, i = 0;
        int minSeekTime = Integer.MAX_VALUE;
        for (int request : requestQueue) {
            if (Math.abs(headCurrentPosition - request) < minSeekTime) {
                minSeekTime = Math.abs(headCurrentPosition - request);
                nearestRequestIndex = i;
            }
            i++;
        }
        return nearestRequestIndex;
    }
}
