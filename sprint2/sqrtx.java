class Solution {
    public int mySqrt(int x) {
        int root=1;
        while(root<=(x/root)){
            root++;
        }
        return --root;
    }
}
