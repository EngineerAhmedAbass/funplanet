package com.Fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Fun.Collaborator.Collaborator;
import com.Fun.Collaborator.CollaboratorService;
import com.Fun.Comment.Comment;
import com.Fun.Comment.CommentService;
import com.Fun.Course.Course;
import com.Fun.Course.CourseService;
import com.Fun.Game.Game;
import com.Fun.Game.GameService;
import com.Fun.Notification.Notification;
import com.Fun.Notification.NotificationService;
import com.Fun.Questions.TF.QuestionServicetf;
import com.Fun.Questions.TF.Questiontf;
import com.Fun.Questions.msq.QuestionMsq;
import com.Fun.Questions.msq.QuestionServiceMsq;
import com.Fun.Registeration.RegisterationService;
import com.Fun.Score.Score;
import com.Fun.Score.ScoreService;
import com.Fun.Student.Student;
import com.Fun.Student.StudentService;
import com.Fun.Teacher.Teacher;
import com.Fun.Teacher.TeacherService;

import java.util.Vector;

@RestController
public class MainController {
	
	@Autowired
	private CourseService courseservice=new CourseService();
	
	@Autowired
	private GameService gameservice=new GameService();

	@Autowired
	private QuestionServiceMsq questionServiceMsq;

	@Autowired
	private QuestionServicetf questionServicetf;

	@Autowired 
	private RegisterationService registerationService;

	@Autowired
	private ScoreService scoreservice;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CommentService commentService;

	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	public static Vector<String> removeDuplicates(Vector<String> v)
    {
        for(int i=0;i<v.size();i++)
        {
            for(int j=0;j<v.size();j++)
            {
                    if(i!=j)
                    {
                        if(v.elementAt(i).equals(v.elementAt(j)))
                        {
                        	v.removeElementAt(j);
                        }
                    }
            }
        }
        return v;
    }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("Course/Teacher/{id:.+}")
	 public @ResponseBody List<Course> GetTeacherCourses(@PathVariable String id)
	 {
		 return courseservice.GetCourse(id);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("Course")
	 public @ResponseBody List<Course> GetAllCourses()
	 {
		 return courseservice.GetCourses();
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("Course/Teacher/Not/{email:.+}")
	public @ResponseBody List<Course> GetCourses(@PathVariable String email)
	{
		List<Course>AllCourses=courseservice.GetCourses();
		List<Course>TeacherCourses=courseservice.GetCourse(email);
		AllCourses.removeAll(TeacherCourses);
		return AllCourses;
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="Course")
	public void AddCourse(@RequestBody Course course)
	{
		courseservice.AddCourse(course); 
	}
	
//	@CrossOrigin(origins = "http://localhost:8080")
//	@RequestMapping(value="/Game/Name/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	 public String GetGameNamee(@PathVariable int id)
//	 {
//		System.out.println("Ay 7aga");
//		 return gameservice.GetGameName(id);
//	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game2/Name/{id}")
	@ResponseBody
	 public Game GetGameName(@PathVariable int id)
	 {
			String Temp =gameservice.GetGameName(id);
			Game T = new Game();
			T.setName(Temp);
		 return T;
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method=RequestMethod.GET,value="/Game")
	 public @ResponseBody List<Game> GetGames()
	 {
		 return gameservice.GetAllGames();
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/Course/{id}")
	 public @ResponseBody List<Game> GetmyGamesbyCourseid(@PathVariable int id)
	 {
		 return gameservice.GetGamesbyid(id);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/Not/Course/{id}")
	 public @ResponseBody List<Game> GetGamesbyCourseid(@PathVariable int id)
	 {
		 List<Game>AllCourseGames=gameservice.GetGamesbyid(id);
		 List<Game>ValidGames =new ArrayList<>();
		 for(int i=0 ; i < AllCourseGames.size();i++)
		 {
			 if(AllCourseGames.get(i).getState().equals("True"))
			 {
				 ValidGames.add(AllCourseGames.get(i));
			 }
		 }
		 return ValidGames;
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/Teacher/Availabe/{email:.+}")
	 public @ResponseBody List<Game> GetAvailabeGamesbyTeacherid(@PathVariable String email)
	 {
		 List<Game>AllGames= gameservice.GetGamesbyTeacherid(email);
		 List<Game>Available=new ArrayList<>();
		 for(int i=0 ; i < AllGames.size();i++)
		 {
			 if(AllGames.get(i).getState().equals("True"))
			 {
				 Available.add(AllGames.get(i));
			 }
		 }
		 return Available;
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/Teacher/Canceled/{email:.+}")
	 public @ResponseBody List<Game> GetCanceledGamesbyTeacherid(@PathVariable String email)
	 {
		List<Game>AllGames= gameservice.GetGamesbyTeacherid(email);
		 List<Game>Available=new ArrayList<>();
		 for(int i=0 ; i < AllGames.size();i++)
		 {
			 if(AllGames.get(i).getState().equals("True"))
			 {
				 Available.add(AllGames.get(i));
			 }
		 }
		 AllGames.removeAll(Available);
		 return AllGames;
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/{id}")
	@ResponseBody
	 public Game GetGame(@PathVariable int id)
	 {
		 return gameservice.GetGame(id);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST ,value="Game")
	public void AddGame(@RequestBody Game game)
	{
		gameservice.AddGame(game);
		Course C = courseservice.GetCourse(game.getCourseID());
		List<Game> CourseGames = gameservice.GetGamesbyid(game.getCourseID());
		Vector<String> AllStudents=new Vector<String>();
		for(int i=0 ; i <CourseGames.size();i++)
		{
			List<Score>scores=scoreservice.GetGameScores(CourseGames.get(i).getID());
			for(int j=0 ; j < scores.size();j++)
			{
				AllStudents.add(scores.get(j).getsId());
			}
		}
		Vector<String> NewAllStudents=removeDuplicates(AllStudents);
		for(int i=0 ; i<NewAllStudents.size();i++)
		{
			Notification Temp =new Notification(game.getName(),C.getName(),NewAllStudents.elementAt(i));
			notificationService.addNotification(Temp);
		}
		//////*********************************************************************************
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Questions/MSQ/{gameid}")
	 public @ResponseBody List<QuestionMsq> GetQuestionsmsq(@PathVariable int gameid)
	 {
		 return questionServiceMsq.GetAllQuestions(gameid);
	 }
	
	@RequestMapping(method=RequestMethod.POST ,value="QuestionMSQ")
	public void AddQuestionMSQ(@RequestBody QuestionMsq questionmsq)
	{
		questionServiceMsq.AddQuestionMsq(questionmsq); 
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Questions/TF/{gameid}")
	 public @ResponseBody List<Questiontf> GetQuestionstf(@PathVariable int gameid)
	 {
		 return questionServicetf.GetAllQuestions(gameid);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method=RequestMethod.POST ,value="QuestionTF")
	public void AddQuestionTF(@RequestBody Questiontf questiontf)
	{
		questionServicetf.AddQuestion(questiontf); 
	}

	@RequestMapping("/Signip/{code}/{mail:.+}")
	@ResponseBody
	public  void SendMail(@PathVariable int code , @PathVariable String mail )
	{
		try{
			registerationService.SendMail(code, mail);
		}catch(MailException e){
			
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Score")
	 public @ResponseBody List<Score> GetScores()
	 {
		 return scoreservice.GetAllScores();
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Score/Game/{gameid}")
	 public @ResponseBody List<Score> GetScoresByGame(@PathVariable int gameid)
	 {
		 return scoreservice.GetGameScores(gameid);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Score/Student/{studentid:.+}")
	 public @ResponseBody List<Score> GetScoresByStudent(@PathVariable String studentid)
	 {
		 return scoreservice.GetStudentScores(studentid);
	 }
	
	@RequestMapping(method=RequestMethod.POST ,value="Score")
	public void AddScore(@RequestBody Score score)
	{
		scoreservice.AddScore(score); 
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Student")
	 public @ResponseBody List<Student> GetStudent()
	 {
		 return studentService.GetAllStudents();
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Student/{mail:.+}")
	@ResponseBody
	public Student GetStudent(@PathVariable String mail)
	{
		return studentService.GetStudent(mail);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/Student")
	public void AddStudent(@RequestBody Student student)
	{
		studentService.AddStudent(student); 
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/Student/{id}")
	public void UpdateStudent(@RequestBody Student student,@PathVariable int id)
	{
		studentService.UpdateStudent(student,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/Student/{mail:.+}")
	public void DeleteStudent(@PathVariable String  mail)
	{
		studentService.DeleteStudent(mail);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Teacher")
	 public @ResponseBody List<Teacher> GetTeacher()
	 {
		 return teacherService.GetAllTeachers();
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Teacher/One/{email:.+}")
	 public @ResponseBody List<Teacher> GetAllTeachersexceptOne(@PathVariable String email)
	 {
		List<Teacher> AllTeachers= teacherService.GetAllTeachers();
		Teacher Temp =teacherService.GetTeacher(email);
		AllTeachers.remove(Temp);
		return AllTeachers;
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Teacher/{email:.+}")
	@ResponseBody
	public Teacher GetTeacher(@PathVariable String email)
	{
		return teacherService.GetTeacher(email);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/Teacher")
	public void AddTeacher(@RequestBody Teacher teacher)
	{
		teacherService.AddTeacher(teacher); 
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/Teacher/{id}")
	public void UpdateTeacher(@RequestBody Teacher teacher,@PathVariable int id)
	{
		teacherService.UpdateTeacher(teacher,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/Teacher/{mail:.+}")
	public void DeleteSTeacher(@PathVariable String mail)
	{
		teacherService.DeleteTeacher(mail);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Games/Teacher/{email:.+}")
	 public @ResponseBody List<Game> GetMineGames(@PathVariable String email)
	 {
		 return gameservice.GetGamesbyTeacherid(email);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Games/Not/Teacher/{email:.+}")
	 public @ResponseBody List<Game> GetNotMineGames(@PathVariable String email)
	 {
		 return gameservice.GetNotMineGames(email);
	 }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/CopyGame/{gameid}/{courseid}/{teacheremail:.+}")
	 public void CopyGame(@PathVariable String teacheremail,@PathVariable int gameid,@PathVariable int courseid)
	 {
		Game newGame=new Game();
		Game Temp=gameservice.GetGame(gameid);
		newGame.setCourseID(courseid);
		newGame.setTeacherID(teacheremail);
		newGame.setDes(Temp.getDes());
		newGame.setName(Temp.getName());
		newGame.setType(Temp.getType());
		newGame.setState("True");
		gameservice.AddGame(newGame);
		
		int NewGameid = 0 ;
		List<Game> AllGames=gameservice.GetAllGames();
		
		for(int i=0 ; i<AllGames.size();i++)
		{
			if(AllGames.get(i).getCourseID()==courseid & AllGames.get(i).getDes()==Temp.getDes() & AllGames.get(i).getTeacherID()==teacheremail & AllGames.get(i).getName()==Temp.getName())
			{
				NewGameid=AllGames.get(i).getID();
				System.out.println(NewGameid);
				break;
			}
		}
		
		if(newGame.getType().equals("tf"))
		{
			List<Questiontf> AllQuestions=questionServicetf.GetAllQuestions(gameid);
			System.out.println(AllQuestions.size());
			for(int i=0 ; i <AllQuestions.size();i++ )
			{
				Questiontf T = new Questiontf();
				T.setGameId(NewGameid);
				T.setAnswer(AllQuestions.get(i).getAnswer());
				T.setQuestion(AllQuestions.get(i).getQuestion());
				questionServicetf.AddQuestion(T);
			}
			
		}else{
			List<QuestionMsq> AllQuestions=questionServiceMsq.GetAllQuestions(gameid);
			for(int i=0 ; i <AllQuestions.size();i++ )
			{
				AllQuestions.get(i).setGameID(NewGameid);
				questionServiceMsq.AddQuestionMsq(AllQuestions.get(i));
			}
		}
		 //return gameservice.GetNotMineGames(email);
	 }
	
	@RequestMapping(method=RequestMethod.POST ,value="Comment")
	public void AddComment(@RequestBody Comment comment)
	{
		Game Temp=gameservice.GetGame(comment.getgId());
		comment.settId(Temp.getTeacherID());
		commentService.AddComment(comment);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Comment/{email:.+}")
	@ResponseBody
	public List<Comment> GetAllComments(@PathVariable String email)
	{
		return commentService.GetAllComments(email);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Notify/{email:.+}")
	@ResponseBody
	public List<Notification> GetNotification(@PathVariable String email)
	{
		return notificationService.GetAllNotifications(email);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/Collaborator")
	public void AddCollaborator(@RequestBody Collaborator collaborator)
	{
		collaboratorService.AddCollaborator(collaborator); 
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Collaborator/{email:.+}")
	@ResponseBody
	public List<Collaborator> GetAllCollaboratorGames(@PathVariable String email)
	{
		return collaboratorService.GetAllCollaboratorGames(email);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/Cancel/{id}")
	@ResponseBody
	public void CancelGame(@PathVariable int id)
	{
		Game Temp= gameservice.GetGame(id);
		Temp.setState("False");
		gameservice.AddGame(Temp);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/Game/UnCancel/{id}")
	@ResponseBody
	public void UnCancelGame(@PathVariable int id)
	{
		Game Temp= gameservice.GetGame(id);
		Temp.setState("True");
		gameservice.AddGame(Temp);
	}
	
}
