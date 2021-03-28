package se.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.pidev.entities.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long>{

}
