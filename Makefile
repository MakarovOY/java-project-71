clean:
	./gradlew clean

build:
	./gradlew clean build

test:
	./gradlew test

run-dist:
	./build/install/app/bin/app -h


report:
	./gradlew jacocoTestReport

report:
	make -C app report

.PHONY: build