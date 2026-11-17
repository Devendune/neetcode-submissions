class MinStack
{
    Stack<Integer>stack;
    TreeMap<Integer,Integer> map;
    public MinStack() {
        stack=new Stack<>();
        map=new TreeMap<>();
    }
    
    public void push(int value) 
    {
        stack.push(value);
        if(map.containsKey(value))
        map.put(value,1+map.getOrDefault(value,0));

        else
        map.put(value,1);    
    }
    
    public void pop() 
    {
        int value=stack.peek();
        stack.pop();

        if(map.get(value)>1)
        {
            int freq=map.get(value);
            map.put(value,freq-1);
        }

        else
        map.remove(value);    
    }
    
    public int top() 
    {
        return stack.peek();    
    }
    
    public int getMin() 
    {
        return map.firstKey(); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */