clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install
test:
	./gradlew test


run-dist:
	./build/install/app/bin/app


report:
	./gradlew jacocoTestReport


.PHONY: build