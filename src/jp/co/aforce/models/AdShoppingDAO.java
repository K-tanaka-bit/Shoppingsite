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

;

public class AdShoppingDAO extends DAO {

	public boolean select(String user_id, String password) throws Exception {

		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user WHERE user_id = ? AND password = ? ");

		pstmt.setString(1, user_id);
		pstmt.setString(2, password);

		ResultSet res = pstmt.executeQuery();

		if (res.next()) {
			return true;
		}
		return false;
	}

	public boolean selectId(String user_id) throws Exception {

		if (user_id.contains("A")) {
			return true;
		}
		return false;
	}

	public Map<String, String> selectName() throws Exception {

		Map<String, String> namemap = new HashMap<String, String>();

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT user_id,user_name FROM m_user;");

		while (res.next()) {
			namemap.put(res.getString("user_id"), res.getString("user_name"));
		}
		return namemap;
	}

	public Map<Integer, String> selectCategory() throws Exception {
		Map<Integer, String> categorymap = new HashMap<Integer, String>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT category_id,category_name FROM m_category;");

		while (res.next()) {
			categorymap.put(res.getInt("category_id"), res.getString("category_name"));
		}
		return categorymap;
	}

	public int insert(ShoppingBean shop) throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO m_item(item_name,price,category_id,item_img,item_value) VALUES(?,?,?,?,?)");

		pstmt.setString(1, shop.getItem_name());
		pstmt.setInt(2, shop.getPrice());
		pstmt.setInt(3, shop.getCategory_id());
		pstmt.setString(4, shop.getItem_img());
		pstmt.setInt(5, shop.getItem_value());

		count = pstmt.executeUpdate();
		return count;

	}

	public List<ShoppingBean> selectAll() throws Exception {
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

	public int update(ShoppingBean shop) throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("UPDATE  m_item SET item_name=?,price=?,category_id=?,"
				+ "item_img=?,item_value=? WHERE item_id=?");

		pstmt.setString(1, shop.getItem_name());
		pstmt.setInt(2, shop.getPrice());
		pstmt.setInt(3, shop.getCategory_id());
		pstmt.setString(4, shop.getItem_img());
		pstmt.setInt(5, shop.getItem_value());
		pstmt.setInt(6, shop.getItem_id());

		count = pstmt.executeUpdate();
		return count;
	}

	public ShoppingBean selectItem(int item_id) throws Exception {
		ShoppingBean item = new ShoppingBean();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_item WHERE item_id = ?");
		pstmt.setInt(1, item_id);
		ResultSet res = pstmt.executeQuery();

		if (res.next()) {
			item.setItem_id(res.getInt("item_id"));
			item.setItem_name(res.getString("item_name"));
			item.setPrice(res.getInt("price"));
			item.setCategory_id(res.getInt("category_id"));
			item.setItem_img(res.getString("item_img"));
			item.setItem_value(res.getInt("item_value"));

		} else {
			return null;
		}
		return item;

	}
	public int delete(int item_id)throws Exception {
		int count = 0;
		
		Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE  FROM m_item WHERE  item_id=?");
			
			pstmt.setInt(1, item_id);
			
			count=pstmt.executeUpdate();
		
		return count;
	}
	public Map<Integer, String> selectItem() throws Exception {

		Map<Integer, String> itemmap = new HashMap<Integer, String>();

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("SELECT item_id,item_name FROM m_item;");

		while (res.next()) {
			itemmap.put(res.getInt("item_id"), res.getString("item_name"));
		}
		return itemmap;
	}

}
