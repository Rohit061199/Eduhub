package com.eduhub.eduhubapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduhub.eduhubapp.DTO.EnrollInfoStudentDTO;
import com.eduhub.eduhubapp.DTO.LessonDetailsDTO;
import com.eduhub.eduhubapp.DTO.SubmissionRequestDTO;
import com.eduhub.eduhubapp.Service.EduhubCourseServiceImpl;
import com.eduhub.eduhubapp.entity.Article;
import com.eduhub.eduhubapp.entity.Certificate;
import com.eduhub.eduhubapp.entity.Course;
import com.eduhub.eduhubapp.entity.Enrollment;
import com.eduhub.eduhubapp.entity.Lesson;
import com.eduhub.eduhubapp.entity.Question;
import com.eduhub.eduhubapp.entity.Quiz;

@CrossOrigin
@RestController
@RequestMapping("course")
public class EduhubCourseController {
	
	@Autowired
	EduhubCourseServiceImpl eduhubCourseServiceImpl;
	
	@PostMapping("createCourse")
	public ResponseEntity<String> createNewCourse(@RequestBody Course course){
		return eduhubCourseServiceImpl.createACourse(course);
	}
	
	@PostMapping("createQuiz")
	public ResponseEntity<String> createNewQuiz(@RequestBody Quiz quiz){
		return eduhubCourseServiceImpl.createAQuizForLesson(quiz);
	}
	
	@PostMapping("createLesson")
	public ResponseEntity<String> createNewLesson(@RequestBody Lesson lessonReq){
		return eduhubCourseServiceImpl.createALessonForCourse(lessonReq);
	}
	
	@GetMapping("viewCourse")
	public ResponseEntity<Course> viewCourse(@RequestBody Integer courseId){
		return eduhubCourseServiceImpl.viewCourse(courseId);
	}
	
	@GetMapping("viewAllCourse")
	public ResponseEntity<List<Course>> viewAllCourse(){
		return eduhubCourseServiceImpl.viewAllCourses();
	}
	
	@PostMapping("buyCourse")
	public ResponseEntity<String> buyCourse(@RequestBody Enrollment enrollRequest){
		return eduhubCourseServiceImpl.enrollStudentToCourse(enrollRequest);
	}
	
	@GetMapping("certificateDetails")
	public ResponseEntity<Certificate> generateCertificate(@RequestBody Enrollment enrollment){
		return eduhubCourseServiceImpl.generateCertificate(enrollment);
	}
	
	@GetMapping("generateStudentList")
	public ResponseEntity<List<EnrollInfoStudentDTO>> generateStudentList(@RequestBody Course coursereq){
		return eduhubCourseServiceImpl.generateStudentListForCourse(coursereq.getCourseId());
	}
	
	@GetMapping("getAllLessons")
	public ResponseEntity<List<LessonDetailsDTO>> listOfLessonsForCourse(@RequestBody Map<Object,Object> lesson){
		return eduhubCourseServiceImpl.getListOfLessonsForCourse((Integer)lesson.get("courseId"),(Integer)lesson.get("userId"));
	}
	
	@GetMapping("getLesson")
	public ResponseEntity<LessonDetailsDTO> getLessonForCourse(@RequestBody Map<Object,Object> lessonReq){
		return eduhubCourseServiceImpl.getLessonForCourse((Integer)lessonReq.get("lessonId"),(Integer) lessonReq.get("courseId"),(Integer)lessonReq.get("userId"));
	}
	
	@GetMapping("getQuizForLesson")
	public ResponseEntity<Quiz> getQuizForLesson(@RequestBody Quiz quizReq){
		return eduhubCourseServiceImpl.getQuizForLesson(quizReq.getQuizId(), quizReq.getLessonId());
	}
	
	@GetMapping("getAllQuizForLesson")
	public ResponseEntity<Quiz> getAllQuizesForLesson(@RequestBody Lesson lessonDets){
		return eduhubCourseServiceImpl.getAllQuizesForLesson(lessonDets);
	}
	
	@GetMapping("loadQuestionsForQuiz")
	public ResponseEntity<List<Question>> loadQuestionsForQuiz(@RequestBody Quiz quizDets){
		return eduhubCourseServiceImpl.getAllQuestionsForQuiz(quizDets);
	}
	
	@PostMapping("createQuestions")
	public ResponseEntity<String> addQuestionsToQuiz(@RequestBody List<Question> questionList){
		return eduhubCourseServiceImpl.addQuestionsToQuiz(questionList);
	}
	
	@PutMapping("editCourse")
	public ResponseEntity<String> editCourseDetails(@RequestBody Course courseEditDets){
		return eduhubCourseServiceImpl.editCourse(courseEditDets);
	}
	
	@PutMapping("editLesson")
	public ResponseEntity<String> editLessonDetails(@RequestBody Lesson lessonEditDets){
		return eduhubCourseServiceImpl.editLesson(lessonEditDets);
	}
	
	@PostMapping("evaluateQuiz")
	public ResponseEntity<Map<Object,Object>> quizEvaluateAndUpdate(@RequestBody List<SubmissionRequestDTO> quizRequest){
		return eduhubCourseServiceImpl.evaluateQuizSubmission(quizRequest);
	}
	
	

}
