class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> stack=new Stack<>();
        for(int counter=0;counter<asteroids.length;counter++)
        {
            int asteroid=asteroids[counter];
            if(asteroid>=0)
            stack.push(asteroid);

            else
            {
                boolean sameSum=false;
                while(stack.size()!=0)
                {
                    int stackTop=stack.peek();
                    int explosion=stackTop+asteroid;
                    if(explosion>0)
                        break;
                    
                    else if(explosion==0)
                    {
                        stack.pop();
                        sameSum=true;
                        break;
                    }
                    else
                    {
                        if(stackTop>=0)
                        stack.pop();

                        else
                        {
                            stack.push(asteroid);
                            break;
                        }
                    }
                }
                if(stack.size()==0 && !sameSum)
                  stack.push(asteroid);
                
            }
        }
        int answer[]=new int[stack.size()];
        int counter=stack.size()-1;
        while(stack.size()!=0)
        {
            answer[counter]=stack.peek();
            stack.pop();
            counter--;
        }
        return answer;
    }
}