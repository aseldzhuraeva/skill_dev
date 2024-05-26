# How to run

```
mkdir skill-dev
cd skill-dev/
git clone git@github.com:aseldzhuraeva/skill_dev.git
cd skill_dev/
git checkout python
git pull origin python
ls
pip3 install jep
mvn clean install
chmod +x mvnw
./mvnw clean install
./mvmw clean package
java -Djava.library.path=/home/mephi1984/.local/lib/python3.8/site-packages/jep:/usr/lib/x86_64-linux-gnu/ -cp target/skill_dev-0.0.1-SNAPSHOT.jar org.springframework.boot.loader.JarLauncher --server.port=8025
#./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8025"
#history

```
