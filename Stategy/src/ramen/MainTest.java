package ramen;

public class MainTest {

	public static void main(String[] args) {
		Recipe[] recipes = {
				new GeneralRamenRecipe(),
				new CheeseRamenRecipe(),
				new MilkRamenRecipe(),
				new RamenWithoutBrothRecipe(),
				new VinegarRamenRecipe()
		};
		
		Ramen ramen = new Ramen();
		
		for(var recipe: recipes) {
			ramen.setRecie(recipe);
			ramen.performCook();
		}
	}

}
