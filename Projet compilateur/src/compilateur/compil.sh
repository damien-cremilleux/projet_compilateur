#!/bin/bash

DEST_DIR="/home/damienc/Desktop/compil/compilateur"
rm -rf $DEST_DIR
mkdir $DEST_DIR
cp * $DEST_DIR
cd $DEST_DIR
javacc Yaka.jj
rm TokenMgrError.java ParseException.java Token.java SimpleCharStream.java
javacc Yaka.jj
javac *.java