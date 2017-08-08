package com.homeoffice.visitors;
import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

/**
 * Visitor interface
 *
 */
public interface ShoppingBasketVisitor
{
  public double visitCost(Fruit fruit);
  public String visitSummary(Fruit fruit);

  public double visitCost(Meat meat);
  public String visitSummary(Meat meat);

  public double visitCost(Milk milk);
  public String visitSummary(Milk milk);
}
