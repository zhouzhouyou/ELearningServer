package yuri.elearning.server.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.LessonMapper;
import yuri.elearning.server.mapper.PurchaseMapper;
import yuri.elearning.server.model.Course;
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
    private final PurchaseMapper purchaseMapper;

    public LessonService(CourseMapper courseMapper, LessonMapper lessonMapper, PurchaseMapper purchaseMapper) {
        this.courseMapper = courseMapper;
        this.lessonMapper = lessonMapper;
        this.purchaseMapper = purchaseMapper;
    }

    public ResponseEntity<List<LessonPartMessage>> getAllLessonMessage(Integer cid) {
        List<Lesson> lessons = lessonMapper.selectAllOfCourse(cid);
        Course course = courseMapper.select(cid);
        List<LessonPartMessage> messages = lessons.stream().map(lesson -> new LessonPartMessage(course, lesson.getTitle(), lesson.getTime(), lesson.getId())).collect(Collectors.toList());
        return RF.success(messages);
    }

    public ResponseEntity<Lesson> getLesson(Integer id) {
        Lesson lesson = lessonMapper.select(id);
        return lesson == null ? RF.badRequest(null) : RF.success(lesson);
    }

    public ResponseEntity<List<LessonWithDate>> getAllLessonsWithDate(Integer uid, Integer month) {
        List<Integer> courseIds = purchaseMapper.selectAllCourseOfUser(uid);
        List<LessonWithDate> messages = new ArrayList<>();
        for (Integer courseId : courseIds) {
            String courseName = courseMapper.selectCourseName(courseId);
            List<Lesson> lessons = lessonMapper.selectAllLessonWithDate(courseId, month);
            List<LessonWithDate> message = lessons.stream().map(lesson -> new LessonWithDate(lesson.getTime(), lesson.getTitle(), courseName, lesson.getId())).collect(Collectors.toList());
            messages.addAll(message);
        }
        return RF.success(messages);
    }

}
