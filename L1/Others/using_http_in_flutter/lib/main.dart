// package du sdk flutter :
// material.dart pour les objets de base du material design
// dart:async pour les objets relatifs aux futures comme StreamSubscription
import 'package:flutter/material.dart';
import 'dart:async';

// les imports perso
// peut s'écrire package:<mon_projet>/<mon_fichier>.dart
// ou simplement <mon_fichier>.dart
import 'package:using_http_in_flutter/my_list_tile.dart';
import 'team_shopping.dart';
import 'team_shopping_item.dart';
import 'my_text.dart';

// plugin pour vérifier la connexion internet
import 'package:internet_connection_checker/internet_connection_checker.dart';

// Variables globales
final MyAppState myState = MyAppState();
final MyText _myText = MyText();

// main de l'application (fonction runApp obligatoire pour lancer l'appli)
// Rq : la notation => correspond à un bloc d'instructions ne contenant qu'une seule instruction
void main() => runApp(MyApp());

/*
 * Comme ts les objets graphiques en flutter, l'appli elle meme est un widget
 * qui hérite donc de StatelessWidget ou StatefulWidget
 * Rq : l'appli doit tjr renvoyer un objet de type App (ici, MaterialApp)
 */
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // la méthode build est appelée après la construction de l'objet
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Team Shopping',
      home: _MyHome(),
    );
  }
}

// Ce widget renvoie la page d'accueil
// Pour des raisons pratiques, privilégier Scaffold comme premier widget de l'appli
class _MyHome extends StatelessWidget {
  const _MyHome({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text('Team Shopping', style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold)),
            _myText,
          ],
        ),
      ),
      body: _FirstPage(),
    );
  }
}

/*
 * Body de la page
 * Ce widget hérite de StatefulWidget, c'est à dire qu'il est géré par un State
 * La fonction createState est obligatoire et retourne le State chargé de ce widget
 */
class _FirstPage extends StatefulWidget {
  const _FirstPage({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return myState;
  }
}

/*
 * State de la page
 * Les objet Future sont affectés en asyncrone
 */
class MyAppState extends State<_FirstPage> {
  // le mot clé late permet de spécifier qu'un attribut ne sera initialisé que "plus tard" dans l'execution et non pas
  // nécessairement lors de la construction
  late Future<TeamShopping> futureTeamShopping;
  late Future<TeamShoppingItem>? futureTeamShoppingItem;
  late StreamSubscription<InternetConnectionStatus> _listener;
  late Future<bool> _connection;

  void request(TeamShoppingItem item, MyListTileState state) {
    futureTeamShoppingItem = TeamShoppingItem.patchTeamShopping(item.label, !item.is_already_bought);
    state.rebuild(futureTeamShoppingItem);
  }

  Future<bool> searchConnection() async {
    return await InternetConnectionChecker().hasConnection;
  }

  // renvoie une ListView personnalisée
  // permet uniquement de séparer les parties du code de la méthode build
  Widget returnList() {
    return FutureBuilder<TeamShopping>(
      future: futureTeamShopping,
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          final List<TeamShoppingItem> data = snapshot.data!.items;
          return ListView.separated(
            itemCount: data.length,
            itemBuilder: (_, index) {
              return MyListTile(item: data[index]);
            },
            separatorBuilder: (context, int index) =>
            const Divider(height: 0, thickness: 1.5),
          );
        } else if (snapshot.hasError) {
          return Center(
            child: Text(
              '${snapshot.error}',
              style: TextStyle(color: Colors.blueGrey),
            ),
          );
        }
        return Center(
            child: CircularProgressIndicator()
        );
      },
    );
  }

  // méthode appelée entre la construction de l'objet (=constructeur) et l'affichage du widget (=build)
  @override
  void initState() {
    super.initState();
    futureTeamShopping = TeamShopping.fetchTeamShopping();
    futureTeamShoppingItem = null;
    _connection = searchConnection();
    // le listener écoute si la connexion internet change d'état (on/offline)
    _listener = InternetConnectionChecker().onStatusChange.listen((event) {
      bool status = event == InternetConnectionStatus.connected;
      _myText.getState().rebuild(status);
      // la méthode setState modifie l'état du widget (i.e. le State) puis appelle de nouveau la méthode build
      setState(() {
        _connection = searchConnection();
      });
    });
  }

  // effectue l'affichage du widget
  @override
  Widget build(BuildContext context) {
    // FutureBuilder permet de mettre en place differente arborescence de widget en fonction de l'état d'un Future
    return FutureBuilder(
      future: _connection,
      builder: (BuildContext context, AsyncSnapshot<bool?> snapshot) {
        if(snapshot.hasData) {
          return snapshot.data! ? returnList() : Center(child: Icon(Icons.wifi_off, color: Colors.blueGrey, size: 50));
        } else if(snapshot.hasError) {
          return Center(
            child: Text(
              '${snapshot.error}'
            ),
          );
        }
        return Center(
          child: CircularProgressIndicator(),
        );
      },
    );
  }

  // méthode appelée juste avant la destruction de l'objet
  @override
  void dispose() {
    super.dispose();
    _listener.cancel();
  }
}
