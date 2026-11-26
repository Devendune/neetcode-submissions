class Solution 
{
    private List<String> neighbours(String value)
    {
        List<String> result = new ArrayList<>();
        char[] arr = value.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = arr[i];

            arr[i] = (char) ((original - '0' + 1) % 10 + '0');   // turn up, 9 wraps to 0
            result.add(new String(arr));

            arr[i] = (char) ((original - '0' + 9) % 10 + '0');   // turn down, 0 wraps to 9
            result.add(new String(arr));

            arr[i] = original;                                   // put the wheel back
        }
        return result;
    }
    public int openLock(String[] deadends, String target) 
    {
        int steps=0;
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>(Arrays.asList(deadends));

        if(target.equals("0000"))
        return 0;

        if(visited.contains("0000"))
        return -1;

        queue.add("0000");

        while(queue.size()!=0)
        {
            int queueSize=queue.size();
            steps++;

            for(int counter=0;counter<queueSize;counter++)
            {
                String topElement=queue.poll();

                for(String neighbour:neighbours(topElement))
                {
                    if(visited.contains(neighbour))
                    continue;

                    if(neighbour.equals(target))
                    return steps;

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return -1;
    }
}