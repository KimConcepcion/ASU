
package common;
import java.util.HashMap;

//	Interface with methods to be implemented by Person class:
public interface PersonInterface 
{
	void setPayment();
	int getPayment();
	int addBeer(beerType XbeerType);
	int removeBeer(beerType XbeerType);
	void resetCalculations();
	void printHashMap(HashMap<String, Integer> map);
	void addPerson(String type, int x);
	void removePerson(String type, int x);
}