public class MoveAllXToTheEndOfString {
    public static String moveAllX(String original, String xCount, String ans, int index){
        // base condition
        if(index == original.length()){
            return ans + xCount;
        }

        // function body
        char curr = original.charAt(index);

        if(curr == 'x'){
            xCount += 'x';
        } else{
            ans += curr;
        }

        return moveAllX(original, xCount, ans, index+1);
    }
    
    public static void main(String[] args){
        String str = "axbcxxd";
        System.out.println(moveAllX(str, "", "", 0));   
    }
}
