package com.course.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseResource {

  @Autowired
  private CoursesHardcodedService courseManagementService;
  @Autowired
  private Response response;
  
  @GetMapping("/instructors/courses")
  public List<Course> getAllCourses() {
    return courseManagementService.findAll();
  }
  
  @GetMapping("/instructors/courses/{id}")
  public Course deleteByID(@PathVariable int id) {
	  return courseManagementService.deleteByID(id);
	  
  }
  
  @PostMapping("/instructor/courses/add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Course addCourse(@RequestBody  Course course) {
	  Course course1=course;
	 Course courses= courseManagementService.AddData(course1);
	  return courses ;
  }
  
  @GetMapping("/instructor/course/{id}")
  public Course getCourse(@PathVariable int id) {
	  System.out.print(id);
	 // System.out.println(courseManagementService.findById(id-1));
	return courseManagementService.findById(id);
	  
  }
  
  @PutMapping("/instructors/courses/{id}")
  public ResponseEntity<Course> updateCourse(
      @RequestBody Course course,@PathVariable int id) {

    Course courseUpdated = courseManagementService.save(course,id-1);

    return new ResponseEntity<Course>(courseUpdated, HttpStatus.OK);
  }
  
  //anil kumar  9515131086
  
  
}