package com.homeoffice.item.elements;
import com.homeoffice.item.Item;
import com.homeoffice.visitors.ShoppingCartVisitor;

public class Milk implements Item
{
  private double pricePerLitre;
  private double litres;
  private String name;

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
  public double accept(ShoppingCartVisitor visitor)
  {
    return visitor.visit(this);
  }

}
