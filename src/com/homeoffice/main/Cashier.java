package com.homeoffice.main;
import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

public class Cashier
{

  public static void main(String[] args)
  {
    ShoppingBasket shoppingBasket = ShoppingBasket.getInstance();

    shoppingBasket.addItem(new Fruit(0.80, 5, "Banana"));
    shoppingBasket.addItem(new Fruit(0.80, 3, "Banana"));
    shoppingBasket.addItem(new Meat(3.99, 4, "Rump Steak"));
    shoppingBasket.addItem(new Milk(0.45, 2, "Semi-skimmed"));

    System.out.println("Shopping Basket Items:");
    System.out.println();

    System.out.println("\nTotal cost: £" + shoppingBasket.calculatePrice());
  }

}
