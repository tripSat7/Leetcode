class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G'){
                sb.append("G");
            }
            if(command.charAt(i)=='('&&command.charAt(i+1)==')'){
                sb.append("o");
                i++;
            }
            if(command.charAt(i)=='('&&command.charAt(i+1)=='a'){
                sb.append("a");
                i++;
            }
            if(command.charAt(i)=='l'&&command.charAt(i+1)==')'){
                sb.append("l");
                i++;
            }
        }
        
        return sb.toString();
    }
}