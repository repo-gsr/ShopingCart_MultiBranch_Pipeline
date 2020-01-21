FROM maven:3.5.4-jdk-8

LABEL maintainer="subbareddygangalal@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=target/ShopingCart-0.0.1-SNAPSHOT.jar

COPY ${jar_file} ShopingCart.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ShopingCart.jar"]
