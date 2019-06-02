package cn.mcandroid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.google.gson.Gson;

import cn.mcandroid.util.DbTools;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/del_user")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
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
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		Map<String , String >map=new HashMap<>();
		QueryRunner qr=new QueryRunner();
		Gson gson=new Gson();
		String sql="DELETE FROM stus WHERE id=?";
		int count=0;
		try {
			count=qr.update(DbTools.getConn(),sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0) {
			map.put("del", "ok");
			out.println(gson.toJson(map));
		}else {
			map.put("del", "err");
			map.put("msg", "删除失败");
			out.println(gson.toJson(map));
		}
	}

}
