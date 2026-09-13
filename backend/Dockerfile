# --- Étape 1 : Build Maven ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copie des fichiers de configuration Maven et téléchargement des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copie des sources et compilation du JAR
COPY src ./src
RUN mvn clean package -DskipTests

# --- Étape 2 : Image Runtime ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Variable pour passer d'éventuels arguments à l'application
EXPOSE 8080

# Copie du JAR compilé depuis la première étape
COPY --from=builder /app/target/*.jar app.jar

# Exécution de l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]