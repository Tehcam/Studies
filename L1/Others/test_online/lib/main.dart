import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:internet_connection_checker/internet_connection_checker.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  late StreamSubscription<InternetConnectionStatus> _listener;
  late Future<bool> _connection;
  final _MyText _myText = _MyText();

  @override
  void initState() {
    super.initState();
    _connection = searchConnection();
    _listener = InternetConnectionChecker().onStatusChange.listen((event) {
      bool status = event == InternetConnectionStatus.connected;
      _myText.getState().rebuild(status);
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Online demo',
      home: Scaffold(
        appBar: AppBar(title: Text('Online demo')),
        body: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                _myText,
                Container(
                  child: FutureBuilder<bool>(
                    future: _connection,
                    builder: (context, snapshot) {
                      if(snapshot.hasData) {
                        Future.delayed(Duration(seconds: 3), () {
                          _myText.getState().rebuild(snapshot.data!);
                        });
                        return Text('No error', style: TextStyle(color: Colors.blueGrey));
                      } else if(snapshot.hasError) {
                        return Text(
                            '${snapshot.error}'
                        );
                      }
                      return CircularProgressIndicator();
                    },
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    super.dispose();
    _listener.cancel();
  }

  Future<bool> searchConnection() async {
    return await InternetConnectionChecker().hasConnection;
  }
}

class _MyText extends StatefulWidget {
  _MyText({Key? key}) : super(key: key);
  final _MyTextState state = _MyTextState();

  @override
  _MyTextState createState() {
    return state;
  }

  _MyTextState getState() {
    return state;
  }
}

class _MyTextState extends State<_MyText> {
  bool _status = false;

  @override
  Widget build(BuildContext context) {
    return Text(
        _status ? 'ONLINE' : 'OFFLINE'
    );
  }

  void rebuild(bool status) {
    setState(() {
      _status = status;
    });
  }
}

