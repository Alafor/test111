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

import oracle.net.aso.r;
import spms.dao.MemberDao;
import spms.dto.Member;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		MemberDao memberDao  = (MemberDao)sc.getAttribute("memberDao");
		Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("MemberUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
		Member member = new Member().setEmail(request.getParameter("email"))
				.setName(request.getParameter("name"))
				.setPassword(request.getParameter("password"));
		memberDao.update(member);
		response.sendRedirect("list");
	}

}
