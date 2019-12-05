package com.course.demo;


import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CoursesHardcodedService {

  private static List<Course> courses = new ArrayList<>();
  private static int idCounter = 0;

  static {
    courses.add(new Course(++idCounter, "Ankita","Das", "+1758863","ankita.das@gmail.com"));
    courses.add(new Course(++idCounter, "Shiva","Reddy", "+1757863","ankita.das@gmail.com"));
    courses.add(new Course(++idCounter, "Ankur","Biswas", "+1994563","ankita.das@gmail.com"));
    courses.add(new Course(++idCounter, "Nikita","Sen", "+1356886","ankita.das@gmail.com"));
  }

  public List<Course> findAll() {
	  System.out.println(courses);
    return courses;
  }
  
  
  public Course AddData(Course course) {
	  Course course1=new Course();
	  course1.setId(courses.size()+1);
	  course1.setFirstName(course.getFirstName());
	  course1.setLastName(course.getLastName());
	  course1.setPhone(course.getPhone());
	  course1.setEmail(course.getEmail());
	  
	  courses.add(course1);
	  
	  return course1;
  }
  
  public Course deleteByID(int id) {
	  Course course = findById(id);

	    if (course == null)
	      return null;

	    if (courses.remove(course)) {
	      return course;
	    }

	    return null;
  }

  public Course save(Course course,int id) {
	  if (course.getId() == -1 || course.getId() == 0) {
	    course.setId(++idCounter);
	    courses.add(course);
	  } else {
	    deleteByID(course.getId());
	    courses.add(course);
	  }
	  return course;
	}

public Course findById(int id) {
	// TODO Auto-generated method stub
	Course course1=null;
	for (Course course : courses) {
		if(course.getId()==id) {
			course1=courses.get(course.getId()-1);
		}
			
		
	}
	return course1;
	
}
}