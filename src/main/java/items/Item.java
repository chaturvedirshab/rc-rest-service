package items;

public class Item {
    private  long id;
    private  String timeStamp;

    public Item(long id, String timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
    
    public void setId(long id){
    	this.id = id;
    }
    
    public void setTimeStamp(String timeStamp){
    	this.timeStamp=timeStamp;
    }
}
