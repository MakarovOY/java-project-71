clean:
	./gradlew clean

build:
	./gradlew clean build

test:
	./gradlew test

run-dist:
	./build/install/app/bin/app


report:
	./gradlew jacocoTestReport


.PHONY: build