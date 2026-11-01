class Solution {
    public int numRescueBoats(int[] people, int limit) 
    {
        int peopleLength=people.length;
        Arrays.sort(people);
        
        int startCounter=0;
        int totalBoats=0;
        int endCounter=people.length-1;

        while(startCounter<=endCounter)
        {
            int totalWeight=people[startCounter]+people[endCounter];
            if(totalWeight<=limit)
            startCounter++;

            endCounter--;
            totalBoats++;
        }
        return totalBoats;
    
    }
}