package com.swabhav.test;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.swabhav.models.DbConnection;
import com.swabhav.models.Inventory;
import com.swabhav.models.Order;
import com.swabhav.models.OrderDetail;
import com.swabhav.models.Product;
import com.swabhav.models.Supplier;
import com.swabhav.models.operations.InventoryOperations;
import com.swabhav.models.operations.OrderDetailOperations;
import com.swabhav.models.operations.OrderOperations;
import com.swabhav.models.operations.ProductOperations;
import com.swabhav.models.operations.SupplierOperations;

public class Main {

	public static void main(String[] args) {
		// started connection
		DbConnection.setupConnect();
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
		scanner.close();
		
	}
	
	public static void  menu(Scanner scanner) {
		int firstVal = firstMenu(scanner);
		int secondVal = 0;
		switch (firstVal) {
		case 1:
			secondVal = operationMenu("Product",scanner);
			operationSwitch(secondVal, "Product", scanner);
			break;
		case 2:
			secondVal = operationMenu("Order",scanner);
			operationSwitch(secondVal, "Order", scanner);
			break;
		case 3:
			secondVal = operationMenu("Inventory",scanner);
			operationSwitch(secondVal, "Inventory", scanner);

			break;
		case 4:
			secondVal = operationMenu("OrderDetails",scanner);
			operationSwitch(secondVal, "OrderDetails", scanner);

			break;
		case 5:
			secondVal = operationMenu("Supplier",scanner);
			operationSwitch(secondVal, "Supplier", scanner);

			break;
		default:
			break;
		}
	}
	
	public static Product createProduct(Scanner scanner) {
		Product product = new Product();
		System.out.println("Enter Product Id: ");
		product.setProductId(scanner.nextInt());
		System.out.println("Enter Product name: ");
		product.setName(scanner.next());
		System.out.println("Enter Product description: ");
		product.setDescription(scanner.next());
		System.out.println("Enter Product supplierId: ");
		product.setSupplier(createSupplier(scanner));
		ProductOperations.addProduct(product);
		return product;
	}
	
	public static Supplier createSupplier(Scanner scanner) {
		Supplier supplier = new Supplier();
		System.out.println("Enter Supplier Id: ");
		supplier.setSupplierId(scanner.nextInt());
		System.out.println("Enter Supplier name: ");
		supplier.setName(scanner.next());
		System.out.println("Enter Contact Info: ");
		supplier.setContactInfo(scanner.next());
		System.out.println("Enter Address: ");
		supplier.setAddress(scanner.next());
		SupplierOperations.addSupplier(supplier);
		return supplier;
	}
	
	public static Order createOrder(Scanner scanner) {
		Order order = new Order();
		System.out.println("Enter order Id: ");
		order.setOrderId(scanner.nextInt());
		System.out.println("Enter Order Date: ");
		order.setOrderDate(new Date(0));
		System.out.println("Enter Supplier Details: ");
		order.setSupplier(createSupplier(scanner));
		OrderOperations.addOrder(order);
		return order;
	}
	
	public static OrderDetail createOrderDetail(Scanner scanner) {
		OrderDetail orderDetail = new OrderDetail();
		System.out.println("Enter OrderDetail id: ");
		orderDetail.setOrderDetailId(scanner.nextInt());
		System.out.println("Enter Order: ");
		orderDetail.setOrder(createOrder(scanner));
		System.out.println("Enter Product: ");
		orderDetail.setProduct(createProduct(scanner));
		System.out.println("Enter Quantity: ");
		orderDetail.setPrice(scanner.nextDouble());
		System.out.println("Enter Price: ");
		orderDetail.setQuantity(scanner.nextInt());
		OrderDetailOperations.addOrderDetails(orderDetail);
		return orderDetail;
	}
	
	public static Inventory createInventory(Scanner scanner) {
		Inventory inventory = new Inventory();
		System.out.println("Enter inventory Id: ");
		inventory.setInventoryId(scanner.nextInt());
		System.out.println("Enter Product: ");
		inventory.setProduct(createProduct(scanner));
		System.out.println("Enter Supplier Details: ");
		inventory.setQuatityOnHand(scanner.nextInt());
		InventoryOperations.addInventory(inventory);
		return inventory;
	}
	
	public static Order updateOrder(Scanner scanner){
		Order order = new Order();
		System.out.println("Enter order Id: ");
		order.setOrderId(scanner.nextInt());
		System.out.println("Enter Order Date: ");
		order.setOrderDate(new Date(0));
		System.out.println("Enter Supplier Details: ");
		order.setSupplier(createSupplier(scanner));
		OrderOperations.updateOrder(order);
		return order;
	}
	
	public static void operationSwitch(int value, String table, Scanner scanner) {
		switch (value) {
		case 1:
			if(table.equals("Product")) createProduct(scanner);
			if(table.equals("Inventory")) createInventory(scanner);
			if(table.equals("Supplier")) createSupplier(scanner);
			if(table.equals("Order")) createOrder(scanner);
			if(table.equals("OrderDetail")) createOrderDetail(scanner);
			break;
		case 2:
			System.out.println( "Enter "+ table + " id: ");
			int productID = scanner.nextInt();
			if(table.equals("Product")) System.out.println(ProductOperations.getProduct(productID));
			if(table.equals("Inventory")) System.out.println(InventoryOperations.getInventory(productID));
			if(table.equals("Supplier")) System.out.println(SupplierOperations.getSupplier(productID));
			if(table.equals("Order")) System.out.println(OrderOperations.getOrder(productID));
			if(table.equals("OrderDetail")) System.out.println(OrderDetailOperations.getOrderDetail(productID));
			break;
		case 3:
			if(table.equals("Product")) ProductOperations.getProducts().stream().forEach(a->System.out.println(a));
			if(table.equals("Inventory")) InventoryOperations.getInventorys().stream().forEach(a->System.out.println(a));
			if(table.equals("Supplier")) SupplierOperations.getSuppliers().stream().forEach(a->System.out.println(a));
			if(table.equals("Order")) OrderOperations.getOrders().stream().forEach(a->System.out.println(a));
			if(table.equals("OrderDetail")) OrderDetailOperations.getOrderDetails().stream().forEach(a->System.out.println(a));
			break;
		case 4:
			if(table.equals("Order")) updateOrder(scanner);
		case 5:
			System.out.println("Enter " + table + " id to delete it along with its childrens");
			if(table.equals("Order")) OrderOperations.deleteOrder(scanner.nextInt());
			if(table.equals("Supplier")) SupplierOperations.deleteSupplier(scanner.nextInt());
			if(table.equals("Inventory")) InventoryOperations.deleteInventory(scanner.nextInt());
			if(table.equals("OrderDetail")) OrderDetailOperations.deleteOrderDetail(scanner.nextInt());
			if(table.equals("Product")) ProductOperations.deleteProduct(scanner.nextInt());
			break;
		default:
			break;
		}
	}
	
	public static int firstMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("Select Table to Query on:");
		System.out.println("1. Product");
		System.out.println("2. Order");
		System.out.println("3. Inventory");
		System.out.println("4. OrderDetails");
		System.out.println("5. Supplier");
		return scanner.nextInt();
	}
	
	public static int operationMenu(String name,Scanner scanner) {
		System.out.println("Select Operation:");
		System.out.println("1. Insert "+name);
		System.out.println("2. Get " +name+ " by id");
		System.out.println("3. Get all "+name + "s");
		System.out.println("4. Update "+name);
		System.out.println("5. Delete "+name);
		return scanner.nextInt();
	}
	
	public static void customQueries() {
		System.out.println("Select Operation:");
		
	}
	
}
