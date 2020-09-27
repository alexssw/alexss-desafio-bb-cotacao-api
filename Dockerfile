FROM java:8
LABEL maintainer=“alexssw@hotmail.com”
VOLUME /tmp
EXPOSE 8080
ADD build/libs/alexss-desafio-bb-cotacao-api-0.0.1-SNAPSHOT.jar alexss-desafio-bb-cotacao-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","alexss-desafio-bb-cotacao-api-0.0.1-SNAPSHOT.jar"]