package com.homeoffice.main;
import java.text.DecimalFormat;
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

  public String calculatePrice()
  {
    ShoppingBasketVisitor visitor = new ShoppingBasketVisitorImpl();
    DecimalFormat df = new DecimalFormat("#.##");
    double sum = 0.0;

    for (Item item : shoppingBasket.items)
    {
      sum = sum + item.accept(visitor);
    }

    return df.format(sum);
  }
}
