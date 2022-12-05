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
import com.moe.cnp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDao dao=new CouponDao();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("action").equals("create")) {
			createCoupon(request, response);
		}else if(request.getParameter("action").equals("find")) {
			findCoupon(request, response);

		}
		
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("couponCode");
		Coupon coupon = dao.find(code);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>coupon details:</b>");
		out.print(coupon);
		out.print("<br/><a href='/candpapp'>Home</a>");
	}
	
	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expDate = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();
		coupon.setCode(code);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expDate);

		dao.save(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>coupon created</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}

}
