; Initialisation 

In ; (0)
Store Mem[0] ; x (1)
Load 0 ; (2)
Store Mem[1] ; i (3)
Load 1 ; (4)
Store Mem[2] ; res (5)
In ; (6)
Store Mem[3] ; n (7)

; Si i<n ?

CMP Mem[1] ; (8)
JC 11 ; alors faire res *= x (9)
JMP 19 ; saut d'évitement (10)

; Alors

Load Mem[2] ; (11)
Mul Mem[0] ; (12)
Store Mem[2] ; (13)
Load Mem[1] ; (14)
Add 1 ; (15)
Store Mem[1] ; (16)
Load Mem[3] ; (17)
JMP 8 ; retour au test (18)

; Après

Load Mem[2] ; (19)
Out ; afficher res (20)
End ; (21)