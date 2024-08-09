package com.swabhav.models.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swabhav.models.DbConnection;
import com.swabhav.models.Inventory;
import com.swabhav.models.OrderDetail;

public class InventoryOperations {
	private static Connection connection = DbConnection.getConnection();
	public static void addInventory(Inventory inventory) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `scm`.`inventory` (`InventoryID`, `ProductID`, `QuantityOnHand`) VALUES (?, ?, ?)");
			statement.setInt(1, inventory.getInventoryId());
			statement.setInt(2, inventory.getProduct().getProductId());
			statement.setInt(3, inventory.getQuatityOnHand());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Inventory> getInventorys() {
		List<Inventory> inventorys = new ArrayList<Inventory>();
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from inventory");
			while (result.next()) {
				inventorys.add(new Inventory(
						result.getInt(1),
						ProductOperations.getProduct(result.getInt(2)),
						result.getInt(3)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return inventorys;
	}
	
	public static Inventory getInventory(int inventoryID) {
		Inventory inventory = null;
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from inventory where inventoryID=" + inventoryID);
			if (result.next()) {
				inventory = (new Inventory(
						result.getInt(1),
						ProductOperations.getProduct(result.getInt(2)),
						result.getInt(3)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return inventory;
	}
	
	public static void deleteInventory(int inventoryID) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `scm`.`inventory` WHERE inventoryID=?" );
			statement.setInt(1, inventoryID);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
