class Solution 
{
    public boolean interleave(String s1,String s2,String s3,int firstCounter,
    int secondCounter,int thirdCounter)
    {
        if(thirdCounter>=s3.length())
        {
            if(firstCounter==s1.length() && secondCounter==s2.length())
            return true;

            else
            return false;
        }

         
        
        if(firstCounter<s1.length() && secondCounter<s2.length())
        {
            if(s1.charAt(firstCounter)==s3.charAt(thirdCounter) &&
            s2.charAt(secondCounter)==s3.charAt(thirdCounter))
            {
                boolean takeS1=interleave(s1,s2,s3,firstCounter+1,secondCounter,thirdCounter+1);
                boolean takeS2=interleave(s1,s2,s3,firstCounter,secondCounter+1,thirdCounter+1);

                return (takeS1 || takeS2);
            }
            else if(!(s1.charAt(firstCounter)==s3.charAt(thirdCounter) ||
            s2.charAt(secondCounter)==s3.charAt(thirdCounter)))
            return false;
        }
        if(firstCounter<s1.length())
        if(s1.charAt(firstCounter)==s3.charAt(thirdCounter))
            return interleave(s1,s2,s3,firstCounter+1,secondCounter,
            thirdCounter+1);
        
        if(secondCounter<s2.length())
        if(s2.charAt(secondCounter)==s3.charAt(thirdCounter))
         return interleave(s1,s2,s3,firstCounter,secondCounter+1,
            thirdCounter+1);
        

        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int firstStringLength=s1.length();
        int secondStringLength=s2.length();
        int thirdStringLength=s3.length();

        if(firstStringLength+secondStringLength!=thirdStringLength)
        return false;

        return interleave(s1,s2,s3,0,0,0);
    }
}
