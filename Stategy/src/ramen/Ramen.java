package ramen;

public class Ramen {
	Recipe recipe = null;

	public Ramen() {
		this(new GeneralRamenRecipe());
	}
	public Ramen(Recipe recie) {
		this.recipe = recie;
	}
	
	public Recipe getRecie() {
		return recipe;
	}
	public void setRecie(Recipe recie) {
		this.recipe = recie;
	}
	
	public void performCook() {
		recipe.cook();
	}
	
}
