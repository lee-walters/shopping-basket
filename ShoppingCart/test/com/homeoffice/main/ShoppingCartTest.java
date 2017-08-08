package com.homeoffice.main;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.homeoffice.item.elements.Meat;

public class ShoppingCartTest
{
  private static ShoppingCart shoppingCart;

  @BeforeClass
  public static void testSetup()
  {
    shoppingCart = ShoppingCart.getInstance();
  }

  @Test
  public void shouldCreateInstanceOfShoppingCart()
  {
    assertNotNull(shoppingCart);
  }

  @Test
  public void shouldBeThreadSafe()
  {
    Runnable run1 = new Runnable()
    {
      @Override
      public void run()
      {
        shoppingCart.addItem(new Meat(1.99, 3, "Chicken"));
      }
    };

    Runnable run2 = new Runnable()
    {
      @Override
      public void run()
      {
        shoppingCart.addItem(new Meat(1.49, 5, "Turkey"));
      }
    };

    Thread t1 = new Thread(run1);
    Thread t2 = new Thread(run2);

    t1.start();
    t2.start();

    System.out.println(shoppingCart.calculatePrice());
  }
}
