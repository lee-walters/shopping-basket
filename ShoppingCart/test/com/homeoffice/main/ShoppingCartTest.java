package com.homeoffice.main;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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
        shoppingCart.addItem(new Meat(2.00, 3, "Chicken"));

        Thread.currentThread();
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }

        assertThat(shoppingCart.calculatePrice(), is("6.00"));
      }
    };

    Runnable run2 = new Runnable()
    {
      @Override
      public void run()
      {
        shoppingCart.addItem(new Meat(1.00, 5, "Turkey"));
      }
    };

    new Thread(run1).start();
    new Thread(run2).start();
  }
}
