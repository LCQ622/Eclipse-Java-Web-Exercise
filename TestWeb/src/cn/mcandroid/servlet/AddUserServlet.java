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
import com.sun.xml.internal.bind.v2.runtime.MarshallerImpl;

import cn.mcandroid.util.DbTools;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String sex=request.getParameter("sex");
		String sql="INSERT INTO stus ( `name`,  `sex`) VALUES(?,?)";
		QueryRunner qr=new QueryRunner();
		Gson gson=new Gson();
		Map<String , String >map=new HashMap<>();
		int count=0;
		try {
			count=qr.update(DbTools.getConn(),sql,username,sex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0) {
			map.put("success", "ok");
			out.println(gson.toJson(map));
		}else {
			map.put("success", "err");
			out.println(gson.toJson(map));
		}
	}

}
