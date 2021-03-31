class Solution {
    public int reverse(int x) {
        try{
            if(x<0){
                return -1*Integer.parseInt(
                    new StringBuilder(""+x*-1).reverse().toString());
            } else{
                return Integer.parseInt(
                    new StringBuilder(""+x).reverse().toString());
            }
        } catch(Exception e){
            return 0;
        }
    }
}
