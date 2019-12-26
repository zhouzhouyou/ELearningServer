package yuri.elearning.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuri.elearning.server.model.Category;
import yuri.elearning.server.model.CourseBriefInfo;
import yuri.elearning.server.service.CourseWithCategoryService;

import java.util.List;

@Api(tags = "课程API")
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseWithCategoryService courseWithCategoryService;

    @Autowired
    public CourseController(CourseWithCategoryService courseWithCategoryService) {
        this.courseWithCategoryService = courseWithCategoryService;
    }

    @ApiOperation("获取此用户所有课程信息")
    @PostMapping("/myAllCourse")
    @ResponseBody
    public ResponseEntity<List<CourseBriefInfo>> getAllMyCourseMessage(@RequestParam("uid") Integer userId) {
        return courseWithCategoryService.getAllMyCourseMessage(userId);
    }


    @ApiOperation("获取所有课程信息")
    @PostMapping("/allCourse")
    @ResponseBody
    public ResponseEntity<List<CourseBriefInfo>> getAllCourseMessage() {
        return courseWithCategoryService.getAllCourseMessage();
    }

    @ApiOperation("获取所有课程类型信息")
    @PostMapping("/allCategory")
    @ResponseBody
    public ResponseEntity<List<Category>> getAllCategoryMessage() {
        return courseWithCategoryService.getAllCategoryMessage();
    }

    @ApiOperation("获取此类型下所有课程信息")
    @PostMapping("/allCourseByCategory")
    @ResponseBody
    public ResponseEntity<List<CourseBriefInfo>> getCoursesByCategory(@RequestParam("cid") Integer categoryId) {
        return courseWithCategoryService.getCoursesByCategory(categoryId);
    }
}
