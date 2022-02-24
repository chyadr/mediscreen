./build-patient.sh
./build-note.sh
./build-assessment.sh
./build-webapp.sh
docker login
docker build . -t patient -f Dockerfile.patient
docker build . -t note -f Dockerfile.note
docker build . -t assessment -f Dockerfile.assessment
docker build . -t webapp -f Dockerfile.webapp

docker-compose up