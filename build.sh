mkdir docker || echo mkdir docker
cp Dockerfile docker
cp grains.sc docker
cp run.sh docker
cd docker
docker build --rm -t birds .
