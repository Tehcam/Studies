; Initialisation

In ; valeur a (0)
Store Mem[0] ; (1)
In ;  valeur b (2)

; Traitement

CMP Mem[0] ; test a-b (3)
JC 8 ; si a < b aller à l'instruction 8 (4)
JZ 8 ; si a == b aller à l'instr 8 aussi (5)

; Sinon
Load 1 ; (6)
JMP 9; puis aller à la fin du programme (7)

; Alors
Load 0 ; (8)

; Fin du programme
Out ; affiche 0 ou 1 (9)
End ; (10)

