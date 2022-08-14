package Entities;

public class Assignment {
	private int id;
	private String StudentName;
	private String Subject;
	private String Category;
	private String dateOfSubmission;
	private int points;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
	public int getPoints() {
		return points;
	}
	public Assignment(String studentName, String subject, String category, String dateOfSubmission, int points) {
		super();
		StudentName = studentName;
		Subject = subject;
		Category = category;
		this.dateOfSubmission = dateOfSubmission;
		this.points = points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Assignment(int id, String studentName, String subject, String category, String dateOfSubmission,
			int points) {
		super();
		this.id = id;
		StudentName = studentName;
		Subject = subject;
		Category = category;
		this.dateOfSubmission = dateOfSubmission;
		this.points = points;
	}
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
