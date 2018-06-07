package com.srapp.dao;

import java.util.List;

import com.srapp.bo.StudentBO;
import com.srapp.command.StudentCommand;

public interface StudentDAO {
	public List<StudentBO> getStudentsResults(StudentBO studentBO);
}
