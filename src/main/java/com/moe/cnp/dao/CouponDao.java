package com.moe.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moe.cnp.model.Coupon;
import com.moe.cnp.util.ConnectionUtil;

public class CouponDao {

	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Coupon find(String code) {
		Coupon coupon = new Coupon();
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from coupon where code=?");
			statement.setString(1, code);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				coupon.setId(result.getInt(1));
				coupon.setCode(result.getString(2));
				coupon.setDiscount(result.getBigDecimal(3));
				coupon.setExpDate(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}
}
