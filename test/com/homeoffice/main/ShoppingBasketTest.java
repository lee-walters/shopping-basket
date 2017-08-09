package com.homeoffice.main;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

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

        assertThat(shoppingBasket.calculateTotalPrice(), is(6.00));
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
    int preAdditionSize = shoppingBasket.getItemsCount();
    shoppingBasket.addItem(new Milk(0.45, 2, "Semi-skimmed"));

    assertThat(shoppingBasket.getItemsCount(), is(greaterThan(preAdditionSize)));
  }

  @Test
  public void shouldCalculateTotalPriceOfShoppingBasket()
  {
    double initialTotalPrice = shoppingBasket.calculateTotalPrice();

    Fruit pear = new Fruit(0.70, 1, "Pear");

    shoppingBasket.addItem(pear);

    assertThat(shoppingBasket.calculateTotalPrice(), is(initialTotalPrice + (pear.getPricePerKg() * pear.getWeight())));
  }

  @Test
  public void shouldUseDefaultUnitCostValueIfRequired()
  {
    double initialTotalPrice = shoppingBasket.calculateTotalPrice();

    Meat chicken = new Meat(5, "Chicken");

    shoppingBasket.addItem(chicken);

    double postAdditionPrice = shoppingBasket.calculateTotalPrice();

    assertThat(postAdditionPrice - initialTotalPrice, is(9.95));
  }
}
