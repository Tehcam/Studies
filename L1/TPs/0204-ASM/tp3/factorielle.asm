; Initialisation

Load 1 ; (0)
Store Mem[0] ; i (1)
Store Mem[1] ; res (2)
In ; (3)
Add 1 ; (4)
Store Mem[2] ; n (5)

; Si i<n ?

CMP Mem[0] ; (6)
JC 9 ; alors faire res *= i (7)
JMP 17; saut d'évitement (8)

; Alors 

Load Mem[1] ; (9)
Mul Mem[0] ; (10)
Store Mem[1] ; (11)
Load Mem[0] ; (12)
Add 1 ; (13)
Store Mem[0] ; (14)
Load Mem[2] ; (15)
JMP 6 ; retour au test (16)

; Après 

Load Mem[1] ; (17)
Out ; afficher res (18)
End ; (19)