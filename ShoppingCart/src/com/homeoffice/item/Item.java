package com.homeoffice.item;
import com.homeoffice.visitors.ShoppingCartVisitor;

public interface Item
{
  public double accept(ShoppingCartVisitor visitor);
}
