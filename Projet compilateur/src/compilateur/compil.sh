#!/bin/bash

DEST_DIR="/home/damienc/Desktop/compil/"
DEST_DIR_COMP="/home/damienc/Desktop/compil/compilateur"

rm -rf $DEST_DIR
mkdir $DEST_DIR
mkdir $DEST_DIR_COMP
cp * $DEST_DIR_COMP
cd $DEST_DIR_COMP
javacc Yaka.jj
rm TokenMgrError.java ParseException.java Token.java SimpleCharStream.java
javacc Yaka.jj
rm Test*
javac *.java