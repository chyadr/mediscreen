export DOCKER_USER=
export DOCKER_PASS=
./build-patient.sh
./build-note.sh
./build-assessment.sh
./build-webapp.sh
docker login --username=$DOCKER_USER --password=$DOCKER_PASS
docker build . -t patient -f Dockerfile.patient
docker build . -t note -f Dockerfile.note
docker build . -t assessment -f Dockerfile.assessment
docker build . -t webapp -f Dockerfile.webapp

docker-compose up