Load Mem[0] ; valeur a (0)
CMP Mem[1] ; valeur b (1)

; Si b-a < 0 <=> a > b
JC 4 ; Alors suivre l'instr 4(2)

; Sinon ne rien faire
JMP 9 ; Aller à la fin du programme (3)

; Alors
Store Mem[2] ; (4)
Load Mem[1] ; (5)
Store Mem[0] ; (6)
Load Mem[2] ; (7)
Store Mem[1] ; (8)

; Après, faire l'affichage pour vérifier que les valeurs sont ordonnées
Load Mem[0]
Out
Load Mem[1]
Out

; Fin du programme
End