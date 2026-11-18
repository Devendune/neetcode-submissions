class Solution {
    public String simplifyPath(String path) 
    {
        String[] splitted=path.split("/");
        Stack<String> stack=new Stack<>();

        for(String string:splitted)
        {
            if(string.equals(".") || string.equals(""))
            continue;

            if(string.equals(".."))
            {
                if(stack.size()>0)
                stack.pop();
            }

            else
            stack.push(string);
        }

        String[] strArray=new String[stack.size()];
        StringBuilder sb=new StringBuilder("");
        int currCounter=stack.size()-1;
        while(stack.size()!=0)
        {
           strArray[currCounter]=stack.pop();
           currCounter--;
        }
        for(String str:strArray)
        {
            sb.append("/");
            sb.append(str);
        }
        if(sb.length()==0)
        sb.append("/");
        
        return sb.toString();


         
    }
}