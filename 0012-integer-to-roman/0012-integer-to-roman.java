class Solution {
    public String intToRoman(int num) {
        String[] ones = new String[]{"","I","II","III","IV","V", "VI","VII","VIII","IX"};
        String[] tens = new String[]{"","X", "XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands = new String[]{"","M","MM","MMM"};

       StringBuilder sb = new StringBuilder();
       String thousand = thousands[num/1000];
       String hundred = hundreds[(num%1000)/100];
       String ten = tens[(num%100)/10];
       String one = ones[num%10];
        sb.append(thousand);
        sb.append(hundred);
        sb.append(ten);
        sb.append(one);

        return sb.toString();
    }
}