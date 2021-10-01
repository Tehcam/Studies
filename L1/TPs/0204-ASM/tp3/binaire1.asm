; Initialisation 

In ; (0)
Store Mem[0] ; x (1)
Load 0 ; (2)
Store Mem[1] ; i (3)

; Si 7<i ?

CMP 7 ; (4)
JC 15 ; alors aller à la fin du programme (5)
; sinon continuer
Load Mem[0] ; (6)
Mod 2 ; (7)
Out ; afficher x%2 (8)
Load Mem[0] ; (9)
Div 2 ; (10)
Store Mem[0] ; (11)
Load Mem[1] ; (12)
Add 1 ; (13)
JMP 3 ; retour au test (14)

; Fin du programme

End ; (15)