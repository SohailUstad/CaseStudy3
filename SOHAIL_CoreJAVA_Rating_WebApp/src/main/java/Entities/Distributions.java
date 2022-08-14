package Entities;

public class Distributions {
	private int id;
	public Distributions(int id, String assignmentCategory, int weight) {
		super();
		this.id = id;
		this.assignmentCategory = assignmentCategory;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String assignmentCategory;
	private int weight;
	public String getAssignmentCategory() {
		return assignmentCategory;
	}
	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Distributions(String assignmentCategory, int weight) {
		super();
		this.assignmentCategory = assignmentCategory;
		this.weight = weight;
	}
	public Distributions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
