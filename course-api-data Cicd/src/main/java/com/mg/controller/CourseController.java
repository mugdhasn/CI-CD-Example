package com.mg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mg.model.Course;
import com.mg.model.Topic;
import com.mg.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseservice.getAllCourses(id);
	}
	
//	@RequestMapping("/topics/{id}/courses/{courseId}")
//	public Course getCourse(@PathVariable String courseId) {
//		return courseservice.getCourse(courseId);
//	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseservice.deleteCourse(id);
	}
	
}
