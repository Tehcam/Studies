; Initialisation

In ; (0)
Store Mem[0] ; (1)
In ; (2)
Store Mem[1] ; (3)
In ; (4)
Store Mem[2] ; (5)

; Vérifier si b=0 ET (c=4 OU c=5)

Load Mem[1] ; (6)
CMP 0 ; (7)
JZ 10 ; si b=0 alors on continue les vérifications (8)
JMP 15 ; sinon on passe au cas parmi (9)
Load Mem[2] ; (10)
CMP 4 ; (11)
JZ 41 ; => erreur (12)
CMP 5 ; (13)
JZ 41 ; => erreur (14)

; Si aucune erreur, faire le cas parmi :

Load Mem[2] ; (15)
CMP 0 ; (16)
JZ 41 ; alors ne rien afficher (17)
CMP 2 ; (18)
JZ 29 ; alors a-b (19)
CMP 3 ; (20)
JZ 32 ; alors a*b (21)
CMP 4 ; (22)
JZ 35 ; alors a/b (23)
CMP 5 ; (24)
JZ 38 ; alors a%b (25)

; Traitement par défaut : a+b

Load Mem[0] ; (26)
Add Mem[1] ; (27)
JMP 40 ; saut d'évitement (28)

; Alors a-b

Load Mem[0] ; (29)
Sub Mem[1] ; (30)
JMP 40 ; saut d'évitement (31)

; Alors a*b

Load Mem[0] ; (32)
Mul Mem[1] ; (33)
JMP 40 ; saut d'évitement (34)

; Alors a/b

Load Mem[0] ; (35)
Div Mem[1] ; (36)
JMP 40 ; saut d'évitement (37)

; Alors a%b

Load Mem[0] ; (38)
Mod Mem[1] ; (39)

; Fin du programme
Out ; (40)
End ; (41)