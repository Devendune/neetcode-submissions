class FreqStack 
{
    Map<Integer,Integer> freqMap;
    Map<Integer,Stack<Integer>>mapping;
    public FreqStack() 
    {
        freqMap=new HashMap<>();
        mapping=new HashMap<>();
    }
    
    public void push(int val) 
    {
        freqMap.put(val,1+freqMap.getOrDefault(val,0));
        if(!(mapping.containsKey(freqMap.get(val))))
            mapping.put(freqMap.get(val),new Stack<>());
            
        mapping.get(freqMap.get(val)).push(val);
    }
    
    public int pop() 
    {
        int highestFreq=mapping.size();
        Stack<Integer> stack=mapping.get(highestFreq);
        int answer=stack.peek();

        freqMap.put(answer,freqMap.get(answer)-1);
        
        if(stack.size()==1)
        mapping.remove(highestFreq);
        
        else
            stack.pop();

        return answer;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */