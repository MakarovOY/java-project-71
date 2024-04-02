clean:
	./gradlew clean

build:
	./gradlew clean build


run-dist:
	./build/install/app/bin/app -h


report:
	./gradlew jacocoTestReport


.PHONY: build