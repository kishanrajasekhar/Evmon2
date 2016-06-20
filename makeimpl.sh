#!/bin/bash

function build()
{
        echo "Building Evmon2..."
        cd src 

        echo "Collecting source files..."
        for src_file in *.java
        do
                src_file_names+="$src_file "
        done
        echo "Ready to compile $src_file_names"
        javac $src_file_names -d ../bin

        cd .. 
        
        cd bin

        echo "Collecting class files..."
        for class_file in *.class
        do
                class_file_names+="$class_file "
        done
        echo "Packing up $class_file_names into evmon2.jar..."
        jar cfe evmon2.jar driver2 $class_file_names 

        cd .. 
        
        echo "Done. JAR executable file resides in your bin directory."
}

function clean()
{
        echo "Cleaning build files..."
        build_files=($(find bin -name "*.class" -or -name "*.jar"))

        for build_file in "${build_files[@]}"
        do 
                echo "Removing $build_file"
                rm $build_file
        done
        echo "All cleaned."
}

if [ "$1" == "build" ]
then
        build
elif [ "$1" == "clean" ]
then
        clean
fi
