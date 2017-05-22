#!/bin/bash

mkdir project-files
cd project-files
for file in $(find ~/.m2/ -name *.jar); do
	# If the jar contains a project.clj, move it to the side.
	echo Extracting from $file
	unzip -j "$file" "project.clj" -d ./
	new=${file##*/} new=${new%.jar}
	mv project.clj $new 2>/dev/null
done
cd ..
