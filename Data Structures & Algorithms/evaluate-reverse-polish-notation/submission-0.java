class Solution 
{
    private boolean isOperand(String str)
    {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
        return true;

        return false;
    }
    public int evalRPN(String[] tokens) 
    {
        int sum=0;
        Stack<Integer>stack=new Stack<>();
        for(String token:tokens)
        {
            if(isOperand(token)==false)
            {
                stack.push(Integer.parseInt(token));
            }
            else
            {
                int value1=stack.pop();
                int value2=stack.pop();

                if(token.equals("+"))
                stack.push(value2+value1);

                else if(token.equals("-"))
                stack.push(value2-value1);

                else if(token.equals("*"))
                stack.push(value2*value1);

                else
                stack.push(value2/value1);
            }
        }
        return stack.peek();
    }
}