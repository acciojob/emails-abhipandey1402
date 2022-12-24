package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if(calendar.size()==0)return 0;
        Collections.sort(calendar,new Comparator<Meeting>()
        {
            public int compare(Meeting a,Meeting b)// sorting according to the end time of meetings
            {
                return a.getEndTime().compareTo(b.getEndTime());
            }
        });

        LocalTime limit=calendar.get(0).getEndTime();// storing the end time of first meeting for checking whether the second
        int count=1;             // meeting starts after the first ends or not
        for(int i =1 ; i < calendar.size() ; i++)
        {
            if(calendar.get(i).getStartTime() .compareTo(limit) >0)// if the start time of next meeting is greater than the end time of
            {                         // the previous meeting then the next meeting can be done and increase count
                count++;
                limit=calendar.get(i).getEndTime(); // when the start of the next meeting is greater then the limit will be the
            }                                                 //end time of the next meeting
        }
        return count;
    }
}
