# Stringhash
Calculate the hash-code of the string using the given formula

String Hashing 
------ ------

It is often desirable to compute a hash code from a character string.  One good way of 
doing this is to use the function:
    hash = hash(N)    
    hash(n) = P * hash(n-1) + c[n-1] mod M if n > 0    
    hash(0) = 0
    
where

    N is the number of characters in the string    
    c[0], c[1], ..., c[N-1] are the characters of the        
    string    0 <= c[i] < 256 for all 0 <= i < N    
    M is an integer > 0, the modulus of computation    
    P is a number prime to M    
    hash(n) is the hash code of the first n characters        
    of the string    
    hash is the hash code of the entire string
    
Good values of P and M are
    M = 2**32    
    P = 33 or 65599
    
Computing modulo 2**32 is fast because it is just truncating to 32 bits.  
Multiplying by 33 = 2**5 + 2**0 can be done quickly by one shift and one addition.  
Multiplying by 65599 = 2**16 + 2**6 - 2**0 can be done by 2 shifts, one addition, 
and one subtraction.

You have been asked to compute hash values for some strings.  However, to be absolutely 
sure there are no arithmetic overflow problems, we are simplifying the problem by 
requiring
       
       0 < P < M < 2**15
       
Also, we do NOT require that M and P be relatively prime.

Input ----

For each test case, one line containing

        M P STRING

in the given order.  M, P, and STRING are separated by whitespace consisting of spaces 
and tabs.  M and P are integers, and STRING is a sequence of at most 80 nonwhitespace 
characters.

The input terminates with an end of file.

Output 
-----
For each test case, one line containing

        M P STRING HASH
        
which copies M, P, and STRING from the input and outputs the ‘hash’ value computed for 
the STRING character string using M and P.

Example Input 
------- ----
10000 100 A 
10000 100 B 
10000 100 C 
10000 100 D 
10000 100 AB 
10000 100 CD 
32000 33  AB 
32000 33  CD 
32000 33  ABCDEFGHIJ 
32000 33  BACDEFGHIJ 
32000 33  %^@abc++=903#?..."

Example Output 
------- -----
10000 100 A 65 
10000 100 B 66 
10000 100 C 67 
10000 100 D 68 
10000 100 AB 6566 
10000 100 CD 6768 
32000 33 AB 2211 
32000 33 CD 2279 
32000 33 ABCDEFGHIJ 5207 
32000 33 BACDEFGHIJ 12919 
32000 33 %^@abc++=903#?..." 11238

//If you think the text is not in format, please hit the raw button on the top.
