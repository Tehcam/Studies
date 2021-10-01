package pack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Vector;

public class Controller
{
    private GDR game = new GDR();
    private javafx.beans.property.ReadOnlyBooleanProperty finished = game.getFinishedProperty();
    private Vector<ImageView> vector = new Vector<ImageView>();
    private Etats currentState = Etats.X;

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private Button reset;
    @FXML
    private Label state;

    @FXML
    public void initialize()
    {
        // initialisation du controleur
        vector.add(img1);
        vector.add(img2);
        vector.add(img3);
        vector.add(img4);
        vector.add(img5);
        vector.add(img6);
        vector.add(img7);
        vector.add(img8);
        vector.add(img9);
        newGame();
    }

    @FXML
    public void newGame()
    {
        state.setText("Tour de Joueur 1");
        currentState = Etats.X;
        Image image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Vide.PNG"));
        for(ImageView i : vector)
        {
            i.setImage(image);
            i.setDisable(false);
        }
        game.reset();
    }

    @FXML
    public void flip1()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img1.setImage(image);
        flip(0,0);
        img1.setDisable(true);
    }

    @FXML
    public void flip2()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img2.setImage(image);
        flip(0,1);
        img2.setDisable(true);
    }

    @FXML
    public void flip3()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img3.setImage(image);
        flip(0,2);
        img3.setDisable(true);
    }

    @FXML
    public void flip4()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img4.setImage(image);
        flip(1,0);
        img4.setDisable(true);
    }

    @FXML
    public void flip5()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img5.setImage(image);
        flip(1,1);
        img5.setDisable(true);
    }

    @FXML
    public void flip6()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img6.setImage(image);
        flip(1,2);
        img6.setDisable(true);
    }

    @FXML
    public void flip7()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img7.setImage(image);
        flip(2,0);
        img7.setDisable(true);
    }

    @FXML
    public void flip8()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img8.setImage(image);
        flip(2,1);
        img8.setDisable(true);
    }

    @FXML
    public void flip9()
    {
        Image image;
        if(currentState == Etats.X)
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Croix.PNG"));
        else
            image = new Image(this.getClass().getResourceAsStream("image" + File.separator + "Case_Rond.PNG"));
        img9.setImage(image);
        flip(2,2);
        img9.setDisable(true);
    }

    private void flip(int a, int o)
    {
        game.set(a, o, getCurrentState());
        if(finished.getValue())
        {
            switch(game.getWinner())
            {
                case VIDE:
                    state.setText("Match nul !");
                    break;
                case X :
                    state.setText("Joueur 1 a gagne !");
                    break;
                case O : 
                    state.setText("Joueur 2 a gagne !");
                    break;
            }
            for(ImageView i : vector)
                i.setDisable(true);
        }
    }

    private Etats getCurrentState()
    {
        if(currentState == Etats.X)
        {
            state.setText("Tour de Joueur 2");
            currentState = Etats.O;
            return Etats.X;
        }
        else
        {
            state.setText("Tour de Joueur 1");
            currentState = Etats.X;
            return Etats.O;
        }
    }
}

