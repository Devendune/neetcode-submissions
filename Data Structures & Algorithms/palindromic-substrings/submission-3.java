class Solution 
{
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<end)
        {
            char startChar=s.charAt(start);
            char endChar=s.charAt(end);
            
            if(startChar==endChar)
            {
                start++;
                end--;
            }
            else
            return false;
        }
        return true;
    }
    public int countSubstrings(String s) 
    {
        int ansCount=0;
    for(int counter=0;counter<s.length();counter++)
        {
            for(int secondCounter=counter;secondCounter<s.length();secondCounter++)
            {
                if(isPalindrome(s,counter,secondCounter))
                ansCount++;
            }
        }
        return ansCount;
    }
}
