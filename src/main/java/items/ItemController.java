package items;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ItemController {
    
    @Autowired
    CacheService service;

    @PostMapping("/items")
    public String put(@RequestParam("timeStamp") String timeStamp, @RequestParam("id")long id){
        service.putItem(timeStamp, id);
        return "201 Created";
    }
    
    @RequestMapping("/items")
    public List<Item> getItems(){
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
     
    @RequestMapping("/cacheevict")
    public String evict(@RequestParam("id")long id){
        service.evict(id);
        return "Done";
    }
}
