JC = javac
JV = java 

# in JAR write path to !junit console launcher!
JAR = "../junit-platform-console-standalone-1.11.0.jar" 
SRC = effectiveSort.java testEffectiveSort.java 
TEST = testEffectiveSort
MAIN = testEffectiveSort
OUT = effectiveSort.class testEffectiveSort.class 

run_test: $(OUT)
	@$(JV) -jar $(JAR) -cp "." --select-class $(TEST)

run_main: $(OUT)
	@$(JV) $(MAIN)

$(OUT): $(SRC)
	@$(JC) -cp $(JAR) $(SRC)

clean:
	@rm -vf $(OUT)
