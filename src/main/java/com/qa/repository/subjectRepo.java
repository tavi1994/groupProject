package com.qa.repository;

import com.qa.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface subjectRepo extends JpaRepository<Subject, Long> {
}
