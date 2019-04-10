all: run

clean:
	rm -f src/*.class out/Permute.jar

Permute.jar: out/parcs.jar src/*.java
	@javac -cp out/parcs.jar src/*.java
	@jar cf out/Permute.jar -C src .
	@rm -f src/*.class

run: Permute.jar
	@cd out && java -cp 'parcs.jar:Permute.jar' Permute