import 'team_shopping_item.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

// Objet gérant la liste de course
// notamment utilisé pour récupérer la liste lorsque l'appli est lancée
class TeamShopping {
  final List<TeamShoppingItem> items;

  TeamShopping(this.items);

  factory TeamShopping.fromJson(List<dynamic> jsons) {
    List<TeamShoppingItem> items = [];
    for(Map<String, dynamic> json in jsons) {
      TeamShoppingItem item = TeamShoppingItem.fromMap(json);
      items.add(item);
    }
    return TeamShopping(items);
  }

  // récupère ts les items de la liste de course
  static Future<TeamShopping> fetchTeamShopping() async {
    final res = await http.get(Uri.parse('http://10.253.55.58:2002/items.json'));
    if(res.statusCode == 200) {
      print('Fetch successed');
      return TeamShopping.fromJson(jsonDecode(res.body));
    } else {
      print('Fetch failed');
      throw Exception('Load items failed with error ${res.statusCode}');
    }
  }
}