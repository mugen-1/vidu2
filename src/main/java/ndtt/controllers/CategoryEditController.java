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


@WebServlet(urlPatterns = { "/admin/category/edit" })

public class CategoryEditController extends HttpServlet {
	
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
        CategoryModel category = cateService.get(Integer.parseInt(id));
        req.setAttribute("category", category);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            int cateId = Integer.parseInt(req.getParameter("cate_id"));
            String cateName = req.getParameter("cate_name");
            
            // Lấy file upload
            Part filePart = req.getPart("icons");

            CategoryModel category = new CategoryModel();
            category.setId(cateId);           
            category.setName(cateName);

            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = filePart.getSubmittedFileName();
                String newFileName = System.currentTimeMillis() + "_" + originalFileName;
                String uploadPath = Constant.DIR;
                filePart.write(uploadPath + File.separator + newFileName);
                category.setIcon(newFileName);
            }
            
            cateService.edit(category);
            
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
