// Graphics Windows' Running Test
// And Counters within CMD.exe Game

// 25/01/2020
// Corentin as SEN

#ifndef SOURCE_INCLUDED
#define SOURCE_INCLUDED

#include "head.h"
#include<SDL.h>
#include<SDL_image.h>

#endif // SOURCE_INCLUDED

void pause()
{
    int continuer = 1;
    SDL_Event event;

    while (continuer)
    {
        SDL_WaitEvent(&event);
        switch(event.type)
        {
            case SDL_QUIT:
                continuer = 0;
        }
    }
}

int main(int argc, char *argv[]){

    SDL_Init(SDL_INIT_VIDEO);

    // Test_1 : ouvrir une fenetre de 640x480 px en format 32 bits/px
    SDL_CreateWindow("Test_Window",
                    SDL_WINDOWPOS_CENTERED,
                    SDL_WINDOWPOS_CENTERED,
                    900, 600,
                    SDL_WINDOW_RESIZABLE);

    if(!IMG_Load(FILE_0)){
        fprintf(stderr, "error : %s\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }else{IMG_Load(FILE_0);}

    pause();
    SDL_Quit();

    // Exit the programm :
    char QUIT = 'a';
    cout << "press 'q' to quit :" << endl;
    while(QUIT != 'q'){
        cin >> QUIT;
    }

    return 0;
}
