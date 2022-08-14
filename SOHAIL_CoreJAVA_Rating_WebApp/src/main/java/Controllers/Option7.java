package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AssignmentDao;
import Entities.Assignment;

/**
 * Servlet implementation class Option7
 */

@WebServlet("/Option7")
public class Option7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Option7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String studentName=request.getParameter("studentName");
		String subject=request.getParameter("subject");
		String category=request.getParameter("category");
		String dateOfSubmission=request.getParameter("dateOfSubmission");
		int points=Integer.parseInt(request.getParameter("points"));
		
		Assignment a=new Assignment(studentName, subject, category, dateOfSubmission, points);
		AssignmentDao adao=new AssignmentDao();
		boolean addAssignment = adao.addAssignment(a);
		if(addAssignment) {
			response.getWriter().print("Successfull");
		}else {
			response.getWriter().print("Failed");
		}
//		List<Assignment> Assignment = new ArrayList<Assignment>();
//		Assignment.add(new Assignment(1, "Ananth", "Electro Fields", "test_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(2, "Bhagath", "Electro Fields", "test_1", "21-jul-16", 78));
//		Assignment.add(new Assignment(3, "Chaya", "Electro Fields", "test_1", "21-jul-16", 68));
//		Assignment.add(new Assignment(4, "Esharath", "Electro Fields", "test_1", "21-jul-16", 87));
//		Assignment.add(new Assignment(5, "Bhagath", "Electro Fields", "quiz_1", "21-jul-16", 20));
//		Assignment.add(new Assignment(6, "Chaya", "Electro Fields", "lab_1", "21-jul-16", 10));
//		Assignment.add(new Assignment(7, "Ananth", "Electro Fields", "project_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(8, "Davanth", "Electro Fields", "project_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(9, "Bhagath", "Electro Fields", "quiz_2", "21-jul-16", 50));
//		Assignment.add(new Assignment(10, "Ananth", "Electro Fields", "quiz_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(11, "Bhagath", "Electro Fields", "lab_1", "21-jul-16", 10));
//		Assignment.add(new Assignment(12, "Chaya", "Electro Fields", "project_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(13, "Bhagath", "Electro Fields", "project_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(14, "Ananth", "Computing Techniques", "test_1", "21-jul-16", 86));
//		Assignment.add(new Assignment(15, "Ananth", "Electro Fields", "quiz_2", "21-jul-16", 100));
//		Assignment.add(new Assignment(16, "Bhagath", "Computing Techniques", "project_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(17, "Ananth", "Electro Fields", "lab_1", "21-jul-16", 100));
//		Assignment.add(new Assignment(18, "Chaya", "Computing Techniques", "quiz_1", "21-jul-16", 20));
//		Assignment.add(new Assignment(19, "Ananth", "Electro Fields", "test_2", "21-jul-16", 100));
//		Assignment.add(new Assignment(20, "Chaya", "Electro Fields", "test_2", "21-jul-16", 92));
//		
//		for(Assignment aa:Assignment) {
//			adao.addAssignment(aa);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
