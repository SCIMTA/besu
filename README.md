# Build

./gradlew installDist 

docker image build ./build/install/ -f ./docker/openjdk-11/Dockerfile -t neckgamervn/pesu:1.0
