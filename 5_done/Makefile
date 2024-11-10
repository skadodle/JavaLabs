JC = javac
JV = java 

# in JAR write path to !junit console launcher!
JAR = "../junit-platform-console-standalone-1.11.0.jar" 
SRC = simpleSort.java testSimpleSort.java 
TEST = testSimpleSort
MAIN = testSimpleSort
OUT = simpleSort.class testSimpleSort.class

run_test: $(OUT)
	@$(JV) -jar $(JAR) -cp "." --select-class $(TEST)

run_main: $(OUT)
	@$(JV) $(MAIN)

$(OUT): $(SRC)
	@$(JC) -cp $(JAR) $(SRC)

clean:
	@rm -vf $(OUT) simpleSort*.class
