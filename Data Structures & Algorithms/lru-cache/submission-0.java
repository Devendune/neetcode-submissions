class LRUCache 
{
    int cacheCapacity;
    Map<Integer,int[]>map;
    TreeMap<Integer,Integer>treeMap;
    int time=0;
    public LRUCache(int capacity) 
    {
        cacheCapacity=capacity;
        map=new HashMap<>();
        treeMap=new TreeMap<>();
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
            time++;
            int[] entry={value,time};
            map.put(key,entry);
            treeMap.put(time,key);

            if(map.size()>cacheCapacity)
            {
                int evictionTime=treeMap.firstKey();
                int evictionKey=treeMap.get(evictionTime);
                treeMap.remove(evictionTime);
                map.remove(evictionKey);
            }
        }
    }
    private void refresh(int key,int[] entry)
    {
        treeMap.remove(entry[1]);
        time++;
        entry[1]=time;
        treeMap.put(time,key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */