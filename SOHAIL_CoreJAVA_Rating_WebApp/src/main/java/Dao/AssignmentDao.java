package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entities.Assignment;
import Helper.ConnectionProvider;
import Dao.DistributionsDao;
import Entities.Assignment;

public class AssignmentDao {
	public boolean addAssignment(Assignment a) {
		boolean b = false;

		try {
			Connection con = new ConnectionProvider().getConnection();

			String query = "insert into Assignments(StudentName,Subject,Category,dateOfSubmission,points) values(?,?,?,?,?)";
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, a.getStudentName());
			p.setString(2, a.getSubject());
			p.setString(3, a.getCategory());
			p.setString(4, a.getDateOfSubmission());
			p.setInt(5, a.getPoints());
			
			p.executeUpdate();
			b=true;
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public List<Assignment> getAllAssignments() {
		List<Assignment> assignments = new ArrayList<Assignment>();

		try {
			Connection con = new ConnectionProvider().getConnection();

			String query = "select * from Assignments";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				Assignment a = new Assignment();
				a.setId(rs.getInt("id"));
				a.setStudentName(rs.getString("StudentName"));
				a.setSubject(rs.getString("Subject"));
				a.setCategory(rs.getString("Category"));
				a.setDateOfSubmission(rs.getString("dateOfSubmission"));
				a.setPoints(rs.getInt("points"));
				assignments.add(a);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return assignments;
	}
	
	public boolean removeAssignment(int id) {
		boolean b=false;
		
		if(!getSerialNumber().contains(id)) {
			return b;
		}else {
			try {
				Connection con = new ConnectionProvider().getConnection();
				String query = "delete from assignments where id=?";
				PreparedStatement p=con.prepareStatement(query);
				p.setInt(1, id);
				p.execute();
				b=true;
				
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return b;
		}
	}
	public List<Integer> getSerialNumber(){
		List<Integer> list=new ArrayList<Integer>();
		
		try {
			Connection con = new ConnectionProvider().getConnection();

			String query = "select id from assignments";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {
				list.add(rs.getInt("id"));
			}
			
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	}
	
	public boolean updateAssignment(int id,String dos,int points) {
		boolean b=false;
		
		try {
			Connection con=new ConnectionProvider().getConnection();
			String query="update "+"assignments"+" set dateOfSubmission=? , points=?  where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, dos);
			ps.setInt(2,points);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			b=true;
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}
	public double getOverAllRating(String student, String subject, List<Assignment> assignment) {
		double rating = 0;

		rating = getScore(student, subject, "test", assignment) + getScore(student, subject, "quiz", assignment)
				+ getScore(student, subject, "lab", assignment) + getScore(student, subject, "project", assignment);

		return rating;
	}

	public double getScore(String student, String subject, String category, List<Assignment> assignment) {
		double score = 0;

		int total_assignments = 0;
		double total_points = 0;

		for (Assignment a : assignment) {
			if (a.getSubject().equals(subject)) {
				if (a.getStudentName().equals(student) && a.getCategory()
						.substring(0, a.getCategory().length() - 2).equals(category)) {
					total_assignments += 1;
					total_points += a.getPoints();
				}
			}
		}

		if (total_assignments == 0) {
			score = 0;
		} else {
			DistributionsDao dao = new DistributionsDao();
			Map<String, Integer> distributions = dao.getAllDistributions();
			score = ((distributions.get(category) / total_assignments) * total_points) / 100;
		}

		return score;
	}
	public static void main(String[] args) {
		AssignmentDao adao=new AssignmentDao();
		System.out.println(adao.getScore("Ananth", "Electro Fields", "test", adao.getAllAssignments()));
	}
}
