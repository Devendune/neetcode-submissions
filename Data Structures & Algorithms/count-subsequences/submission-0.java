class Solution 
{
    public int helper(String s,String t,int sCounter,int tCounter)
    {
        if(tCounter>=t.length())
        return 1;
        
        if(sCounter<s.length() && tCounter<t.length())
        {
            if(s.charAt(sCounter)==t.charAt(tCounter))
            {
                return helper(s,t,sCounter+1,tCounter+1)+
                helper(s,t,sCounter+1,tCounter);
            }
            else
            {
                return helper(s,t,sCounter+1,tCounter);
            }
        }
        return 0;
    }
    public int numDistinct(String s, String t) 
    {
        return helper(s,t,0,0);  
    }
}
