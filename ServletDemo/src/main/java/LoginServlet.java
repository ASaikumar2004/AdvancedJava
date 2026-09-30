
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		response.setContentType("text/html");
		
		if(username.equals("sai") && password.equals("1234")) {
			
			response.getWriter().println("<h1>Login successful</h1>");
			
		}
		else {
			response.getWriter().println("<h1>Invlid username or password</h1>");
		}
	}
}
