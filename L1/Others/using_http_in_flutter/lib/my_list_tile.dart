import 'package:flutter/material.dart';
import 'team_shopping_item.dart';
import 'main.dart';

/*
 * Pour les types de widget et les overrides, voir les commentaires de main.dart
 * Ce widget gère les tuiles de la liste de course
 */
class MyListTile extends StatefulWidget {
  final TeamShoppingItem item;

  const MyListTile({Key? key, required this.item}) : super(key: key);

  @override
  MyListTileState createState() => MyListTileState(item: this.item);
}

class MyListTileState extends State<MyListTile> {
  TeamShoppingItem item;
  String rayon;
  late Future<TeamShoppingItem>? futureTeamShoppingItem;

  MyListTileState({ required this.item, this.rayon = ''} ) { this.rayon = this.item.rayon_label; }

  Widget _Tile() {
    return ListTile(
      title: Text(
          item.label.toUpperCase() + ' (' + item.quantity.toString() + ')',
          style: item.is_already_bought ? TextStyle(
              decoration: TextDecoration.lineThrough,
              decorationThickness: 2,
              fontWeight: FontWeight.bold) : TextStyle(
              fontWeight: FontWeight.bold)),
      subtitle: Text(
          this.rayon, style: TextStyle(color: Colors.blueGrey)),
      trailing: Icon(
          item.is_already_bought ? Icons.done : Icons.add_box_outlined),
      contentPadding: const EdgeInsets.symmetric(horizontal: 25),
      tileColor: item.is_already_bought
          ? Color.fromRGBO(80, 200, 255, 0.3)
          : Colors.white,
      // gestion de l'event lorsque la tuile est cliquée
      onTap: () => myState.request(item, this),
    );
  }

  @override
  void initState() {
    super.initState();
    futureTeamShoppingItem = null;
  }

  @override
  Widget build(BuildContext context) {
    if(futureTeamShoppingItem == null) {
      return _Tile();
    } else {
      return FutureBuilder<TeamShoppingItem>(
        future: futureTeamShoppingItem,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            this.item = snapshot.data!;
            return _Tile();
          } else if (snapshot.hasError) {
            showDialog(
              context: context,
              builder: (BuildContext context) {
                return AlertDialog(
                  title: Text('Error :'),
                  content: SingleChildScrollView(
                    child: ListBody(
                      children: [
                        Text('${snapshot.error}')
                      ],
                    ),
                  ),
                  actions: [
                    TextButton(
                      child: Text('OK'),
                      // gestion de l'event lorsque le bouton de l'alerte est cliqué
                      onPressed: () {
                        Navigator.of(context).pop();
                      },
                    )
                  ],
                );
              },
            );
          }
          return ListTile(
            title: Text(
                item.label.toUpperCase() + ' (' + item.quantity.toString() + ')',
                style: item.is_already_bought ? TextStyle(
                    decoration: TextDecoration.lineThrough,
                    decorationThickness: 2,
                    fontWeight: FontWeight.bold) : TextStyle(
                    fontWeight: FontWeight.bold)),
            subtitle: Text(
                this.rayon, style: TextStyle(color: Colors.blueGrey)),
            trailing: CircularProgressIndicator(),
            contentPadding: const EdgeInsets.symmetric(horizontal: 25),
            tileColor: item.is_already_bought
                ? Color.fromRGBO(80, 200, 255, 0.3)
                : Colors.white,
            // gestion de l'event lorsque la tuile est cliquée
            onTap: () => myState.request(item, this),
          );
        },
      );
    }
  }

  // permet aux autres objets de rafraichir l'état de la tuile (lors d'un event par exemple)
  void rebuild(Future<TeamShoppingItem>? futureTeamShoppingItem) {
    setState(() {
      this.futureTeamShoppingItem = futureTeamShoppingItem;
    });
  }
}

