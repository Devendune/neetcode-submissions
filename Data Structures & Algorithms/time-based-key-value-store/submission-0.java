class CompositeKey
{
    private int timeStamp;
    private String value;

    public CompositeKey(int timeStamp,String value)
    {
        this.timeStamp=timeStamp;
        this.value=value;
    }
    public int getTimeStamp()
    {
        return timeStamp;
    }
    public String getValue()
    {
        return value;
    }
}
class TimeMap 
{
    HashMap<String,List<CompositeKey>> map;
    public TimeMap() 
    {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) 
    {
        if(map.containsKey(key))
        {
            List<CompositeKey> list=map.get(key);
            list.add(new CompositeKey(timeStamp,value));
            map.put(key,list);   
        }
        else
        {
            List<CompositeKey>list=new ArrayList<>();
            list.add(new CompositeKey(timeStamp,value));
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) 
    {
        if(map.containsKey(key))
        {
            List<CompositeKey> list=map.get(key);
            int startCounter=0;
            int endCounter=list.size()-1;

            int answer=-1;
            while(startCounter<=endCounter)
            {
                int mid=startCounter+(endCounter-startCounter)/2;

                int currentTimestamp=list.get(mid).getTimeStamp();
                String currentValue=list.get(mid).getValue();

                if(currentTimestamp<=timestamp)
                {
                    answer=mid;
                    startCounter=mid+1;
                }
                
                else
                endCounter=mid-1;
            }
            if(answer!=-1)
            return list.get(answer).getValue();

            return "";
        }
        else
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */