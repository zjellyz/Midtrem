package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	private static Date Date(int year, int month, int day) {

		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		return date.getTime();

	}

	private static ArrayList<Course> course = new ArrayList<Course>();
	private static ArrayList<Semester> semester = new ArrayList<Semester>();
	private static ArrayList<Section> section = new ArrayList<Section>();
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrollmentlist = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException {
		// set 3 course
		Course c1 = new Course(UUID.randomUUID(), "PHYSICS", 4, eMajor.PHYSICS);
		Course c2 = new Course(UUID.randomUUID(), "CHEMISTRY", 4, eMajor.CHEM);
		Course c3 = new Course(UUID.randomUUID(), "COMPUTE SCIENCE", 3, eMajor.COMPSI);
		course.addAll(Arrays.asList(c1, c2, c3));

		// set 2 semesters
		Semester fall = new Semester(UUID.randomUUID(), Date(2017, 8, 28), Date(2017, 12, 10));
		Semester spring = new Semester(UUID.randomUUID(), Date(2017, 2, 26), Date(2017, 5, 28));
		semester.addAll(Arrays.asList(fall, spring));

		// set 3 sections for each semester
		ArrayList<Section> alist = new ArrayList<Section>(3);
		Section s1 = new Section(c1.getCourseID(), spring.getSemesterID(), 102, null);
		Section s2 = new Section(c2.getCourseID(), spring.getSemesterID(), 202, null);
		Section s3 = new Section(c3.getCourseID(), spring.getSemesterID(), 302, null);
		alist.addAll(Arrays.asList(s1, s2, s3));

		Section s4 = new Section(c1.getCourseID(), fall.getSemesterID(), 102, null);
		Section s5 = new Section(c2.getCourseID(), fall.getSemesterID(), 202, null);
		Section s6 = new Section(c3.getCourseID(), fall.getSemesterID(), 302, null);
		alist.addAll(Arrays.asList(s4, s5, s6));

		section.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6));

		// set 10 students
		Student st1 = new Student("name1", "name1", "name1", Date(2017, 1, 1), eMajor.COMPSI, "Address1",
				"111-111-1111", "email 1");
		Student st2 = new Student("name2", "name2", "name2", Date(2017, 2, 2), eMajor.COMPSI, "Address2",
				"222-222-2222", "email 2");
		Student st3 = new Student("name3", "name3", "name3", Date(2017, 3, 3), eMajor.COMPSI, "Address3",
				"333-333-3333", "email 3");
		Student st4 = new Student("name4", "name4", "name4", Date(2017, 4, 4), eMajor.COMPSI, "Address4",
				"(444-444-4444", "email 4");
		Student st5 = new Student("name5", "name5", "name5", Date(2017, 5, 5), eMajor.CHEM, "Address5", "555-555-5555",
				"email 5");
		Student st6 = new Student("name6", "name6", "name6", Date(2017, 6, 6), eMajor.CHEM, "Address6", "666-666-6666",
				"email 6");
		Student st7 = new Student("name7", "name7", "name7", Date(2017, 7, 7), eMajor.PHYSICS, "Address7",
				"777-777-7777", "email 7");
		Student st8 = new Student("name8", "name8", "name8", Date(2017, 8, 8), eMajor.PHYSICS, "Address8",
				"888-888-8888", "email 8");
		Student st9 = new Student("name9", "name9", "name9", Date(2017, 9, 9), eMajor.PHYSICS, "Address9",
				"999-999-9999", "email 9");
		Student st10 = new Student("name10", "name10", "name10", Date(2017, 10, 10), eMajor.PHYSICS, "Address10",
				"101-010-1010", "email 10");
		students.addAll(Arrays.asList(st1, st2, st3, st4, st5, st6, st7, st8, st9, st10));

		// enroll student
		for (Student student : students) {
			for (Section section : section) {
				enrollmentlist.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}

		// set grade
		for (Enrollment enrollment : enrollmentlist) {
			if (enrollment.getStudentID() == students.get(0).getStudentID()) {
				enrollment.setGrade(81);
			} else if (enrollment.getStudentID() == students.get(1).getStudentID()) {
				enrollment.setGrade(94);
			} else if (enrollment.getStudentID() == students.get(2).getStudentID()) {
				enrollment.setGrade(91);
			} else if (enrollment.getStudentID() == students.get(3).getStudentID()) {
				enrollment.setGrade(84);
			} else if (enrollment.getStudentID() == students.get(4).getStudentID()) {
				enrollment.setGrade(88);
			} else if (enrollment.getStudentID() == students.get(5).getStudentID()) {
				enrollment.setGrade(75);
			} else if (enrollment.getStudentID() == students.get(6).getStudentID()) {
				enrollment.setGrade(73);
			} else if (enrollment.getStudentID() == students.get(7).getStudentID()) {
				enrollment.setGrade(55);
			} else if (enrollment.getStudentID() == students.get(8).getStudentID()) {
				enrollment.setGrade(68);
			} else if (enrollment.getStudentID() == students.get(9).getStudentID()) {
				enrollment.setGrade(64);
			}
		}
	}

	// get GPA (made up scalar)
	public double getGPA(UUID id) {
		double GPA = 0.00;
		for (Enrollment enrollment : enrollmentlist) {
			if (enrollment.getStudentID() == id) {
				if (enrollment.getGrade() >= 93) {
					GPA = 4.00;
				} else if (enrollment.getGrade() >= 90 && enrollment.getGrade() < 93) {
					GPA = 3.7;
				} else if (enrollment.getGrade() >= 87 && enrollment.getGrade() < 90) {
					GPA = 3.3;
				} else if (enrollment.getGrade() >= 83 && enrollment.getGrade() < 87) {
					GPA = 3.0;
				} else if (enrollment.getGrade() >= 80 && enrollment.getGrade() < 83) {
					GPA = 2.7;
				} else if (enrollment.getGrade() >= 77 && enrollment.getGrade() < 80) {
					GPA = 2.3;
				} else if (enrollment.getGrade() >= 73 && enrollment.getGrade() < 77) {
					GPA = 2.0;
				} else if (enrollment.getGrade() >= 70 && enrollment.getGrade() < 73) {
					GPA = 1.7;
				} else if (enrollment.getGrade() >= 67 && enrollment.getGrade() < 70) {
					GPA = 1.5;
				} else if (enrollment.getGrade() >= 63 && enrollment.getGrade() < 67) {
					GPA = 1.3;
				} else if (enrollment.getGrade() >= 60 && enrollment.getGrade() < 63) {
					GPA = 1.0;
				} else if (enrollment.getGrade() < 60) {
					GPA = 0.0;
				}
			}
		}

		return GPA;
	}

	@Test
	public void testStudentGPA() {
		// test GPA for Student 1
		assertEquals(getGPA(enrollmentlist.get(0).getStudentID()), 2.7, 0.1);
		// test GPA for Student 2
		assertEquals(getGPA(enrollmentlist.get(1).getStudentID()), 4.0, 0.1);
		// test GPA for Student 3
		assertEquals(getGPA(enrollmentlist.get(2).getStudentID()), 3.7, 0.1);
		// test GPA for Student 4
		assertEquals(getGPA(enrollmentlist.get(3).getStudentID()), 3.0, 0.1);
		// test GPA for Student 5
		assertEquals(getGPA(enrollmentlist.get(4).getStudentID()), 3.3, 0.1);
		// test GPA for Student 6
		assertEquals(getGPA(enrollmentlist.get(5).getStudentID()), 2.0, 0.1);
		// test GPA for Student 7
		assertEquals(getGPA(enrollmentlist.get(6).getStudentID()), 2.0, 0.1);
		// test GPA for Student 8
		assertEquals(getGPA(enrollmentlist.get(7).getStudentID()), 0.0, 0.1);
		// test GPA for Student 9
		assertEquals(getGPA(enrollmentlist.get(8).getStudentID()), 1.5, 0.1);
		// test GPA for Student 10
		assertEquals(getGPA(enrollmentlist.get(9).getStudentID()), 1.3, 0.1);
	}

	@Test
	public void testCourseAverage() {
		double average = 87.75;
		double acual = (enrollmentlist.get(0).getGrade() + enrollmentlist.get(1).getGrade()
				+ enrollmentlist.get(2).getGrade() + enrollmentlist.get(3).getGrade()) / 4;
		assertEquals(average, acual, 0.01);

		double average2 = 81.5;
		double acual2 = (enrollmentlist.get(4).getGrade() + enrollmentlist.get(5).getGrade()) / 2;
		assertEquals(average2, acual2, 0.1);

		double average3 = 65.0;
		double acual3 = (enrollmentlist.get(6).getGrade() + enrollmentlist.get(7).getGrade()
				+ enrollmentlist.get(8).getGrade() + enrollmentlist.get(9).getGrade()) / 4;
		assertEquals(average3, acual3, 0.1);
	}
}