// class Solution {
//     public boolean judgeCircle(String moves) {
//        int x=0;
//        int y=0;
//         for(int i=0; i<moves.length(); i++ ){
//             if(moves.charAt(i)=='U'){
//                 y++;
//             } 
//             else if(moves.charAt(i)=='D'){
//                 y--;
//             } 
//             else if(moves.charAt(i)=='R'){
//                 x++;
//             } 
//             else if(moves.charAt(i)=='L'){
//                 x--;
//             }
//         }
//         return (x==0 && y==0);
//     }
// }

class Solution {
    public boolean judgeCircle(String moves) {
        int[] ch = new int[26];
        for (char move : moves.toCharArray()){
            ch[move - 'A']++;
        }
        return ch['U' - 'A'] == ch['D' - 'A'] && 
                ch['L' - 'A'] == ch['R' - 'A'];
    }
}