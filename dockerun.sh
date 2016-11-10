mkdir output || echo output
docker run -i -t -v `pwd`/samples:/birds/samples -v `pwd`/output:/birds/output birds $*
