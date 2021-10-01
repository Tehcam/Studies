; Initialisation
In ; (0)
Mod 2 ; (1)
CMP 0 ; (2)

; Si la valeur entrée au clavier est paire, i.e. ZF=1
Load Mem[1] ; (3)
JZ 11 ; Alors -> suivre l'instr 11 (4)

; Sinon
Add Mem[2] ; On fait la somme des valeurs (5)
Store Mem[0] ; (6) 
Load Mem[1] ; Puis le produit des valeurs (7)
Mul Mem[2] ; (8)
Store Mem[2] ; (9)
JMP 21 ; (10)

; Alors
Mul Mem[1] ; On détermine le carré de Mem[1] (11)
Store Mem[1] ; (12)
Load Mem[2] ; Idem pour Mem[2] (13)
Mul Mem[2] ; (14)
Store Mem[2] ; (15) 
Add Mem[1] ; On fait la somme du carré des valeurs.. (16)
Store Mem[0] ; ... que l'on garde dans Mem[0] temporairement (17)
Load Mem[1] ; On calcule ensuite la différence du carré des valeurs (18)
Sub Mem[2] ; (19)
Store Mem[2] ; On garde la différence dans Mem[2] (20)

; Après
; Ici, instructions facultatives mais permettent de retrouver le résultat dans les variables de départ
Load Mem[0] ; Enfin on retourne la somme dans Mem[1] (21)
Store Mem[1] ; (22)

; Affichage
Out 
Load Mem[2]
Out

; Fin
End