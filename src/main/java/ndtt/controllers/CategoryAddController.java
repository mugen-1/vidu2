package ndtt.controllers;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import ndtt.services.CategoryService;
import ndtt.services.impl.CategoryServiceImpl;
import ndtt.utils.Constant;
import ndtt.models.CategoryModel;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		try {
			String cateName = req.getParameter("cate_name");
			Part filePart = req.getPart("icons");

			CategoryModel category = new CategoryModel();
			category.setName(cateName);

			if (filePart != null && filePart.getSize() > 0) {
				String originalFileName = filePart.getSubmittedFileName();
				String newFileName = System.currentTimeMillis() + "_" + originalFileName;

				String uploadPath = Constant.DIR;
				filePart.write(uploadPath + File.separator + newFileName);

				category.setIcon(newFileName);
			}

			cateService.insert(category); // 

			resp.sendRedirect(req.getContextPath() + "/admin/category/list");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
