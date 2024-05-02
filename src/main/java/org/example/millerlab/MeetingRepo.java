package org.example.millerlab;

import org.example.millerlab.dto.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Long> {
    List<Meeting> findByInvestorContainsIgnoreCase(String investor);

}
