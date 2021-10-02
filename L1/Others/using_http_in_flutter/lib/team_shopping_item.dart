import 'dart:convert';
import 'package:http/http.dart' as http;

// Gestion des items de la liste de course
class TeamShoppingItem {
  final int id;
  final String label;
  final int quantity;
  bool is_already_bought;
  final String rayon_label;

  TeamShoppingItem({required this.id, required this.label, required this.quantity, required this.is_already_bought, required this.rayon_label});

  // retourne un objet item à partir d'une map (= issue du décodage de données json)
  factory TeamShoppingItem.fromMap(Map<String, dynamic> json) {
    final Map<String, dynamic> rayon;
    final String rayon_label;

    if(json['rayon'] != null) {
      rayon = json['rayon'];
      rayon_label = rayon['label'];
    } else {
      rayon_label = '';
    }

    return TeamShoppingItem(
        id: json['id'],
        label: json['label'],
        quantity: json['quantity'],
        is_already_bought: (json['is_already_bought'] != null) ? json['is_already_bought'] : false,
        rayon_label: rayon_label
    );
  }

  // Envoie un patch au serveur pour update l'état de l'item dans la table lorsque l'utilisateur clique sur une tuile de la liste
  static Future<TeamShoppingItem> patchTeamShopping(String label, bool is_already_bought) async {
    Map<String, bool> data = {'is_already_bought': is_already_bought};
    final res = await http.patch(
      Uri.parse('http://10.253.55.58:2002/items/label/$label.json'),
      headers: {'content-type': 'application/json'},
      body: jsonEncode(data),
    );
    // retour de la fonction une fois la requete au serveur finie
    if(res.statusCode == 200) {
      return TeamShoppingItem.fromMap(jsonDecode(res.body));
    } else {
      throw Exception('The PATCH method failed with error ${res.statusCode}');
    }
  }
}