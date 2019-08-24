package assignment12;

public class pizza {
	/* establishes the cost of different sizes of pizza, different sizes of toppings
	and the size of this pizza, the number of toppings, etc */

	private final double personalPrice = 8.95;
	private final double smallPrice = 12.95;
	private final double mediumPrice = 14.95;
	private final double largePrice = 16.85;
	private final double extralargePrice = 18.95;
	private final double vegetableToppingCost = .75;
	private final double meatToppingCost = 1.25;
	private final double extraToppings = 1.25;
	private int vegetableCount = 0, meatCount = 0;
	private int size = 0;
	private double total = 0;
	private double pizzaPrice = 0;
	
	// creates pizza objects based on parameters
	public pizza(){
		this.size = 1;
		this.vegetableCount = 0;
		this.meatCount = 0;
		this.total = pizzaTotal(this.size);					
	}
	public pizza(int pizzaSize, int countMeats, int countVeggies ){
		this.size = pizzaSize;
		this.vegetableCount = countVeggies;
		this.meatCount = countMeats;
		this.total = pizzaTotal(pizzaSize);
	}
	
	// method to establish what the pizza total would be
	public double pizzaTotal(int Size){
		pizzaPrice = 0;
		switch (Size){
		case 1:
			pizzaPrice = this.personalPrice;
			break;
		case 2:
			pizzaPrice = this.smallPrice;
			break;
		case 3:
			pizzaPrice = this.mediumPrice;
			break;
		case 4:
			pizzaPrice = this.largePrice;
			break;
		case 5:
			pizzaPrice = this.extralargePrice;
			break;			
		}
		
		if (this.vegetableCount + this.meatCount > 3){
			total = pizzaPrice + (
						((this.vegetableCount * this.vegetableToppingCost)
						+ (this.meatCount * this.meatToppingCost)) 
						* this.extraToppings);
			return total;
			}
		else{
			total = pizzaPrice + (
					((this.vegetableCount * this.vegetableToppingCost)
					+ (this.meatCount * this.meatToppingCost)));
		     return total;
		}
	}
	
	// setters and getters
	public double getTotal(){
		return this.total;
	}
	public int getVegetableCount(){
		return this.vegetableCount;
	}
	public int getMeatCount(){
		return this.meatCount;
	}
	public double getPrice(){
		return pizzaPrice;
	}
}

