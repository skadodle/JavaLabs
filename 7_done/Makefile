JC = javac
JV = java 

# in JAR write path to !junit console launcher!
JAR = "../junit-platform-console-standalone-1.11.0.jar" 
SRC = linSort.java testLinSort.java 
TEST = testLinSort
MAIN = testLinSort
OUT = linSort.class testLinSort.class 

run_test: $(OUT)
	@$(JV) -jar $(JAR) -cp "." --select-class $(TEST)

run_main: $(OUT)
	@$(JV) $(MAIN)

$(OUT): $(SRC)
	@$(JC) -cp $(JAR) $(SRC)

clean:
	@rm -vf $(OUT)
