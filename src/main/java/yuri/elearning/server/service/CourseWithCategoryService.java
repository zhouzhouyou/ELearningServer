package yuri.elearning.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CategoryMapper;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.PurchaseMapper;
import yuri.elearning.server.mapper.TypeMapper;
import yuri.elearning.server.model.Category;
import yuri.elearning.server.model.Course;
import yuri.elearning.server.model.CourseBriefInfo;
import yuri.elearning.server.util.RF;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CourseWithCategoryService {
    private final CourseMapper courseMapper;
    private final CategoryMapper categoryMapper;
    private final TypeMapper typeMapper;
    private final PurchaseMapper purchaseMapper;

    @Autowired
    public CourseWithCategoryService(CourseMapper courseMapper, CategoryMapper categoryMapper, TypeMapper typeMapper, PurchaseMapper purchaseMapper) {
        this.courseMapper = courseMapper;
        this.categoryMapper = categoryMapper;
        this.typeMapper = typeMapper;
        this.purchaseMapper = purchaseMapper;
    }

    public ResponseEntity<List<CourseBriefInfo>> getAllMyCourseMessage(Integer uid) {
        List<Integer> courseIds = purchaseMapper.selectAllCourseOfUser(uid);
        List<Course> courses;
        List<CourseBriefInfo> messages;
        courses = courseIds.stream().map(courseMapper::select).collect(Collectors.toList());
        messages = courses.stream().map(course -> new CourseBriefInfo(course.getName(), course.getId(), course.getCover())).collect(Collectors.toList());
        return RF.success(messages);
    }

    public ResponseEntity<List<CourseBriefInfo>> getAllCourseMessage() {
        List<Course> courses = courseMapper.selectAll();
        List<CourseBriefInfo> messages = courses.stream().map(course -> new CourseBriefInfo(course.getName(), course.getId(), course.getCover())).collect(Collectors.toList());
        return RF.success(messages);
    }

    public ResponseEntity<List<Category>> getAllCategoryMessage() {
        List<Category> categories = categoryMapper.selectAll();
        return RF.success(categories);
    }

    public ResponseEntity<List<CourseBriefInfo>> getCoursesByCategory(Integer id) {
        List<Integer> courseIds = typeMapper.selectAllCourseByCategory(id);
        List<CourseBriefInfo> messages = courseIds.stream().map(courseMapper::select).map(course -> new CourseBriefInfo(course.getName(), course.getId(), course.getCover())).collect(Collectors.toList());
        return RF.success(messages);
    }


}
