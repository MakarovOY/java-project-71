clean:
	./gradlew clean

build:
	./gradlew clean build

test:
	./gradlew test
install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app


report:
	./gradlew jacocoTestReport


.PHONY: build