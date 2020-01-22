FROM maven:3.5.4-jdk-8

LABEL maintainer="subbareddygangalal@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=target/ShopingCart_MultiBranch_Pipeline-*.jar

COPY ${jar_file} ShopingCart_MultiBranch_Pipeline.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ShopingCart_MultiBranch_Pipeline-*.jar"]
