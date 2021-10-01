; Initialisation
In
Store Mem[1] ; a
In
Store Mem[2] ; b
In
Store Mem[3] ; c
In
Store Mem[0] ; x

; Calcule ax²
Mul Mem[0]
Mul Mem[1]
Store Mem[4]

; Ajoute bx+c
Load Mem[0]
Mul Mem[2]
Add Mem[3]
Add Mem[4]

; Affiche le résultat
Out

; Fin
End