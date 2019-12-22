package yuri.elearning.server.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuri.elearning.server.model.Lesson;
import yuri.elearning.server.model.LessonPartMessage;
import yuri.elearning.server.model.LessonWithDate;
import yuri.elearning.server.service.LessonService;

import java.util.List;

@Api(tags = "课时API")
@RestController
@RequestMapping("/api/lesson")
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @ApiOperation("获取此课程下所有课时信息")
    @PostMapping("/allLessonByCourse")
    @ResponseBody
    public ResponseEntity<List<LessonPartMessage>> getAllLessonMessage(@RequestParam("cid") Integer courseId) {
        return lessonService.getAllLessonMessage(courseId);
    }

    @ApiOperation("获取课时信息")
    @PostMapping("/lesson")
    @ResponseBody
    public ResponseEntity<Lesson> getLesson(@RequestParam("lid") Integer lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @ApiOperation("获取此用户此年月下所有课时信息")
    @PostMapping("/myAllLessonWithDate")
    @ResponseBody
    public ResponseEntity<List<LessonWithDate>> getAllLessonsWithDate(@RequestParam("uid") Integer userid,
                                                                      @RequestParam("month") Integer month,
                                                                      @RequestParam("year") Integer year) {
        return lessonService.getAllLessonsWithDate(userid, month, year);
    }
}
