for FILE in *; do
    if [ -d $FILE ]; then
        cd $FILE
        make && make clean
        cd ..
    fi
done
