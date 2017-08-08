package com.homeoffice.item;
import com.homeoffice.visitors.ShoppingBasketVisitor;

/**
 * Item element interface
 *
 */
public interface Item
{
  public double count(ShoppingBasketVisitor visitor);

  public String summary(ShoppingBasketVisitor visitor);
}
