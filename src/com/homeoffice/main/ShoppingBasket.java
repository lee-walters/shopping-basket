package com.homeoffice.main;
import java.util.ArrayList;
import java.util.Arrays;

import com.homeoffice.item.Item;
import com.homeoffice.visitors.ShoppingBasketVisitor;
import com.homeoffice.visitors.ShoppingBasketVisitorImpl;

/**
 * Singleton ShoppingBasket Class
 *
 */
public class ShoppingBasket
{
  private static ShoppingBasket shoppingBasket = null;

  private ArrayList<Item> items;

  private ShoppingBasket()
  {
    items = new ArrayList<>();
  }

  public static ShoppingBasket getInstance()
  {
    if (shoppingBasket == null)
    {
      synchronized (ShoppingBasket.class)
      {
        if (shoppingBasket == null)
        {
          shoppingBasket = new ShoppingBasket();
        }
      }
    }

    return shoppingBasket;
  }

  public void addItem(Item... item)
  {
    shoppingBasket.items.addAll(Arrays.asList(item));
  }

  public String getItemsSummary()
  {
    ShoppingBasketVisitor visitor = new ShoppingBasketVisitorImpl();
    StringBuilder builder = new StringBuilder();

    for (Item item : shoppingBasket.items)
    {
      builder.append(item.summary(visitor)).append("\n");
    }

    return builder.toString();
  }

  public int getItemsCount()
  {
    return shoppingBasket.items.size();
  }

  public double calculateTotalPrice()
  {
    ShoppingBasketVisitor visitor = new ShoppingBasketVisitorImpl();
    double sum = 0.0;

    for (Item item : shoppingBasket.items)
    {
      sum = sum + item.count(visitor);
    }

    return sum;
  }
}
