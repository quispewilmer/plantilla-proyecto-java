package model;

public class Category {
	private int idCategory;
	private String CategoryDescription;

	public Category() {
	}

	public Category(int idCategory, String categoryDescription) {
		this.idCategory = idCategory;
		CategoryDescription = categoryDescription;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

}
