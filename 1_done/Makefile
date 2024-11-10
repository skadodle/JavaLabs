JC = javac
JV = java 

# in JAR write path to !junit console launcher!
JAR = "../junit-platform-console-standalone-1.11.0.jar" 
SRC = Complex.java TestComplex.java 
TEST = TestComplex
MAIN = TestComplex
OUT = Complex.class TestComplex.class

run_test: $(OUT)
	@$(JV) -jar $(JAR) -cp "." --select-class $(TEST)

run_main: $(OUT)
	@$(JV) $(MAIN)

$(OUT): $(SRC)
	@$(JC) -cp $(JAR) $(SRC)

clean:
	@rm -vf $(OUT)
