package com.homeoffice.item.defaults;

/**
 * Set of default unit costs providing lookup
 *
 */
public enum UnitCost
{
  DEFAULT_MEAT(1.99),
  DEFAULT_FRUIT(0.69),
  DEFAULT_MILK(0.45);

  private double value;

  UnitCost(double value)
  {
    this.value = value;
  }

  public double getValue()
  {
    return value;
  }
}
