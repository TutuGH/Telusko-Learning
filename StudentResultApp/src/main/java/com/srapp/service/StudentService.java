package com.srapp.service;

import java.util.List;

import com.srapp.dto.StudentDTO;

public interface StudentService {
	List<StudentDTO> getTopScoreStudent(StudentDTO studentDTO);
}
