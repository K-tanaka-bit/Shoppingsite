package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.aforce.entity.ShoppingBean;

public class UserShoppingDAO extends DAO  {
	
	public List<ShoppingBean> search() throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM m_item;");

		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setItem_id(res.getInt("item_id"));
			shop.setItem_name(res.getString("item_name"));
			shop.setPrice(res.getInt("price"));
			shop.setCategory_id(res.getInt("category_id"));
			shop.setItem_img(res.getString("item_img"));
			shop.setItem_value(res.getInt("item_value"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
	
	public ShoppingBean user_info(String user_id) throws Exception {
		ShoppingBean user_info = new ShoppingBean();
		
		Connection con =getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user WHERE user_id=?");
		pstmt.setString(1, user_id);
		ResultSet res = pstmt.executeQuery();
		while (res.next()) {
			user_info.setUser_id(res.getString("user_id"));
			user_info.setUser_name(res.getString("user_name"));
			user_info.setAdress_post(res.getString("adress_post"));
			user_info.setAdress(res.getString("adress"));
			
		}
		return user_info;
	}
	
	public List<ShoppingBean> payment() throws Exception {
		List<ShoppingBean> list =new ArrayList<ShoppingBean>();
		
		Connection con =getConnection();
		Statement stmt = con.createStatement();
		
		ResultSet res = stmt.executeQuery("SELECT * FROM m_payment_method;");
		
		
		while (res.next()) {
			ShoppingBean pay_info = new ShoppingBean();
			pay_info.setPayment_method_id(res.getInt("payment_method_id"));
			pay_info.setPayment_method(res.getString("payment_method"));
			list.add(pay_info);
		}
		return list;
	}
	
	public Map<Integer, String> paymentmap() throws Exception {
		Map<Integer, String> paymentmap = new HashMap<Integer, String>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM m_payment_method;");

		while (res.next()) {
			paymentmap.put(res.getInt("payment_method_id"), res.getString("payment_method"));
		}
		return paymentmap;
	}
	
	public boolean insert(List<ShoppingBean> cart,ShoppingBean customer) throws Exception {
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		for(ShoppingBean c :cart) {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO t_history(order_no,item_id,subtotal_price,item_count,price) VALUES(?,?,?,?,?)");
			pstmt.setString(1, customer.getOrder_no());
			pstmt.setInt(2, c.getItem_id());
			pstmt.setInt(3, c.getSubtotal_price());
			pstmt.setInt(4, c.getItem_count());
			pstmt.setInt(5, c.getPrice());
			int line =pstmt.executeUpdate();
			pstmt.close();
			
			if(line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false ;
			}
		}
		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
	}
	
	public boolean insert(ShoppingBean customer) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO order_number(order_no,customer_name,adress_post,adress,total_price,payment_method_id,user_id) VALUES(?,?,?,?,?,?,?)");

		pstmt.setString(1, customer.getOrder_no());
		pstmt.setString(2, customer.getCustomer_name());
		pstmt.setString(3,customer.getAdress_post());
		pstmt.setString(4, customer.getAdress());
		pstmt.setInt(5, customer.getTotal_price());
		pstmt.setInt(6,customer.getPayment_method_id());
		pstmt.setString(7, customer.getUser_id());
		pstmt.executeUpdate();
		return true;

	}
	
	
	public String select(String order_no) throws Exception{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"select order_no from order_number where order_no in(select order_no from t_history where order_no=?)");
		
		pstmt.setString(1,order_no);
		ResultSet res = pstmt.executeQuery();
	   while (res.next()) {
		order_no=res.getString("order_no");
	}
		return order_no;

}		
		
	public List<ShoppingBean> searchCategory(int category_id) throws Exception {
			List<ShoppingBean> shoppingList = new ArrayList<>();
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_item WHERE category_id=? ;");
			pstmt.setInt(1,category_id);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				ShoppingBean shop = new ShoppingBean();
				shop.setItem_id(res.getInt("item_id"));
				shop.setItem_name(res.getString("item_name"));
				shop.setPrice(res.getInt("price"));
				shop.setCategory_id(res.getInt("category_id"));
				shop.setItem_img(res.getString("item_img"));
				shop.setItem_value(res.getInt("item_value"));
				shoppingList.add(shop);
			}
			return shoppingList;
		}
	
	public List<ShoppingBean> searchKeyword(String keyword) throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_item WHERE item_name Like ?;");
		pstmt.setString(1,"%"+keyword+"%");
		ResultSet res = pstmt.executeQuery();

		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setItem_id(res.getInt("item_id"));
			shop.setItem_name(res.getString("item_name"));
			shop.setPrice(res.getInt("price"));
			shop.setCategory_id(res.getInt("category_id"));
			shop.setItem_img(res.getString("item_img"));
			shop.setItem_value(res.getInt("item_value"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
	public List<ShoppingBean> searchPrice(int minPrice,int maxPrice) throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_item WHERE price>=? AND price<=? order by price asc ;");
		pstmt.setInt(1, minPrice);
		pstmt.setInt(2, maxPrice);
		ResultSet res = pstmt.executeQuery();

		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setItem_id(res.getInt("item_id"));
			shop.setItem_name(res.getString("item_name"));
			shop.setPrice(res.getInt("price"));
			shop.setCategory_id(res.getInt("category_id"));
			shop.setItem_img(res.getString("item_img"));
			shop.setItem_value(res.getInt("item_value"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
	
	public List<ShoppingBean> searchOrder() throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM order_number;");

		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setOrder_no(res.getString("order_no"));
			shop.setBuy_date(res.getDate("buy_date"));
			shop.setCustomer_name(res.getString("customer_name"));
			shop.setAdress_post(res.getString("adress_post"));
			shop.setAdress(res.getString("adress"));
			shop.setTotal_price(res.getInt("total_price"));
			shop.setPayment_method_id(res.getInt("payment_method_id"));
			shop.setUser_id(res.getString("user_id"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
	
	public List<ShoppingBean> searchHistory() throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM t_history;");

		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setOrder_no(res.getString("order_no"));
			shop.setItem_id(res.getInt("item_id"));
			shop.setItem_count(res.getInt("item_count"));
			shop.setSubtotal_price(res.getInt("subtotal_price"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
	public List<ShoppingBean> searchHistory_no(String order_no) throws Exception {
		List<ShoppingBean> shoppingList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM t_history where order_no=?;");
		pstmt.setString(1,order_no);
		ResultSet res = pstmt.executeQuery();
		while (res.next()) {
			ShoppingBean shop = new ShoppingBean();
			shop.setOrder_no(res.getString("order_no"));
			shop.setItem_id(res.getInt("item_id"));
			shop.setItem_count(res.getInt("item_count"));
			shop.setSubtotal_price(res.getInt("subtotal_price"));
			shop.setPrice(res.getInt("price"));
			shoppingList.add(shop);
		}
		return shoppingList;
	}
}
