FROM maven:3.9-eclipse-temurin-17-focal AS build_step
RUN mkdir /build
COPY . /build
WORKDIR /build
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-focal
RUN mkdir /app
COPY --from=build_step /build/target/dflmngr-online-1.0-SNAPSHOT.jar \
                       /app/

WORKDIR /app
CMD java -jar /app/dflmngr-online-1.0-SNAPSHOT.jar