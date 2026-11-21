
class Solution 
{
    Stack<Integer> numberStack=new Stack<>();
    Stack<StringBuilder> stringStack=new Stack<>();
    private boolean isNumber(char num)
    {
        if(Character.isDigit(num))
        return true;

        return false;
    }
    public String decodeString(String s) 
    {
        StringBuilder currentString=new StringBuilder();
        int counter=0;
        int num=0;
        while(counter<s.length())
        {
            char ch=s.charAt(counter);
            if(isNumber(ch))
            num=num*10+(ch-'0');

            else if(ch=='[')
            {
                numberStack.push(num);
                stringStack.push(currentString);
                num=0;
                currentString=new StringBuilder();
            }
            else if(ch==']')
            {
                int repeatCount=numberStack.peek();
                StringBuilder toRepeat=stringStack.peek();
                for(int secondCounter=0;secondCounter<repeatCount;secondCounter++)
                {
                    toRepeat.append(currentString);
                }
                numberStack.pop();
                stringStack.pop();
                currentString=toRepeat;
        
            }
            else
            {
                currentString.append(ch);
            }
            counter++;
        }
        return currentString.toString();
    }
}
