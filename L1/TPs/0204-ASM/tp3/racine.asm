; Initialisation 

In ; (0)
Store Mem[2] ; x (1)

Load 0 ; (2)
Store Mem[0] ; i (3)

Mul Mem[0] ; (4)
Store Mem[1] ; tmp (5)
Load Mem[2] ; (6)

; Si tmp <= x ?

CMP Mem[1] ; (7)
JC 11 ; alors tmp<x (8)
JZ 11 ; alors tmp=x (9)
JMP 16 ; saut d'évitement (10)

; Alors 

Load Mem[0] ; (11)
Add 1 ; (12)
CMP 15 ; (13)
JC 17 ; on ne peut plus aller plus loin, donc saut vers la fin du programme (14)
JMP 3 ; réinitialisation et retour au test (15)

; Après

Load Mem[0] ; (16)
Sub 1 ; (17)
Out ; (18)
End ; (19)