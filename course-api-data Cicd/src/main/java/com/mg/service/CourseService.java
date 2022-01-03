package com.mg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.db.CourseRepository;
import com.mg.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	public List<Course> getAllCourses(String topicId) {
	//findAll method from SpringDataJpa is not suitable as we want courses for a particularId, so WE CREATED a method in sourseRepository
	/**
		List<Course>courses=new ArrayList<>();
		courseRepository.findAll()
		.forEach(courses::add);
		return courses;
		*/
		List<Course>courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}


	public void addCourse(Course course) {
		
		courseRepository.save(course);
		
	}

	public void updateCourse(Course topic) {

		courseRepository.save(topic);
		
	}

	public void deleteCourse(String id) {
		
		courseRepository.deleteById(id);
	}


//	public Course getCourse(String courseId) {
//		return courseRepository.findOne(courseId);
//	}


}
