package com.swabhav.models.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.swabhav.models.DbConnection;
import com.swabhav.models.Inventory;
import com.swabhav.models.Order;
import com.swabhav.models.OrderDetail;
import com.swabhav.models.Product;

public class ProductOperations {
	
	private static Connection connection = DbConnection.getConnection();
	
	public static void addProduct(Product product) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `scm`.`products` (`ProductID`, `Name`, `Description`,`SupplierID`) VALUES (?, ?, ?, ?)");
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getDescription());
			statement.setInt(4, product.getSupplier().getSupplierId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Product getProduct(int productID) {
		Product product = null;
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from products where productID="+ productID);
			if (result.next()) {
				product = new Product(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						SupplierOperations.getSupplier(result.getInt(4))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from products");
			while (result.next()) {
				products.add(new Product(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						SupplierOperations.getSupplier(result.getInt(4))
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public static void deleteProduct(int productID) {
		try {
			List<Inventory> inventorys = getManyInventory(productID);
			List<OrderDetail> orderDetails = getManyOrderDetail(productID);
			for (Inventory inventory : inventorys) {
				InventoryOperations.deleteInventory(inventory.getInventoryId());
			}
			
			for (OrderDetail orderDetail : orderDetails) {
				OrderDetailOperations.deleteOrderDetail(orderDetail.getOrderDetailId());
			}
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `scm`.`products` WHERE productID=?" );
			statement.setInt(1, productID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Inventory> getManyInventory(int productID) {
		return InventoryOperations.getInventorys().stream().filter(inventory->
		inventory.getProduct().getProductId() == productID
		).collect(Collectors.toList());
	}
	
	public static List<OrderDetail> getManyOrderDetail(int productID){
		return OrderDetailOperations.getOrderDetails().stream().filter(orderdetail -> orderdetail.getProduct().getProductId() == productID).collect(Collectors.toList());
	}
}
