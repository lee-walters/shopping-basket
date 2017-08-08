package com.homeoffice.visitors;
import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

public interface ShoppingCartVisitor
{
  public double visit(Fruit fruit);
  public double visit(Meat meat);
  public double visit(Milk milk);
}
