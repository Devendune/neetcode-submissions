class MinStack 
{
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;
    public MinStack() 
    {
        firstStack=new Stack<>();
        secondStack=new Stack<>();
    }
    
    public void push(int val)
    {
        firstStack.push(val); 
        if(secondStack.size()==0)
        secondStack.push(val);

        else
        {
            if(secondStack.peek()>=val)
            secondStack.push(val);
        }
    }
    
    public void pop() 
    {
        int val=firstStack.peek();
        if(val==secondStack.peek())
            secondStack.pop();

        firstStack.pop();
    }
    
    public int top() {
        return firstStack.peek();
    }
    
    public int getMin() 
    {
        return secondStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */