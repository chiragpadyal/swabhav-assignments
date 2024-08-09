package com.swabhav.models.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.swabhav.models.DbConnection;
import com.swabhav.models.Order;
import com.swabhav.models.OrderDetail;

public class OrderOperations {
	private static Connection connection = DbConnection.getConnection();
	public static void addOrder(Order order) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `scm`.`orders` (`OrderId`, `OrderDate`, `SupplierID`) VALUES (?, ?, ?)");
			statement.setInt(1, order.getOrderId());
			statement.setDate(2, order.getOrderDate());
			statement.setInt(3, order.getSupplier().getSupplierId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from orders");
			while (result.next()) {
				orders.add(new Order(
						result.getInt(1),
						result.getDate(2),
						SupplierOperations.getSupplier(result.getInt(3))
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public static Order getOrder(int orderID) {
		Order order = null;
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from orders where OrderID="+ orderID);
			
			if (result.next()) {
				order = (new Order(
						result.getInt(1),
						result.getDate(2),
						SupplierOperations.getSupplier(result.getInt(3))
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public static void updateOrder(Order newOrder) {
		Order oldOrder = getOrder(newOrder.getOrderId());
		if(newOrder.getOrderDate() == null) newOrder.setOrderDate(oldOrder.getOrderDate()); 
		if(newOrder.getSupplier() == null) newOrder.setSupplier(oldOrder.getSupplier());
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE `scm`.`orders` SET `OrderDate` = ?, `SupplierID` = ? WHERE (`OrderID` = ?)" );
			statement.setDate(1, newOrder.getOrderDate());
			statement.setInt(2, newOrder.getSupplier().getSupplierId());
			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteOrder(int orderID) {
		try {
			List<OrderDetail> orderDetails = getManyOrderDetail(orderID);
			for (OrderDetail orderDetail : orderDetails) {
				OrderDetailOperations.deleteOrderDetail(orderDetail.getOrderDetailId());
			}
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `scm`.`orders` WHERE OrderID=?" );
			statement.setInt(1, orderID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<OrderDetail> getManyOrderDetail(int orderID) {
		return OrderDetailOperations.getOrderDetails().stream().filter(orderDetail->
			orderDetail.getOrder().getOrderId() == orderID
		).collect(Collectors.toList());
	}
	
	
	
}
