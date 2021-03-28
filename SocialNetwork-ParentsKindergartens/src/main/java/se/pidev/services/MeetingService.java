package se.pidev.services;

import java.util.List;

import se.pidev.entities.Meeting;

public interface MeetingService {
	
	List<Meeting> retrieveAllMeetings();
	Meeting addMeeting(Meeting m);
	void deleteMeeting(String id);
	Meeting retrieveMeeting(String id);

}
