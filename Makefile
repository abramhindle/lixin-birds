build:	build.sh Dockerfile
	bash	build.sh

run:	Dockerfile dockerun.sh
	bash dockerun.sh /bin/bash /birds/run.sh

shell:	Dockerfile dockerun.sh
	bash dockerun.sh /bin/bash
