# resilience4j

SP: Este repositorio contiene ejemplo de uso de la biblioteca de Java Resilience4J, especificamente en su integración con Spring Boot.
EN: This repository contains code sample of integration between resilience4j and Spring boot

Como usarla / probarla.

* Descarga el ejemplo y ponlo en ejecución.
* Necesitas tener docker instalado [Docker](https://docs.docker.com/install/) y [Docker Compose](https://docs.docker.com/compose/install/).
* Inicia las imágenes de docker.
```sh
docker-compose -f docker-compose.yml up
```
* Verifica el estado de prometheus.
( 1 - Abre http://localhost:9090, 2 - 
Access status -> Targets, both endpoints must be "UP")

*Configura Grafana.
 - Abre http://localhost:3000
 - **Configura la integración con prometheus**
     - Access configuration
     - Add data source
     - Select Prometheus
     - Use url "http://localhost:9090" and access with value "Browser"
 - **Configura el dashboard**
     - Access "home"
     - Import dashboard
     - Upload dashboard.json from /docker
     
 Artículo completo sobre este ejemplo [acá](https://sacavix.com/2020/06/14/resilience4j-tolerancia-a-fallos-completa/)
