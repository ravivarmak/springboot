package ravi.varma.Microservices2.dto;

import lombok.Data;
@Data
public class Product {
	private int id;
	private String name;
	private double price;
	private String description;
	private String category;

}
