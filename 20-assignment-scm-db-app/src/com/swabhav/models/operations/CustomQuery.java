package com.swabhav.models.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swabhav.models.Supplier;


public class CustomQuery {
	
	public void listAllProductWithSupplierName() {
		System.out.println(ProductOperations.getProducts());
	}
	
	public void listAllOrderWithOrderDetailsAndProduct() {
		System.out.println(OrderDetailOperations.getOrderDetails());
	}
	
	public List<Supplier> supplierWithProductID(int productID, Connection connection) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try {
		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT s.SupplierID, DISTINCT s.Name AS SupplierName"+
					"FROM Suppliers as s"+
					"JOIN Products p ON s.SupplierID = p.SupplierID"+
					"WHERE p.ProductID = " + productID
					);
			while(result.next()) {
				suppliers.add(
						new Supplier(result.getInt(1), result.getString(2), null, null)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliers;
	}
	
	public void listAllProductWithInventory() {
		System.out.println(InventoryOperations.getInventorys());
	}
	
	
}
