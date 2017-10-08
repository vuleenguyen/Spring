package com.lee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1,10));
        meetings.add(new Meeting(2,6));
        meetings.add(new Meeting(3,5));
        meetings.add(new Meeting(7,9));

        List<Meeting> resultMeeting = mergeRanges(meetings);
        for(Meeting result: resultMeeting) {
            System.out.println(result.toString());
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // don't want to destroy input
        List<Meeting> sortedMeeting = new ArrayList<>();
        for(Meeting meeting : meetings) {
            sortedMeeting.add(new Meeting(meeting.getStartTime(), meeting.getEndTime()));
        }


        Collections.sort(sortedMeeting, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });

        List<Meeting> result = new ArrayList<>();
        result.add(sortedMeeting.get(0));

        for(Meeting currentMeeting : sortedMeeting) {
            Meeting lastMeeting = result.get(result.size() - 1);

            if (lastMeeting.getEndTime() >= currentMeeting.getStartTime()) {
                lastMeeting.setEndTime(Math.max(lastMeeting.getEndTime(), currentMeeting.getEndTime()));
            } else {
                result.add(currentMeeting);
            }
        }

        return result;
    }

}
