import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign01.Marks;





@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	
	ArrayList <Marks> result;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		result = new ArrayList<>();
		result.add(new Marks("Java programming",80.0));
		result.add(new Marks("Web programming",85.0));
		result.add(new Marks("Database Technoogy",83.0));
		result.add(new Marks("Data structure",85.0));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<html>");
    	out.println("<head>");
    	out.println("<title>IStudent Info</title>");
    	out.println("</head>");
    	out.println("<body>");
		for(Marks m:result) {
			
			out.println("<tr>");
			out.printf("<td>%s<td>\r\n", m.getSubject());
			out.printf("<td>%.2f<td>\r\n", m.getMarks());
			out.println("</tr>"); 
			}
		out.println("</body>");
		out.println("</html>");
		  
	}
 
	
}
