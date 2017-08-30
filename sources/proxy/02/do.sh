#!/bin/bash

javac -classpath .:cglib-nodep-3.2.5.jar CglibEnhancer.java
java -classpath .:cglib-nodep-3.2.5.jar CglibEnhancer
