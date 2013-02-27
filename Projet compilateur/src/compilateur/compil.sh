#!/bin/bash

DEST_DIR="/home/damienc/Desktop/compil"
rm -r $DEST_DIR
mkdir $DEST_DIR
cp * $DEST_DIR
cd $DEST_DIR
javacc Yaka.jj
javac *.java