package com.swabhav.models.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swabhav.models.DbConnection;
import com.swabhav.models.OrderDetail;

public class OrderDetailOperations {
	private static Connection connection = DbConnection.getConnection();

	public static void addOrderDetails(OrderDetail orderDetail) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `scm`.`orderdetails` (`OrderDetailId`, `OrderId`, `ProductID`, `Quantity`, `Price`) VALUES (?, ?, ?, ?, ?)");
			statement.setInt(1, orderDetail.getOrderDetailId());
			statement.setInt(2, orderDetail.getOrder().getOrderId());
			statement.setInt(3, orderDetail.getProduct().getProductId());
			statement.setInt(4, orderDetail.getQuantity());
			statement.setDouble(5, orderDetail.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<OrderDetail> getOrderDetails() {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from orderdetails");
			while (result.next()) {
				orderDetails.add(new OrderDetail(
						result.getInt(1),
						OrderOperations.getOrder(result.getInt(2)),
						ProductOperations.getProduct(result.getInt(3)),
						result.getInt(4),
						result.getDouble(5)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderDetails;
	}
	
	public static OrderDetail getOrderDetail(int orderDetailID) {
		OrderDetail orderDetail= null;
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from orderdetails where OrderDetailID="+orderDetailID);
			if (result.next()) {
				orderDetail = (new OrderDetail(
						result.getInt(1),
						OrderOperations.getOrder(result.getInt(3)),
						ProductOperations.getProduct(result.getInt(2)),
						result.getInt(3),
						result.getDouble(3)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderDetail;
	}
	
	public static void deleteOrderDetail(int orderDetailID) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `scm`.`orderdetails` WHERE OrderDetailID=?" );
			statement.setInt(1, orderDetailID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
