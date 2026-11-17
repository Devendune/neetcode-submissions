class LFUCache 
{    
    int cacheCapacity;
    Map<Integer,int[]>map;
    TreeMap<int[],Integer>treeMap;
    int time=0;
    public LFUCache(int capacity) 
    {
        cacheCapacity=capacity;
        map=new HashMap<>();
       treeMap = new TreeMap<>((a, b) ->
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            int[] entry=map.get(key);
            refresh(key,entry);
            return entry[0];
        }
        else
        return -1;
    }
    
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
            int[] entry=map.get(key);
            entry[0]=value;
            refresh(key,entry);
        }
        else
        {
            if(map.size()==cacheCapacity)
            {
                int[] evictionEntry=treeMap.firstKey();
                int evictionKey=treeMap.get(evictionEntry);
                treeMap.remove(evictionEntry);
                map.remove(evictionKey);
            }
            time++;    
            int[] entry={value,1,time};
            map.put(key,entry);
            treeMap.put(new int[]{1,time},key);
        }
    }
    private void refresh(int key,int[] entry)
    {
        // value freq time
        int currentFreq=entry[1];
        treeMap.remove(new int[]{entry[1],entry[2]});
        time++;
        currentFreq++;
        entry[1]=currentFreq;
        entry[2]=time;

        int[] newArr={entry[1],entry[2]};
        treeMap.put(newArr,key);
    }
}
