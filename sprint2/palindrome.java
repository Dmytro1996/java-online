class Solution {
    public boolean isPalindrome(int x) {
        try{
            return x==Integer.parseInt(new StringBuilder(""+x).reverse().toString());
        } catch(Exception e){
            return false;
        }
    }
}
