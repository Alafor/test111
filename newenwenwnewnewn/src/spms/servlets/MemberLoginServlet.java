package spms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.r;
import spms.dao.MemberDao;
import spms.dto.Member;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login/Login.jsp");
		rd.forward(request, response);
		/*ServletContext sc = request.getServletContext();
		MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
		int result = memberDao.delete(Integer.parseInt(request.getParameter("no")));*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
		Member member = memberDao.exist(request.getParameter("email"),request.getParameter("password"));
		if(member != null) {
			System.out.println("1");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
			System.out.println("222");
			
			response.sendRedirect("member/list");

		}else {
			response.sendRedirect("login");
			
		}

		
		/*response.sendRedirect("../member/list");*/
		
		
	}

}
