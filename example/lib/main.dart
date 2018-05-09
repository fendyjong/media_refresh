import 'dart:io';

import 'package:flutter/material.dart';
import 'package:media_refresh/media_refresh.dart';
import 'package:path_provider/path_provider.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Plugin example app'),
        ),
        body: new Center(
          child: new RaisedButton(
            child: new Text('test'),
            onPressed: () async {
              Directory appDocDir = await getExternalStorageDirectory();
              String path = appDocDir.path;

              try {
                bool result = await MediaRefresh.scanFile('$path/Download');
                print(result);
              } catch (e) {
                print(e);
              }
            },
          ),
        ),
      ),
    );
  }
}
