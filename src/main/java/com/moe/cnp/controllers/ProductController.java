package com.moe.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moe.cnp.dao.CouponDao;
import com.moe.cnp.dao.ProductDao;
import com.moe.cnp.model.Coupon;
import com.moe.cnp.model.Product;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/productss")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao=new ProductDao();
	private CouponDao cDao=new CouponDao();

	public ProductController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = cDao.find(couponCode);
		
		

		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		
		dao.save(product);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>product created</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}

}
