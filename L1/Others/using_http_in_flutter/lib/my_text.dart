import 'package:flutter/material.dart';

class MyText extends StatefulWidget {
  MyText({Key? key}) : super(key: key);
  final _MyTextState state = _MyTextState();

  @override
  _MyTextState createState() {
    return state;
  }

  _MyTextState getState() {
    return state;
  }
}

class _MyTextState extends State<MyText> {
  bool _status = false;

  @override
  Widget build(BuildContext context) {
    return Text(
      _status ? 'ONLINE' : 'OFFLINE',
      style: TextStyle(color: Colors.white, fontSize: 10),
    );
  }

  void rebuild(bool status) {
    setState(() {
      _status = status;
    });
  }
}
