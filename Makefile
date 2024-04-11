clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install
test:
	./gradlew test
report:
	./gradlew jacocoTestReport


run-dist:
	./build/install/app/bin/app



build-run: build run


.PHONY: build