
package common;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;

public class Person implements PersonInterface {
	
	// Person info:
	String name;
	public int id = 0;

	// Beer info:
	public int xNewCastle = 0;
	public int xCarlsBerg = 0;
	public int xTuborg = 0;

	// Payment, total quantity and enum:
	public int payment = 0;
	public int quantity = 0;
	public beerType bType;
	
	// Class/blueprint of beer:
	Beer beer = new Beer();
	
	//	Hashmap with beer and specific quantity:
	public HashMap<String, Integer> beerMap = new HashMap<String, Integer>();
	
	@Override
	public void addPerson(String type, int x)
	{
		this.beerMap.put(type, x);
	}
	
	@Override
	public void removePerson(String type, int x)
	{
		this.beerMap.put(type, x);
	}
	
	@Override
	public void setPayment() {
		// Evaluate polarity:
		if (this.payment == 0)
			this.payment = 0;

		// Calculate the payment:
		this.payment = this.xNewCastle * beer.NewcastlePrice + this.xCarlsBerg * beer.CarlsBergPrice
				+ this.xTuborg * beer.TuborgPrice;
	}

	@Override
	public int getPayment() {
		
		//	Fetch payment via return value:
		System.out.println("Payment: " + this.payment);
		return this.payment;
	}
	
	@Override
	public int addBeer(beerType XbeerType) {
		
		// Update the quantity:
		this.quantity += 1;
		
		// Test beertype with enum:
		if (XbeerType == beerType.NewCastle)
		{
			this.xNewCastle += 1;
			addPerson(beer.beerNewcastle, this.xNewCastle);
			System.out.println(beer.beerNewcastle + " was added!");
		}
		
		else if (XbeerType == beerType.Carlsberg)
		{
			this.xCarlsBerg += 1;
			addPerson(beer.beerCarlsberg, this.xCarlsBerg);
			System.out.println(beer.beerCarlsberg + " was added!");
		}
	
		else
		{
			this.xTuborg += 1;
			addPerson(beer.beerTuborg, this.xTuborg);
			System.out.println(beer.beerTuborg + " was added!");
		}
		
		// Return the quantity:
		return this.quantity;
	}

	@Override
	public int removeBeer(beerType XbeerType) {
		// Evaluate polarity of quantity:
		if (this.quantity == 0)
			this.quantity = 0;

		else {
			// Test beertype with enumeration:
			if (XbeerType == beerType.NewCastle) {
				if (this.xNewCastle == 0)
					this.xNewCastle = 0;
				else {
					this.xNewCastle -= 1;
					this.quantity -= 1;
					System.out.println(beer.beerNewcastle + " was removed!");
					
					removePerson(beer.beerNewcastle, this.xNewCastle);
				}
			}

			else if (XbeerType == beerType.Carlsberg) {
				if (this.xCarlsBerg == 0)
					this.xCarlsBerg = 0;

				else {
					this.xCarlsBerg -= 1;
					this.quantity -= 1;
					System.out.println(beer.beerCarlsberg + " was removed!");
					
					removePerson(beer.beerCarlsberg, this.xCarlsBerg);
				}
			}

			else if (XbeerType == beerType.Tuborg) {
				if (this.xTuborg == 0)
					this.xTuborg = 0;

				else {
					this.xTuborg -= 1;
					this.quantity -= 1;
					System.out.println(beer.beerTuborg + " was removed!");
					
					removePerson(beer.beerTuborg, this.xTuborg);
				}
			}
		}
		
		// Return the quantity:
		return this.quantity;
	}

	@Override
	public void resetCalculations() {
		this.xNewCastle = 0;
		this.xCarlsBerg = 0;
		this.xTuborg = 0;
		this.payment = 0;
		this.quantity = 0;
		
		//	Clear the hashmap:
		this.beerMap.clear();
	}
	
	@Override
	public void printHashMap(HashMap<String, Integer> map)
	{
		Set<Entry<String, Integer>> hashSet=map.entrySet();
		for(Entry<String, Integer> entry:hashSet)
		{
			System.out.println("Key="+entry.getKey()+", value="+entry.getValue());
		}
	}
}