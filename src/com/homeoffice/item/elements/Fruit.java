package com.homeoffice.item.elements;
import com.homeoffice.item.Item;
import com.homeoffice.item.defaults.UnitCost;
import com.homeoffice.visitors.ShoppingBasketVisitor;

/**
 * Concrete item
 *
 */
public class Fruit extends BaseItem implements Item
{
  private double pricePerKg;
  private double weight;

  /**
   * Overloaded constructor to use default unit cost
   *
   * @param weight
   * @param name
   */
  public Fruit(double weight, String name)
  {
    super();
    this.pricePerKg = UnitCost.DEFAULT_FRUIT.getValue();
    this.weight = weight;
    this.name = name;
  }

  public Fruit(double pricePerKg, double weight, String name)
  {
    super();
    this.pricePerKg = pricePerKg;
    this.weight = weight;
    this.name = name;
  }

  public double getPricePerKg()
  {
    return pricePerKg;
  }

  public void setPricePerKg(double pricePerKg)
  {
    this.pricePerKg = pricePerKg;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  @Override
  public double count(ShoppingBasketVisitor visitor)
  {
    return visitor.visitCost(this);
  }

  @Override
  public String summary(ShoppingBasketVisitor visitor)
  {
    return visitor.visitSummary(this);
  }

}
