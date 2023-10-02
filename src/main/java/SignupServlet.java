

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String errorMessage = "";
		
		if (email != null && email.contains("@") && pass != null && pass.length() >= 5) {
			
	        // Valid email and password format, redirect to admission form
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
	        response.sendRedirect("admissionForm.jsp");
	    } else {
	        // Invalid email or password format, redirect to error page
	        errorMessage = "Invalid email or password format. Email must contain '@' symbol and password must be at least 5 characters long.";
	    }
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>Error</title></head><body>");
	    out.println("<h1>Error</h1>");
	    out.println("<p>" + errorMessage + "</p>");
	    out.println("<a href='signup.jsp'>Go back to signup page</a>");
	    out.println("</body></html>");

	    out.close();
	}

}
