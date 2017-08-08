package com.homeoffice.visitors;
import java.text.DecimalFormat;

import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

/**
 * Implementation of visitor interface dealing with specifics of individual items
 *
 */
public class ShoppingBasketVisitorImpl implements ShoppingBasketVisitor
{
  private DecimalFormat df = new DecimalFormat("#.##");

  @Override
  public double visitCost(Fruit fruit)
  {
    double cost = fruit.getPricePerKg() * fruit.getWeight();
    System.out.println(fruit.getName() + " ("+df.format(fruit.getPricePerKg())+" per kg)" + " cost = £" + df.format(cost));
    return cost;
  }

  @Override
  public String visitSummary(Fruit fruit)
  {
    return fruit.getWeight() + "kg" + " of " + fruit.getName();
  }

  @Override
  public double visitCost(Meat meat)
  {
    double cost = meat.getPricePerKg() * meat.getWeight();
    System.out.println(meat.getName() + " ("+df.format(meat.getPricePerKg())+" per kg)" + " cost = £" + df.format(cost));
    return cost;
  }

  @Override
  public String visitSummary(Meat meat)
  {
    return meat.getWeight() + "kg" + " of " + meat.getName();
  }

  @Override
  public double visitCost(Milk milk)
  {
    double cost = milk.getPricePerLitre() * milk.getLitres();
    System.out.println(milk.getName() + " ("+df.format(milk.getPricePerLitre())+" per kg)" + " cost = £" + df.format(cost));
    return cost;
  }

  @Override
  public String visitSummary(Milk milk)
  {
    return milk.getLitres() + "litres" + " of " + milk.getName();
  }

}
