public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length < 1 || array[0].length < 1){
            return false;
        }
        
        int rows = array.length;
        int cols = array[1].length;
        
        int row = 0;
        int col = cols -1;
        
        while (row >= 0 && row < rows && col >= 0 && col < cols){
            if (array[row][col] == target){
                return true;
            }else if (array[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
