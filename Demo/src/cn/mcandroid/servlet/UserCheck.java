package cn.mcandroid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


/**
 * Servlet implementation class UserCheck
 */
@WebServlet("/usercheck")
public class UserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HashMap<String, String>map=new HashMap<String,String>();
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if (proving(username, pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("pwd", pwd);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
	
			map.put("result", "ok");
			out.println(gson.toJson(map));
		} else {
			//response.sendRedirect("login.jsp");
			
			map.put("result", "err");
			map.put("msg","请检查用户名或密码是否正确！");
			out.println(gson.toJson(map));
		}
	}

	/**
	 * 该方法用于校验用户
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean proving(String username, String pwd) {
		if ("admin".equals(username) && "123456".equals(pwd)) {
			return true;
		}
		return false;
	}
}
