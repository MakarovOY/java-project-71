.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	 build\install\app\bin\app -f stylish src\test\resources\fixtures\file3.json src\test\resources\fixtures\file4.json

run:
	./gradlew run

test:
	./gradlew test

report:
	gradle jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build