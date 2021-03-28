package se.pidev.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.pidev.entities.Meeting;
import se.pidev.repositories.MeetingRepository;
import se.pidev.services.MeetingServiceImpl;

@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	MeetingRepository meetingRepository;
	
	private static final Logger L = LogManager.getLogger(MeetingServiceImpl.class);
	
	@Override
	public List<Meeting> retrieveAllMeetings() {
		List<Meeting> meetings = (List<Meeting>) meetingRepository.findAll();
		for (Meeting meeting : meetings) {
			L.info("meeting +++ : " + meeting);
		}
		return meetings;
	}
	
	@Override
	public Meeting addMeeting(Meeting m) {
		return meetingRepository.save(m);
	}
	
	@Override
	public void deleteMeeting(String id) {
		meetingRepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Meeting retrieveMeeting(String id) {
		return meetingRepository.findById(Long.parseLong(id)).get();
	}

}
