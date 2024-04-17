package com.eduhub.eduhubapp.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eduhub.eduhubapp.DTO.EnrollInfoStudentDTO;
import com.eduhub.eduhubapp.DTO.LessonDetailsDTO;
import com.eduhub.eduhubapp.DTO.SubmissionRequestDTO;
import com.eduhub.eduhubapp.Dao.CertificateDao;
import com.eduhub.eduhubapp.Dao.CourseDao;
import com.eduhub.eduhubapp.Dao.EnrollmentDao;
import com.eduhub.eduhubapp.Dao.LessonDao;
import com.eduhub.eduhubapp.Dao.QuestionDao;
import com.eduhub.eduhubapp.Dao.QuizDao;
import com.eduhub.eduhubapp.Dao.SubmissionDao;
import com.eduhub.eduhubapp.entity.Certificate;
import com.eduhub.eduhubapp.entity.Course;
//import com.eduhub.eduhubapp.entity.EduhubUser;
import com.eduhub.eduhubapp.entity.Enrollment;
import com.eduhub.eduhubapp.entity.Lesson;
//import com.eduhub.eduhubapp.entity.Options;
import com.eduhub.eduhubapp.entity.Question;
import com.eduhub.eduhubapp.entity.Quiz;
import com.eduhub.eduhubapp.entity.Submission;

@Service
public class EduhubCourseServiceImpl implements EduhubCourseService {
	
	@Autowired
	Question question;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	Quiz quiz;
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	Lesson lesson;
	
	@Autowired
	LessonDao lessonDao;
	
	@Autowired
	Course course;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	Enrollment enrollment;
	
	@Autowired
	EnrollmentDao enrollmentDao;
	
	@Autowired
	Certificate certificate;
	
	@Autowired
	CertificateDao certificateDao;
	
	@Autowired
	EduhubUserServiceImpl eduhubUserServiceImpl;
	
	@Autowired
	Submission submission;
	
	@Autowired
	SubmissionDao submissionDao;

	@Override
	public void createAQuestionForQuiz(Question questionRequest) {
		// TODO Auto-generated method stub
		/*question.setQuestionDescription(questionRequest.getQuestionDescription());
		question.setOption1(questionRequest.getOption1());
		question.setOption2(questionRequest.getOption2());
		question.setOption3(questionRequest.getOption3());
		question.setOption4(questionRequest.getOption4());
		question.setQuizId(questionRequest.getQuizId());
		question.setCorrectAnswer(questionRequest.getCorrectAnswer());*/
		try {
			questionDao.addQuestionForQuiz(questionRequest.getQuizId(),questionRequest.getQuestionDescription(),questionRequest.getOption1(),
					questionRequest.getOption2(),questionRequest.getOption3(),questionRequest.getOption4(),questionRequest.getCorrectAnswer());
			//return new ResponseEntity<>("Created a question for the quiz",HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			//return new ResponseEntity<>("Failed to create a question. Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}

	@Override
	public ResponseEntity<String> createAQuizForLesson(Quiz lessonToQuiz) {
		// TODO Auto-generated method stub
		quiz.setDescription(lessonToQuiz.getDescription());
		quiz.setLessonId(lessonToQuiz.getLessonId());
		quiz.setTitle(lessonToQuiz.getTitle());
		try {
			quizDao.save(quiz);
			return new ResponseEntity<>("Created a quiz with quizId "
			+quizDao.findByTitleAndLessonId(lessonToQuiz.getTitle(),lessonToQuiz.getLessonId()).getQuizId()
			,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Create a quiz.Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> createALessonForCourse(Lesson lessonDetails) {
		// TODO Auto-generated method stub
		lesson.setCourseId(lessonDetails.getCourseId());
		lesson.setDescription(lessonDetails.getDescription());
		lesson.setTitle(lessonDetails.getTitle());
		lesson.setSubtitle(lessonDetails.getSubtitle());
		lesson.setImageUrl(lessonDetails.getImageUrl());
		//lesson.setVideoId(lessonDetails.getVideoId());
		try {
			lessonDao.insertLessonDetails(lessonDetails.getCourseId(),lessonDetails.getTitle(),lessonDetails.getSubtitle(),lessonDetails.getImageUrl()
					,lessonDetails.getDescription());
			return new ResponseEntity<>("Created a lesson with lessonId "+lessonDao.findByTitle(lessonDetails.getTitle()).getLessonId(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Create a Lesson.Check Logs",HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}

	@Override
	public ResponseEntity<String> createACourse(Course courseDetails) {
		// TODO Auto-generated method stub
		course.setTitle(courseDetails.getTitle());
		course.setDescription(courseDetails.getDescription());
		course.setCoursePrice(courseDetails.getCoursePrice());
		course.setUserId(courseDetails.getUserId());
		course.setSubtitle(courseDetails.getSubtitle());
		course.setImageUrl(courseDetails.getImageUrl());
		try{
			courseDao.insertCourseDetails(courseDetails.getTitle(),courseDetails.getSubtitle(),courseDetails.getImageUrl(),courseDetails.getCoursePrice()
					,courseDetails.getDescription(),courseDetails.getUserId());
			return new ResponseEntity<>("Created a course with courseId "+courseDao.findByTitle(courseDetails.getTitle()).getCourseId(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Create a Course.Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@Override
	public ResponseEntity<String> enrollStudentToCourse(Enrollment enrollRequest){
		enrollment.setCourseId(enrollRequest.getCourseId());
		enrollment.setUserId(enrollRequest.getUserId());
		enrollment.setEnrollmentDate(enrollRequest.getEnrollmentDate());
		try {
			enrollmentDao.enrollStudentToCourse(enrollRequest.getUserId(), enrollRequest.getCourseId(), enrollRequest.getEnrollmentDate());
			return new ResponseEntity<>("Successfully Enrolled into the course with EnrollmentID: "+enrollmentDao.findByUserIdAndCourseId(enrollRequest.getUserId()
					,enrollRequest.getCourseId()).getEnrollmentId()
					,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to enroll.Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}
	
	@Override
	public ResponseEntity<Certificate> generateCertificate(Enrollment enrollCert){
		if(!checkForEnrollment(enrollCert.getCourseId(),enrollCert.getUserId())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		certificate.setExternalCertificateId("Eduhub");
		certificate.setCourseId(enrollCert.getCourseId());
		certificate.setUserId(enrollCert.getUserId());
		//add code to get courseName
		String courseName=courseDao.findByCourseId(enrollCert.getCourseId()).getTitle();
		certificate.setCourseName(courseName);
		certificate.setScore(enrollCert.getScore());
		certificate.setCompletionDate(enrollCert.getCompletionDate());
		certificate.setUserName(eduhubUserServiceImpl.fetchUserNameForCertificate(enrollCert.getUserId()));
		try {
			certificateDao.save(certificate);
			certificate.setExternalCertificateId("Eduhub00"+
			certificateDao.findByUserIdAndCourseId(enrollCert.getUserId(),enrollCert.getCourseId()).getInternalCertificateId());
			certificateDao.save(certificate);
			return new ResponseEntity<>(certificate,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<Course>> viewAllCourses(){
		try {
			List<Course> courseList=courseDao.findAll();
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<Course> viewCourse(Integer courseId){
		try {
			Course newCourse=courseDao.findByCourseId(courseId);
			return new ResponseEntity<>(newCourse,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<EnrollInfoStudentDTO>> generateStudentListForCourse(Integer courseId){
		try {
			List<EnrollInfoStudentDTO> studentList=enrollmentDao.findListOfStudentsForCourse(courseId);
			return new ResponseEntity<>(studentList,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<LessonDetailsDTO>> getListOfLessonsForCourse(Integer courseId,Integer userId){
		if(!checkForEnrollment(courseId,userId)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		try {
			List<LessonDetailsDTO> listDetails=new ArrayList<>();
			List<Lesson> lessonList=lessonDao.findByCourseId(courseId);
			for(Lesson eachLesson:lessonList) {
				Float quizScore;
				if(quizDao.findByLessonId(eachLesson.getLessonId())!=null) {
					Integer quizId=quizDao.findByLessonId(eachLesson.getLessonId()).getQuizId();
					Float tempsub=submissionDao.findQuizScoreByQuizIdAndUserId(quizId,userId);
					if(tempsub!=null) {
						quizScore=tempsub;
					}
					else {
						quizScore=0.0f;
					}
				}
				else {
					quizScore=0.0f;
				}
				LessonDetailsDTO newDTO=new LessonDetailsDTO(eachLesson.getTitle(), eachLesson.getDescription()
						,eachLesson.getCourseId(), eachLesson.getSubtitle(),eachLesson.getImageUrl(),quizScore);
				listDetails.add(newDTO);
			}
			return new ResponseEntity<>(listDetails,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<LessonDetailsDTO>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<LessonDetailsDTO> getLessonForCourse(Integer lessonId,Integer courseId,Integer userId){
		if(!checkForEnrollment(courseId,userId)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Float quizScore;
		try {
			Lesson fetchedLesson=lessonDao.findByLessonIdAndCourseId(lessonId,courseId);
			if(quizDao.findByLessonId(fetchedLesson.getLessonId())!=null) {
				Integer quizId=quizDao.findByLessonId(fetchedLesson.getLessonId()).getQuizId();
				Float tempsub=submissionDao.findQuizScoreByQuizIdAndUserId(quizId,userId);
				if(tempsub!=null) {
					quizScore=tempsub;
				}
				else {
					quizScore=0.0f;
				}
			}
			else {
				quizScore=0.0f;
			}
			LessonDetailsDTO newDTO=new LessonDetailsDTO(fetchedLesson.getTitle(), fetchedLesson.getDescription()
					,fetchedLesson.getCourseId(), fetchedLesson.getSubtitle(),fetchedLesson.getImageUrl(),quizScore);
			return new ResponseEntity<>(newDTO,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private boolean checkForEnrollment(Integer courseId, Integer userId) {
		// TODO Auto-generated method stub
		if(enrollmentDao.findByUserIdAndCourseId(userId, courseId)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ResponseEntity<Quiz> getQuizForLesson(Integer quizId,Integer lessonId){
		try {
			Quiz fecthedQuiz=quizDao.findByQuizIdAndLessonId(quizId,lessonId);
			return new ResponseEntity<>(fecthedQuiz,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<Quiz> getAllQuizesForLesson(Lesson lessonDets){
		try {
			Quiz quizList=quizDao.findByLessonId(lessonDets.getLessonId());
			return new ResponseEntity<>(quizList,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<Question>> getAllQuestionsForQuiz(Quiz quizDets){
		try {
			List<Question> questionList=questionDao.findByQuizId(quizDets.getQuizId());
			return new ResponseEntity<>(questionList,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<String> addQuestionsToQuiz(List<Question> questionList){
		try {
			for(Question questionOb:questionList) {
				createAQuestionForQuiz(questionOb);
				for(int i=0;i<1000;i++) {
					//wait
				}
			}
			return new ResponseEntity<>("Added Questions To Quiz",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed to add questions. Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<String> editCourse(Course courseEditReq){
		try {
			Course courseFromDB=courseDao.findByCourseId(courseEditReq.getCourseId());
			if(courseEditReq.getCoursePrice()!=null) {
				courseFromDB.setCoursePrice(courseEditReq.getCoursePrice());
			}
			if(courseEditReq.getDescription()!=null) {
				courseFromDB.setDescription(courseEditReq.getDescription());
			}
			if(courseEditReq.getImageUrl()!=null) {
				courseFromDB.setImageUrl(courseEditReq.getImageUrl());
			}
			if(courseEditReq.getSubtitle()!=null) {
				courseFromDB.setSubtitle(courseEditReq.getSubtitle());
			}
			if(courseEditReq.getTitle()!=null) {
				courseFromDB.setTitle(courseEditReq.getTitle());
			}
			
			courseDao.save(courseFromDB);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed. Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<String> editLesson(Lesson lessonEditReq){
		try {
			Lesson lessonFromDB=lessonDao.findByLessonId(lessonEditReq.getLessonId());
			/*if(lessonEditReq.getCoursePrice()!=null) {
				courseFromDB.setCoursePrice(lessonEditReq.getCoursePrice());
			}*/
			if(lessonEditReq.getDescription()!=null) {
				lessonFromDB.setDescription(lessonEditReq.getDescription());
			}
			if(lessonEditReq.getImageUrl()!=null) {
				lessonFromDB.setImageUrl(lessonEditReq.getImageUrl());
			}
			if(lessonEditReq.getSubtitle()!=null) {
				lessonFromDB.setSubtitle(lessonEditReq.getSubtitle());
			}
			if(lessonEditReq.getTitle()!=null) {
				lessonFromDB.setTitle(lessonEditReq.getTitle());
			}
			
			lessonDao.save(lessonFromDB);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed. Check Logs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Map<Object,Object>> evaluateQuizSubmission(List<SubmissionRequestDTO> quizRequest){
		int points=0,noOfQues=0;
		float finalScore;
		Integer userId=quizRequest.get(0).getUserId();
		Integer quizId=quizRequest.get(0).getQuizId();
		for(SubmissionRequestDTO sub:quizRequest) {
			String correctAnswer=fetchAnswerForQuestion( sub.getQuizId(), sub.getQuestionId());
			//System.out.println("Correct Answer: "+correctAnswer+" Response: "+sub.getResponse());
			if(correctAnswer.equals(sub.getResponse())) {
				points+=1;
				//System.out.println(points);
			}
			noOfQues+=1;
		}
		
		finalScore=(points*1.0f/noOfQues)*100;
		//System.out.println("pont/ques: "+(points/noOfQues));
		
		submissionDao.insertSubmissionToDB(userId,quizId,finalScore);
		Boolean checkCourseComplete=checkAndUpdateForCourseCompletion(quizId,userId,finalScore);
		if(checkCourseComplete) updateCompletionStatusForEnrollment(quizId,userId,checkCourseComplete);
		
		Map<Object,Object> statusMap=new HashMap<>();
		statusMap.put("isComplete", checkCourseComplete);
		statusMap.put("quizScore", finalScore);
		
		
		return new ResponseEntity<>(statusMap,HttpStatus.OK);
	}
	
	private void updateCompletionStatusForEnrollment(Integer quizId, Integer userId, Boolean checkCourseComplete) {
		// TODO Auto-generated method stub
		Integer lessonId=quizDao.findLessonIdByQuizId(quizId);
		Integer courseId=lessonDao.findCourseIdByLessonId(lessonId);
		enrollmentDao.updateCompletionForUser(courseId,userId,checkCourseComplete,LocalDate.now());
		
	}

	private Boolean checkAndUpdateForCourseCompletion(Integer quizId, Integer userId, float finalScore) {
		// TODO Auto-generated method stub
		
		Integer lessonId=quizDao.findLessonIdByQuizId(quizId);
		Integer maxQuizId=quizDao.findMaxQuizIdByLessonId(lessonId);
		if(quizId<maxQuizId) {
			return false;
		}
		return true;
	}

	public String fetchAnswerForQuestion(Integer quizId,Integer questionId) {
		
		String correctAnswer=questionDao.findCorrectAnswerByQuestionId(questionId);
		return correctAnswer;
	}


	
	
	
	

}
