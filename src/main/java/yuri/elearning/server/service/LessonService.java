package yuri.elearning.server.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.LessonMapper;
import yuri.elearning.server.model.Lesson;
import yuri.elearning.server.model.LessonPartMessage;
import yuri.elearning.server.model.LessonWithDate;
import yuri.elearning.server.util.RF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class LessonService {
    private final CourseMapper courseMapper;
    private final LessonMapper lessonMapper;

    public LessonService(CourseMapper courseMapper, LessonMapper lessonMapper) {
        this.courseMapper = courseMapper;
        this.lessonMapper = lessonMapper;
    }

    public ResponseEntity<List<LessonPartMessage>> getAllLessonMessage(Integer cid) {
        List<Lesson> lessons = lessonMapper.selectAllOfCourse(cid);
        List<LessonPartMessage> messages = lessons.stream().map(lesson -> new LessonPartMessage(lesson.getTitle(), lesson.getTime(), lesson.getId())).collect(Collectors.toList());
        return RF.success(messages);
    }

    public ResponseEntity<Lesson> getLesson(Integer id){
        Lesson lesson = lessonMapper.select(id);
        return lesson == null ? RF.badRequest(null) : RF.success(lesson);
    }

//    public ResponseEntity<List<LessonWithDate>> getAllLessonsWithDate(Integer month){
//
//    }


}
