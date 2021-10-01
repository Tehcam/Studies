; Initialisation

In ; valeur a (0)
Store Mem[0] ; (1)
In ;  valeur b (2)

; Traitement

CMP Mem[0] ; test a-b (3)
JC 7 ; si a < b aller à l'instruction 7 (4)

; Sinon
Load 0 ; (5)
JMP 8; puis aller à la fin du programme (6)

; Alors
Load 1 ; (7)

; Fin du programme
Out ; affiche 0 ou 1 (8)
End ; (9)

