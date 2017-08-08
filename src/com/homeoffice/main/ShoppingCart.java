package com.homeoffice.main;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import com.homeoffice.item.Item;
import com.homeoffice.visitors.ShoppingCartVisitor;
import com.homeoffice.visitors.ShoppingCartVisitorImpl;

/**
 * Singleton ShoppingCart Class
 *
 */
public class ShoppingCart
{
  private static ShoppingCart shoppingCart = null;

  private ArrayList<Item> items;

  private ShoppingCart()
  {
    items = new ArrayList<>();
  }

  public static ShoppingCart getInstance()
  {
    if (shoppingCart == null)
    {
      synchronized (ShoppingCart.class)
      {
        if (shoppingCart == null)
        {
          shoppingCart = new ShoppingCart();
        }
      }
    }

    return shoppingCart;
  }

  public void addItem(Item... item)
  {
    shoppingCart.items.addAll(Arrays.asList(item));
  }

  public void removeItem(Item item)
  {
    shoppingCart.items.remove(item);
  }

  public String calculatePrice()
  {
    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
    DecimalFormat df = new DecimalFormat("#.##");
    double sum = 0.0;

    for (Item item : shoppingCart.items)
    {
      sum = sum + item.accept(visitor);
    }

    return df.format(sum);
  }
}
