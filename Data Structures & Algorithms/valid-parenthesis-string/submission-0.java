class Solution {
    public boolean checkValidString(String s) 
    {
        int stringLength=s.length();
        Stack<Integer>leftStack=new Stack<>();
        Stack<Integer>starStack=new Stack<>();

        for(int counter=0;counter<stringLength;counter++)
        {
            char ch=s.charAt(counter);
            if(ch=='(')
            leftStack.push(counter);

            else if(ch=='*')
            starStack.push(counter);

            else
            {
                if(leftStack.isEmpty() && starStack.isEmpty())
                return false;

                if(!leftStack.isEmpty())
                leftStack.pop();

                else
                starStack.pop();
            }
        }

        while(leftStack.size()!=0 && starStack.size()!=0)
        {
            if(leftStack.peek() > starStack.peek())
            return false;

            leftStack.pop();
            starStack.pop();
        }
        if(leftStack.size()!=0 && starStack.size()==0)
        return false;

        else
        return true;

        
    }
}
