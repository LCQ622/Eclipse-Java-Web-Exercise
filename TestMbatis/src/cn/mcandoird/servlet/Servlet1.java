package cn.mcandoird.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.page.Page;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.PageService;
import cn.mcandoird.service.impl.PageServiceImpl;

@WebServlet("/index")
public class Servlet1 extends HttpServlet {
	private PageService pageService = new PageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String startstr = req.getParameter("start");
		String sizestr = req.getParameter("size");
		int start = 1;
		int size=10;
		if (startstr != null && !startstr.equals("")) {
			if(Integer.parseInt(startstr)>=1)
			start = Integer.parseInt(startstr);
		}
		if(sizestr!=null&&!sizestr.equals("")) {
			size=Integer.parseInt(sizestr);
		}
		Page page =pageService.showPage(start, size);
		req.setAttribute("page", page);
		req.getRequestDispatcher("01.jsp").forward(req, resp);
	}

}
