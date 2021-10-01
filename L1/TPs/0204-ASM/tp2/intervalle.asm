; Initialisation

In ; (0)
Store Mem[0] ; a (1)
In ; (2)
Store Mem[1] ; b (3)

; Vérifier que a<=b

Load Mem[0] ; (4)
CMP Mem[1] ; (5)
JC 22 ; alors a>b => erreur (6)

; Après, si pas d'erreur à l'initialisation

In ; (7)
Store Mem[2] ; x (8)

; Si x-a<0

Load Mem[0] ; (9)
CMP Mem[2] ; (10)
JC 18 ; alors x<a (11)

; Sinon si x<b ou x==b

Load Mem[1] ; (12)
CMP Mem[2] ; (13)
JC 20 ; alors x>=a && x<=b (14)
JZ 20 ; idem (15)

; Sinon

Load 2 ; (16)
JMP 21; saut d'évitement (17)

; Alors x<a

Load 0 ; (18)
JMP 21; saut d'évitement (19)

; Alors x>=a && x<=b

Load 1 ; (20)

; Fin du programme
Out ; (21)
End ; (22)