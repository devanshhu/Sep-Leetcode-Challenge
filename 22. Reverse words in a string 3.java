class Solution {
    public String reverseWords(String s) {
        String[] wordsArr = s.split(" ");
        String[] result = new String[wordsArr.length];
        StringBuilder sb = new StringBuilder();
        int i =0;
        for(String word: wordsArr){
            sb.setLength(0);
            sb.append(word);
            result[i++] = sb.reverse().toString();
        }
        
        return String.join(" ", result);
    }
}