class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int cars[][]=new int[position.length][2];
        int fleets=0;
        double fleetTime=0;
        for(int counter=0;counter<position.length;counter++)
        {
            cars[counter][0]=position[counter];
            cars[counter][1]=speed[counter];
        }

        Arrays.sort(cars,(a,b)->Integer.compare(b[0],a[0]));

        for(int[] car:cars)
        {
            int currentPosition=car[0];
            int currentSpeed=car[1];

            double time=(double)(target-currentPosition)/currentSpeed;
            if(time>fleetTime)
            {
                fleets++;
                fleetTime=time;
            }
        }
        return fleets;



    }
}