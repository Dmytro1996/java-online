class Solution {
    public int divide(int dividend, int divisor) {        
        String dividendAsStr=String.valueOf(Math.abs((long)dividend));        
        int beginIndex=0;
        int endIndex=String.valueOf(Math.abs((long)divisor)).length();
        long remainder=0;
        StringBuilder resultAsStr=new StringBuilder();
        while(endIndex<=dividendAsStr.length()){
            long currentDividend=0;
            if(beginIndex==0){ 
                currentDividend=Long.valueOf(
                  dividendAsStr.substring(beginIndex,endIndex));
                beginIndex=endIndex;
            } else{
                currentDividend=Long.valueOf(
                    remainder+dividendAsStr.substring(beginIndex,endIndex));
                beginIndex++;
            }
            int resultOfDiv=0;
            while(currentDividend>=Math.abs((long)divisor)){
                currentDividend-=Math.abs((long)divisor);
                resultOfDiv++;
            }            
            endIndex++;
            resultAsStr.append(resultOfDiv);
            remainder=currentDividend;            
        }
        if(resultAsStr.length()==0){
            return 0;
        }
        long result=Long.valueOf(resultAsStr.toString());
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            result*=-1;
        }
        if(result>Integer.MAX_VALUE){
           return Integer.MAX_VALUE;
        }
        return (int)result;
    }
}
