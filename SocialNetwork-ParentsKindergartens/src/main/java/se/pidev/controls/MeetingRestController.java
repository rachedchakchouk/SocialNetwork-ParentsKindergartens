package se.pidev.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.pidev.entities.Meeting;
import se.pidev.services.MeetingService;

@RestController
public class MeetingRestController {
	
	@Autowired
	MeetingService meetingService;
	
	// http://localhost:8083/SpringMVC/servlet/retrieve-all-meetings
	@GetMapping("/retrieve-all-meetings")
	@ResponseBody
	public List<Meeting> getMeetings() {
	List<Meeting> list = meetingService.retrieveAllMeetings();
	return list;
	}
	
	// http://localhost:8083/SpringMVC/servlet/retrieve-meeting/{meeting-id}
	@GetMapping("/retrieve-meeting/{meeting-id}")
	@ResponseBody
	public Meeting retrieveMeeting(@PathVariable("meeting-id") String meetingId) {
	return meetingService.retrieveMeeting(meetingId);
	}

	// http://localhost:8083/SpringMVC/servlet/add-meeting
	@PostMapping("/add-meeting")
	@ResponseBody
	public Meeting addMeeting(@RequestBody Meeting m) {
	Meeting meeting = meetingService.addMeeting(m);
	return meeting;
	}
	
	// http://localhost:8083/SpringMVC/servlet/remove-meeting/{meeting-id}
	@DeleteMapping("/remove-meeting/{meeting-id}")
	@ResponseBody
	public void removeMeeting(@PathVariable("meeting-id") String meetingId) {
		meetingService.deleteMeeting(meetingId);
	}

	// http://localhost:8083/SpringMVC/servlet/modify-meeting
	@PutMapping("/modify-meeting")
	@ResponseBody
	public Meeting modifyMeeting(@RequestBody Meeting meeting) {
	return meetingService.addMeeting(meeting);
	}

}
