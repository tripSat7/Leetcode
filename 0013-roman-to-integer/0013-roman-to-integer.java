class Solution {
    public int romanToInt(String s) {
        char ch[] = s.toCharArray();
        int res=0;
        for(int i=0; i<ch.length; i++){
            if(ch[i]=='I'){
                if(i+1<ch.length && ch[i+1]=='V'){
                    res = res + 4;
                    i+=1;
                }else if(i+1<ch.length && ch[i+1]=='X'){
                    res = res + 9;
                    i+=1;
                }else{
                    res = res + 1;
                }
            }else if(ch[i]=='X'){
                if(i+1<ch.length && ch[i+1]=='L'){
                    res = res + 40;
                    i++;
                }else if(i+1<ch.length && ch[i+1]=='C'){
                    res = res + 90;
                    i++;
                }else{
                    res = res + 10;
                }
            }else if(ch[i]=='C'){
                if(i+1<ch.length && ch[i+1]=='D'){
                    res = res + 400;
                    i++;
                }else if(i+1<ch.length && ch[i+1]=='M'){
                    res = res + 900;
                    i++;
                }else{
                    res = res + 100;
                }
            }else if(ch[i]=='V'){
                res+=5;
            }else if(ch[i]=='L'){
                res+=50;
            }else if(ch[i]=='D'){
                res+=500;
            }else{
                res+=1000;
            }
        }
            
        return res;
    }
}