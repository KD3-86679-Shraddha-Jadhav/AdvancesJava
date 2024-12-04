import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	resp.setContentType("text/html");
    	
    	PrintWriter out = resp.getWriter();
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Info</title>");
    	out.println("</head>");
    	out.println("<body bgcolor='pink'>");
    	out.println("<h1>Student Info</h1>");
    	out.printf("<h3>firstname: Shraddha</h1>");
    	out.printf("<h3>lastname: Jadhav</h1>");
    	out.printf("<h3>Qualification: Btech(food Technology)</h1>");
    	out.printf("<h3>CollegeName: RGCFT</h1>");
    	out.printf("<h3>birthdate: 14/09/1999</h1>");
    	
    	out.println("</body>");
    	
    }
    
}
