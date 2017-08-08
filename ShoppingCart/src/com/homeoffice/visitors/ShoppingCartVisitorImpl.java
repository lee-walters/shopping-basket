package com.homeoffice.visitors;
import java.text.DecimalFormat;

import com.homeoffice.item.elements.Fruit;
import com.homeoffice.item.elements.Meat;
import com.homeoffice.item.elements.Milk;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor
{
  private DecimalFormat df = new DecimalFormat("#.##");

  @Override
  public double visit(Fruit fruit)
  {
    double cost = fruit.getPricePerKg() * fruit.getWeight();
    System.out.println(fruit.getName() + " cost = £" + df.format(cost));
    return cost;
  }

  @Override
  public double visit(Meat meat)
  {
    double cost = meat.getPricePerKg() * meat.getWeight();
    System.out.println(meat.getName() + " cost = £" + df.format(cost));
    return cost;
  }

  @Override
  public double visit(Milk milk)
  {
    double cost = milk.getPricePerLitre() * milk.getLitres();
    System.out.println(milk.getName() + " cost = £" + df.format(cost));
    return cost;
  }

}
