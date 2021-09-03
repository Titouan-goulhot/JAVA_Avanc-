FROM maven:3.8.2-jdk-11

WORKDIR /usr/app

COPY . .

RUN mvn clean install -DskipTests

CMD ["java","-jar","target/demo-0.0.1-SNAPSHOT.jar"]

#
# RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'
#
# ENTRYPOINT ["java","-jar","demo-docker-0.0.1-SNAPSHOT.jar"]