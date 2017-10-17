package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {

	private UUID CourseID;
	private String CourseName;
	private int GradePoint;

	public Course(UUID courseID, String courseName, int gradePoints, eMajor major) {
		// TODO Auto-generated constructor stub
		this.CourseID = CourseID;
		this.CourseName = CourseName;
		this.GradePoint = GradePoint;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getGradePoint() {
		return GradePoint;
	}

	public void setGradePoint(int gradePoint) {
		GradePoint = gradePoint;
	}

}
