FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# FIX: give execute permission to gradlew
RUN chmod +x gradlew

RUN ./gradlew clean build

EXPOSE 8080

CMD java -jar build/libs/app.jar

