package interfaces;

import java.util.ArrayList;

import model.Product;

public interface InterfazProducto {
	public int add(Product product);
	public int update(Product product);
	public int delete(int code);
	public Product search(int code);
	public ArrayList<Product> listProducts();
}
