FROM openjdk:21-jdk-slim
#aqui ele baixa uma imagem do java 21

#aqui eu posso definir o diretorio onde vai ficar os arquivos no container

WORKDIR /app

#copio o .jar que está em target (o .jar é o meu codigo compilado e empacotado para rodar em todas as maquinsa

COPY target/*.jar app.jar


#aqui declaro que ele vai ouvir a porta 8080
EXPOSE 8080

# executo a chamada ao docker para ele excecutar o .jar ( que está com todo codigo compilado corretamente) quando o container rodar
#quuando eu rodar o container, ele vai rodar o .jar que está dentro dele

ENTRYPOINT ["java", "-jar", "app.jar"]




