FROM openjdk

RUN mkdir -p /exam-level-4

ARG POSTGRES_URL_DEFAULT=jdbc:postgresql://192.168.0.158:5432/petclinic

ENV POSTGRES_URL=${POSTGRES_URL_DEFAULT}

ENV POSTGRES_USER=petclinic

ENV POSTGRES_PASS=petclinic

COPY . /exam-level-4

EXPOSE 8080

ENTRYPOINT [ "java", "-Dspring.profiles.active=postgres", "-jar", "/exam-level-4/spring-petclinic.jar" ]