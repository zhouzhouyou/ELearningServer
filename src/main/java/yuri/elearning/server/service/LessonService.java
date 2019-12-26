package yuri.elearning.server.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.LessonMapper;
import yuri.elearning.server.mapper.PurchaseMapper;
import yuri.elearning.server.model.Course;
import yuri.elearning.server.model.Lesson;
import yuri.elearning.server.model.CourseDetailInfo;
import yuri.elearning.server.model.LessonBriefInfo;
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

    public ResponseEntity<CourseDetailInfo> getAllLessonMessage(Integer cid) {
        List<Lesson> lessons = lessonMapper.selectAllOfCourse(cid);
        Course course = courseMapper.select(cid);
        List<LessonBriefInfo> messages = lessons.stream().map(lesson -> new LessonBriefInfo(lesson.getTitle(), lesson.getTime(), lesson.getId(), cid)).collect(Collectors.toList());

        return RF.success(new CourseDetailInfo(course,messages));
    }

    public ResponseEntity<Lesson> getLesson(Integer id) {
        Lesson lesson = lessonMapper.select(id);
        return lesson == null ? RF.badRequest(null) : RF.success(lesson);
    }

    public ResponseEntity<List<LessonBriefInfo>> getAllLessonsWithDate(Integer uid, Integer month, Integer year) {
        List<Integer> courseIds = purchaseMapper.selectAllCourseOfUser(uid);
        List<LessonBriefInfo> messages = new ArrayList<>();
        for (Integer courseId : courseIds) {
            List<Lesson> lessons = lessonMapper.selectAllLessonWithDate(courseId, month, year);
            List<LessonBriefInfo> message = lessons.stream().map(lesson -> new LessonBriefInfo(lesson.getTitle(), lesson.getTime(), lesson.getId(), courseId)).collect(Collectors.toList());
            messages.addAll(message);
        }
        return RF.success(messages);
    }

}
