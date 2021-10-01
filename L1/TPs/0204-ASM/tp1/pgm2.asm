; Affiche les valeurs contenues dans les 2 premières cases memoire
Load Mem[0]
Out
Load Mem[1]
Out

; Sauvegarde la somme des valeurs dans Mem[2]
Add Mem[0]
Store Mem[2]
Out

; Sauvegarde le produit des valeurs dans Mem[3]
Load Mem[0]
Mul Mem[1]
Store Mem[3]
Out

; Fin du programme
End