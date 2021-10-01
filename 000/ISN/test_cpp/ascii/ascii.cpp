
#include <iostream>
#include <string>
#include <stdio.h>

using namespace std;

// programme affichant tous les caractere ascii de la table etendue

int main()
{
    int nb;
    char QUIT;

    for(nb=0; nb<377; nb++)
    {
        cout << nb << " > ";
        printf("%c\n", nb);
        cout << endl;
    }

    QUIT = 'a';
    while(QUIT != 'q')
    {
        cin >> QUIT;
    }
    return 0;
}
