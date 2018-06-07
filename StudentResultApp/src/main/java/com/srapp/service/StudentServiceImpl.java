package com.srapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srapp.bo.StudentBO;
import com.srapp.dao.StudentDAO;
import com.srapp.dto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;

	@Override
	public List<StudentDTO> getTopScoreStudent(StudentDTO studentDTO) {
		List<StudentDTO> lsdto = new ArrayList<>();
		StudentBO bo = new StudentBO();
		bo.setCity(studentDTO.getCity());
		bo.setLowerAge(studentDTO.getLowerAge());
		bo.setUpperAge(studentDTO.getUpperAge());
		List<StudentBO> lsbo = dao.getStudentsResults(bo);
		Collections.sort(lsbo, new Comparator<StudentBO>() {
			@Override
			public int compare(StudentBO s1, StudentBO s2) {
				return Integer.compare(s2.getMarks(), s1.getMarks());
			}
		});
		for (StudentBO sbo : lsbo) {
			if (lsdto.size() == 5) {
				break;
			}
			StudentDTO dto = new StudentDTO();
			dto.setId(sbo.getId());
			dto.setName(sbo.getName());
			dto.setAge(sbo.getAge());
			dto.setMarks(sbo.getMarks());
			dto.setCity(sbo.getCity());

			lsdto.add(dto);

		}

		return lsdto;
	}

}
