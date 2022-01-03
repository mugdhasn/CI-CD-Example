package com.mg.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mg.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

//	Course findOne(String courseId);
	
	//there are pre defined methods in this CrudRepository
	public List<Course> findByTopicId(String topicId);
	
	

}
