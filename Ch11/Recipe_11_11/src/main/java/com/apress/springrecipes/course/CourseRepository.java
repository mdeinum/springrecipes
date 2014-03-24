package com.apress.springrecipes.course;

import org.springframework.data.repository.CrudRepository;

import java.lang.Long;
import java.util.List;


public interface CourseRepository extends CrudRepository<Course, Long> { }
