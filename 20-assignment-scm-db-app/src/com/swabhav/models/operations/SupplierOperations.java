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
import com.swabhav.models.Product;
import com.swabhav.models.Supplier;

public class  SupplierOperations {
	
	private static Connection connection = DbConnection.getConnection();

	
	public static List<Supplier> getSuppliers() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from suppliers");
			while (result.next()) {
				suppliers.add(new Supplier(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4)
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return suppliers;
	}
	
	
	
	public static Supplier getSupplier(int supplierId) {
		Supplier supplier = null;
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from suppliers where supplierId="+ supplierId);
			if (result.next()) {
				supplier = new Supplier(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return supplier;
	}
	
	public static void addSupplier(Supplier supplier) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `scm`.`suppliers` (`SupplierID`, `Name`, `ContactInfo`,`Address`) VALUES (?, ?, ?, ?)");
			statement.setInt(1, supplier.getSupplierId());
			statement.setString(2, supplier.getName());
			statement.setString(3, supplier.getContactInfo());
			statement.setString(4, supplier.getAddress());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateSupplier(Supplier newSupplier) {
		Supplier oldSupplier = getSupplier(newSupplier.getSupplierId());
		if(newSupplier.getAddress() == null) newSupplier.setAddress(oldSupplier.getAddress()); 
		if(newSupplier.getContactInfo() == null) newSupplier.setContactInfo(oldSupplier.getContactInfo()); 
		if(newSupplier.getName() == null) newSupplier.setName(oldSupplier.getName()); 
		
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE `scm`.`suppliers` SET `Name` = ?, `ContactInfo` = ?, `Address` = ?	WHERE `SupplierID` = ?");
			statement.setString(1, newSupplier.getName());
			statement.setString(2, newSupplier.getContactInfo());
			statement.setString(2, newSupplier.getAddress());
			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteSupplier(int supplierID) {
		try {
			List<Product> products = getManyProducts(supplierID);
			List<Order> orders = getManyOrders(supplierID);
			for (Product product : products) {
				ProductOperations.deleteProduct(product.getProductId());
			}
			
			for (Order order : orders) {
				OrderOperations.deleteOrder(order.getOrderId());
			}
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `scm`.`suppliers` WHERE SupplierID=?" );
			statement.setInt(1, supplierID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Product> getManyProducts(int supplierID) {
		return ProductOperations.getProducts().stream().filter(product->
			product.getSupplier().getSupplierId() == supplierID
		).collect(Collectors.toList());
	}
	
	public static List<Order> getManyOrders(int supplierID) {
		return OrderOperations.getOrders().stream().filter(order->
			order.getSupplier().getSupplierId() == supplierID
		).collect(Collectors.toList());
	}
	
	
}
