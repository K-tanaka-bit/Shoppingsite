package jp.co.aforce.entity;

import java.io.Serializable;
import java.sql.Date;

public class ShoppingBean implements Serializable {

	private String user_id;
	private String user_name;
	private String password;
	private String adress_post;
	private String adress;
	private int item_id;
	private String item_name;
	private int price;
	private String item_img;
	private int item_value;
	private int category_id;
	private String category_name;
	private int payment_method_id;
	private String payment_method;
	private int history_id;
	private Date buy_date;
	private int total_price;
	private int item_count;
	private int subtotal_price;
	private String customer_name;
	private String order_no;
	
	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getSubtotal_price() {
		return subtotal_price;
	}

	public void setSubtotal_price(int subtotal_price) {
		this.subtotal_price = subtotal_price;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress_post() {
		return adress_post;
	}

	public void setAdress_post(String adress_post) {
		this.adress_post = adress_post;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItem_img() {
		return item_img;
	}

	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}

	public int getItem_value() {
		return item_value;
	}

	public void setItem_value(int item_value) {
		this.item_value = item_value;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(int payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
