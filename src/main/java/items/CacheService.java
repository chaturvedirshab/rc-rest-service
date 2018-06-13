package items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheService {
     
	public static Map<Long, Item> store = new HashMap<Long, Item>();
     
    @CachePut(value="items", key="#id")
    public Item putItem(String timeStamp, long id){
        //Item item = store.get(id);
        	Item item = new Item(id, timeStamp);
        	store.put(id, item);
        return item;
    }
    
    @Cacheable(value="items")
    public List<Item> getAllItems(){
    	List<Item> listOfItemsWithinTwoseconds = new ArrayList<Item>();
    	List<Item> listOfFirstHundredItems = new ArrayList<Item>();
    	int counterForHundred = 0;
        System.out.println("Service processing...");
        Set<Long> keySet = CacheService.store.keySet();
        Iterator<Long> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
           System.out.println("Iterating Map in Java using KeySet Iterator");
           Long key = keySetIterator.next();
           if(counterForHundred < 100){
        	   listOfFirstHundredItems.add(CacheService.store.get(key));
           	   counterForHundred++;
           }
           if(Helper.ifMeetsCriteria(CacheService.store.get(key)))
        	   listOfItemsWithinTwoseconds.add(CacheService.store.get(key));
        }
        if(listOfItemsWithinTwoseconds.size() > 100)
        	return listOfItemsWithinTwoseconds;
        
        return listOfFirstHundredItems;

    }
     
    @CacheEvict(value = "items", key = "#id")
    public void evict(long id){
    }
}