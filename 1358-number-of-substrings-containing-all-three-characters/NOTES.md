abcabc
​
once your window has all the 3 chars, then you find the minimum of all the indices. All the substring before the min are valid.
​
For ex :
​
a | b | c | a | b | c
^
when pointer is at 3rd index, the min value is 1. so any substring before index 1 is valid now. And there can be exactly 'min' no of substrings at that point. Therefore add 1 + minIndex.