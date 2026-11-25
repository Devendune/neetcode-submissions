class Solution 
{
    private boolean compareString(String s1,String s2,int[] occurence)
    {
        int firstCounter=0,secondCounter=0;
        while(firstCounter<s1.length() && secondCounter<s2.length())
        {
            char ch1=s1.charAt(firstCounter);
            char ch2=s2.charAt(secondCounter);

            if(ch1!=ch2)
            {
             if(occurence[ch1-'a']<occurence[ch2-'a'])
             return true;

             return false;
            }

            firstCounter++;
            secondCounter++;
        }
        return s1.length()<=s2.length();
    }
    public boolean isAlienSorted(String[] words, String order) 
    {
        int[] occurence=new int[26];
        for(int counter=0;counter<order.length();counter++)
        {
            char ch=order.charAt(counter);
            occurence[ch-'a']=counter;
        }
        int counter=0;
        while(counter<words.length-1)
        {
            String firstWord=words[counter];
            String secondWord=words[counter+1];

            if(compareString(firstWord,secondWord,occurence)==false)
            return false;

            counter++;
        }
        return true;
    }
}