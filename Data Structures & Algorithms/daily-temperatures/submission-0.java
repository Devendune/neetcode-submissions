class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int temperaturesLength=temperatures.length;
        int[] ans=new int[temperaturesLength];

        Stack<Integer> stack=new Stack<>();
        ans[temperaturesLength-1]=0;
        stack.push(temperaturesLength-1);

        int counter=temperaturesLength-2;
        while(counter>=0)
        {
            int temp=temperatures[counter];
            while(stack.size()!=0 && temp>=temperatures[stack.peek()])
            {
                stack.pop();
            }
            if(stack.size()==0)
            ans[counter]=0;

            else
            ans[counter]=Math.abs(counter-stack.peek());

            stack.push(counter);
            counter--;
        }
        return ans;
    }
}