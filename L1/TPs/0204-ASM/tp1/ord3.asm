; Hypothèse : les cases mémoire 0, 1, 2 sont initialisées
; Mem[3] est la case de sauvegarde tmp du minimum des valeurs

; Init
Load Mem[0] ; (0)
Store Mem[3] ; (1)

; Vérif de la case 1
CMP Mem[1] ; (2)
; Si Mem[1]-Mem[0] < 0 <=> Mem[0] > Mem[1]
JC 7; Alors suivre l'instr 7 (3)
; Sinon 
Load Mem[1] ; (4)
Store Mem[3] ; (5)
JMP 11 ; (6)

; Alors
Load Mem[1] ; (7)
Store Mem[0] ; (8)
Load Mem[3] ; (9)
Store Mem[1] ; (10)

; Après, vérif de la case 2
CMP Mem[2] ; (11)
; Si Mem[2]-Mem[1] < 0 <=> Mem[1] > Mem[2]
JC 14 ; Alors suivre l'instr 14 (12)
; Sinon, ne rien faire
JMP 27 ; Aller à la fin du programme (13)

; Alors
Load Mem[2] ; (14)
Store Mem[1] ; (15)
Load Mem[3] ; (16)
Store Mem[2] ; (17)

; Il reste à vérifier si Mem[1] est plus grande que Mem[0]

Load Mem[0] ; (18)
CMP Mem[1] ; (19)
; Si Mem[1]-Mem[0] < 0 <=> Mem[0] > Mem[1]
JC 22 ; Alors suivre l'instr 22 (20)
; Sinon, ne rien faire
JMP 27 ; Aller à la fin du programme (21)

; Alors
Store Mem[3] ; (22)
Load Mem[1] ; (23)
Store Mem[0] ; (24)
Load Mem[3] ; (25)
Store Mem[1] ; (26)

; Après, faire l'affichage pour vérifier
Load Mem[0] ; (27)
Out
Load Mem[1]
Out
Load Mem[2]
Out

; Fin du programme
End