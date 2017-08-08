package com.homeoffice.main;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.homeoffice.item.elements.Meat;

public class ShoppingBasketTest
{
  private static ShoppingBasket shoppingBasket;

  @BeforeClass
  public static void testSetup()
  {
    shoppingBasket = ShoppingBasket.getInstance();
  }

  @Test
  public void shouldCreateInstanceOfShoppingBasket()
  {
    assertNotNull(shoppingBasket);
  }

  @Test
  public void shouldBeThreadSafe()
  {
    Runnable run1 = new Runnable()
    {
      @Override
      public void run()
      {
        shoppingBasket.addItem(new Meat(2.00, 3, "Chicken"));

        Thread.currentThread();
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }

        assertThat(shoppingBasket.calculatePrice(), is("6.00"));
      }
    };

    Runnable run2 = new Runnable()
    {
      @Override
      public void run()
      {
        shoppingBasket.addItem(new Meat(1.00, 5, "Turkey"));
      }
    };

    new Thread(run1).start();
    new Thread(run2).start();
  }

  @Test
  public void shouldAddAnItemToTheShoppingBasket()
  {

  }

  @Test
  public void shouldCalculateTotalPriceOfShoppingBasket()
  {

  }
}
