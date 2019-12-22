package yuri.elearning.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CategoryMapper;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.TypeMapper;
import yuri.elearning.server.model.Category;
import yuri.elearning.server.model.Course;
import yuri.elearning.server.model.CoursePartMessage;
import yuri.elearning.server.util.RF;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CourseWithCategoryService {
    private final CourseMapper courseMapper;
    private final CategoryMapper categoryMapper;
    private final TypeMapper typeMapper;

    @Autowired
    public CourseWithCategoryService(CourseMapper courseMapper, CategoryMapper categoryMapper, TypeMapper typeMapper) {
        this.courseMapper = courseMapper;
        this.categoryMapper = categoryMapper;
        this.typeMapper = typeMapper;
    }

    public ResponseEntity<List<CoursePartMessage>> getAllCourseMessage() {
        List<Course> courses = courseMapper.selectAll();
        List<CoursePartMessage> messages = courses.stream().map(course -> new CoursePartMessage(course.getName(),course.getId(), course.getCover())).collect(Collectors.toList());
        return RF.success(messages);
    }

    public ResponseEntity<List<Category>> getAllCategoryMessage() {
        List<Category> categories = categoryMapper.selectAll();
        return RF.success(categories);
    }

    public ResponseEntity<List<CoursePartMessage>> getCoursesInCategory(Integer id) {
        List<Integer> courseIds = typeMapper.selectAllCourseOfCategory(id);
        List<CoursePartMessage> messages = courseIds.stream().map(courseMapper::select).map(course -> new CoursePartMessage(course.getName(),course.getId(), course.getCover())).collect(Collectors.toList());
        return RF.success(messages);
    }


}
