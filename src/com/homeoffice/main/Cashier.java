package com.homeoffice.main;
import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

public class Cashier
{

  public static void main(String[] args)
  {
    ShoppingCart shoppingCart = ShoppingCart.getInstance();

    shoppingCart.addItem(new Fruit(0.80, 5, "Banana"));
    shoppingCart.addItem(new Fruit(0.80, 3, "Banana"));
    shoppingCart.addItem(new Meat(3.99, 4, "Rump Steak"));
    shoppingCart.addItem(new Milk(0.45, 2, "Semi-skimmed"));

    System.out.println("Shopping Cart Items:");
    System.out.println();

    System.out.println("\nTotal cost: £" + shoppingCart.calculatePrice());
  }

}
