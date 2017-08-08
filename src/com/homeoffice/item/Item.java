package com.homeoffice.item;
import com.homeoffice.visitors.ShoppingBasketVisitor;

public interface Item
{
  public double accept(ShoppingBasketVisitor visitor);
}
