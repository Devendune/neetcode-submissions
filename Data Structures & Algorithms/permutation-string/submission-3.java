class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        //we can check in each window of size s1
        int freqS1[]=new int[26];
        int freqS2[]=new int[26];

        if(s1.length()>s2.length())
        return false;

        int windowSize=s1.length();
        int startCounter=0;
        int endCounter=0;

        for(int counter=0;counter<s1.length();counter++)
        {
            freqS1[s1.charAt(counter)-'a']++;
        }

        while(endCounter<s2.length())
        {
            while(endCounter-startCounter+1<=windowSize)
            {
                freqS2[s2.charAt(endCounter)-'a']++;
                endCounter++;
            }
            if(Arrays.equals(freqS1,freqS2))
            return true;

            freqS2[s2.charAt(startCounter)-'a']--;
            startCounter++;
        }
        return false;
    }
}
