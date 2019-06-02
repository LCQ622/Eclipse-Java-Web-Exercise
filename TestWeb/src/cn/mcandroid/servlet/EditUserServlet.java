package cn.mcandroid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import cn.mcandroid.util.DbTools;
import javafx.scene.control.Alert;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/edit_user")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理类型：1为查找  2 更新
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		String sql = "SELECT id,name,sex FROM stus WHERE id="+id;
		QueryRunner qr=new QueryRunner();
		if("1".equals(type)) {
			try {
				List<Map<String,Object>>list=qr.query(DbTools.getConn(), sql,new MapListHandler());
				Map map=list.get(0);
				request.setAttribute("map",map);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");
		String username=req.getParameter("username");
		String sex=req.getParameter("sex");
		String sql="UPDATE stus SET name=?,sex=? WHERE id=?";
		QueryRunner qr=new QueryRunner();
		Gson gson=new Gson();
		Map<String , String >map=new HashMap<>();
		int count=0;
		try {
			count=qr.update(DbTools.getConn(),sql,username,sex,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(count>0) {
			map.put("edit", "ok");
			out.println(gson.toJson(map));
			
		}else {
			map.put("edit", "err");
			out.println(gson.toJson(map));
		}
	}
	
	
	

	

}
