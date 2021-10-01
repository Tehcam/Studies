; Initialisation

In ; (0)
Store Mem[1] ; x (1)
Load 128 ; (2)
Store Mem[0] ; i (3)

; Si i=0 ?
; dans ts les cas, i est déjà dans l'Acc

CMP 0 ; (4)
JZ 23 ; alors le traitement est fini (5)
; sinon continuer 

; Si x<i ?

CMP Mem[1] ; (6)
JC 17 ; alors afficher 0 (7)
Load 1 ; (8)
Out ; sinon afficher 1 (9)
Load Mem[1] ; (10)
Sub Mem[0] ; (11)
Store Mem[1] ; (12)
Load Mem[0] ; (13)
Div 2 ; (14)
Store Mem[0] ; (15)
JMP 4 ; (16)

; Alors 

Load 0 ; (17)
Out ; (18)
Load Mem[0] ; (19)
Div 2 ; (20)
Store Mem[0] ; (21)
JMP 4 ; (22)

; Après

End ; (23)