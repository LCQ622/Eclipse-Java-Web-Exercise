package cn.mcandroid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;


import cn.mcandroid.util.DbTools;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/get_data")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GetDataServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String sql = "SELECT id,name,IF(sex='M','男','女')AS 'sex'FROM stus";
		QueryRunner qr=new QueryRunner();
		
		
		try {
			List<Map<String, Object>> list = qr.query(DbTools.getConn(), sql,new MapListHandler());
			request.setAttribute("list", list);
			request.getRequestDispatcher("list1.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
