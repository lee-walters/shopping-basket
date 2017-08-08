package com.homeoffice.item.elements;
import com.homeoffice.item.Item;
import com.homeoffice.item.defaults.UnitCost;
import com.homeoffice.visitors.ShoppingBasketVisitor;

/**
 * Concrete item
 *
 */
public class Milk implements Item
{
  private double pricePerLitre;
  private double litres;
  private String name;

  /**
   * Overloaded constructor to use default unit cost
   *
   * @param litres
   * @param name
   */
  public Milk(double litres, String name)
  {
    super();
    this.pricePerLitre = UnitCost.DEFAULT_MILK.getValue();
    this.litres = litres;
    this.name = name;
  }

  public Milk(double pricePerLitre, double litres, String name)
  {
    super();
    this.pricePerLitre = pricePerLitre;
    this.litres = litres;
    this.name = name;
  }

  public double getPricePerLitre()
  {
    return pricePerLitre;
  }

  public void setPricePerLitre(double pricePerLitre)
  {
    this.pricePerLitre = pricePerLitre;
  }

  public double getLitres()
  {
    return litres;
  }

  public void setLitres(double litres)
  {
    this.litres = litres;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
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
