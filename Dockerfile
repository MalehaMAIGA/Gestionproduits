FROM eclipse-temurin:17-jdk-alpine
LABEL authors="andreas"

WORKDIR /app

# Copie du JAR généré par Maven
COPY target/produit.jar ./produit.jar

# Port d’écoute dans le conteneur
EXPOSE 8082

# Commande de démarrage (bien mettre "java")
CMD ["java", "-jar", "produit.jar"]
