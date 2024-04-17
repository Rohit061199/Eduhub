package com.eduhub.eduhubapp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.DTO.EnrollInfoStudentDTO;
import com.eduhub.eduhubapp.DTO.LessonDetailsDTO;
import com.eduhub.eduhubapp.entity.Certificate;
import com.eduhub.eduhubapp.entity.Course;
import com.eduhub.eduhubapp.entity.Enrollment;
import com.eduhub.eduhubapp.entity.Lesson;
//import com.eduhub.eduhubapp.entity.Options;
import com.eduhub.eduhubapp.entity.Question;
import com.eduhub.eduhubapp.entity.Quiz;

@Service
public interface EduhubCourseService {
	
	public void createAQuestionForQuiz(Question question);
	public ResponseEntity<String> createAQuizForLesson(Quiz lessonToQuiz);
	public ResponseEntity<String> createALessonForCourse(Lesson lessonDetails);
	public ResponseEntity<String> createACourse(Course courseDetails);
	ResponseEntity<String> enrollStudentToCourse(Enrollment enrollRequest);
	ResponseEntity<String> addQuestionsToQuiz(List<Question> questionList);
	ResponseEntity<List<Question>> getAllQuestionsForQuiz(Integer quizId);
	ResponseEntity<Certificate> generateCertificate(Enrollment enrollCert);
	ResponseEntity<List<Course>> viewAllCourses();
	ResponseEntity<Course> viewCourse(Integer courseId);
	ResponseEntity<List<EnrollInfoStudentDTO>> generateStudentListForCourse(Integer courseId);
	//ResponseEntity<List<LessonDetailsDTO>> getListOfLessonsForCourse(Integer courseId);
	ResponseEntity<LessonDetailsDTO> getLessonForCourse(Integer lessonId, Integer courseId,Integer userId);
	ResponseEntity<Quiz> getQuizForLesson(Integer quizId, Integer lessonId);
	ResponseEntity<Quiz> getAllQuizesForLesson(Lesson lessonDets);
	ResponseEntity<String> editCourse(Course courseEditReq);
	ResponseEntity<String> editLesson(Lesson lessonEditReq);
	ResponseEntity<List<LessonDetailsDTO>> getListOfLessonsForCourse(Integer courseId, Integer userId);

}
