# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/bank/payment/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bank/payment/Application.java` — `reactor.core.publisher`: El import reactor.core.publisher.Hooks pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/Application.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/domain/ports/PaymentRepository.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/domain/ports/CreditBureauClient.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/domain/ports/BankCoreClient.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/domain/ports/AuditEventPublisher.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/infrastructure/adapters/PaymentJpaRepository.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCase.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/application/usecases/RecoverPaymentsUseCase.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/application/events/PaymentRegisteredEvent.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/bank/payment/bdd/PaymentRegistrationSteps.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/bank/payment/application/usecases/RegisterPaymentUseCaseTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCaseTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java` — `Payment.setCreditBureauResponse`: Se invoca `setCreditBureauResponse` sobre `Payment`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java` — `Builder.baseUrl`: Se invoca `baseUrl` sobre `Builder`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java` — `Builder.baseUrl`: Se invoca `baseUrl` sobre `Builder`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java` — `RegisterPaymentUseCase.execute`: Se invoca `execute` sobre `RegisterPaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java` — `RecoverPaymentsUseCase.recoverPayment`: Se invoca `recoverPayment` sobre `RecoverPaymentsUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnologia Java, Advanced

### Brecha de conocimiento
Aplica metodologias de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatizacion como Cucumber, el framework Karate, etc.

### Misión / candidato
Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con solida base en arquitectura y testing.

### Reto
- Tema: Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un Flujo de Pagos con BDD
- Tiempo estimado: 1 semana

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Registro de Pagos — objetivo: Implementar la funcionalidad para registrar pagos únicos por canal y número de operación. — entregable (NO resolver): Sistema que registra pagos únicos por canal y número de operación, manejando errores específicos.
- Fase 2: Consolidación de Canales — objetivo: Consolidar los pagos de los tres canales en un único flujo sin pérdida de datos ante backpressure de uno de ellos. — entregable (NO resolver): Sistema que consolida pagos de los tres canales sin pérdida de datos ante backpressure.
- Fase 3: Recuperación Automática — objetivo: Implementar la recuperación automática de pagos ante caída del consumidor downstream sin reprocesar los ya emitidos. — entregable (NO resolver): Sistema que recupera automáticamente los pagos ante caída del consumidor downstream sin reprocesar los ya emitidos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.bank</groupId>
    <artifactId>payment</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>payment</name>
    <description>Sistema de pagos bancarios con manejo reactivo y BDD</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <resilience4j.version>2.2.0</resilience4j.version>
        <reactor.version>3.6.8</reactor.version>
        <cucumber.version>7.18.0</cucumber.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>

        <!-- Reactor -->
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core</artifactId>
            <version>${reactor.version}</version>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Kafka -->
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>3.8.0</version>
        </dependency>

        <!-- SpringDoc OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
            <version>2.9.1</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bank/payment/Application.java ===
package com.bank.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.publisher.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Hooks.onOperatorDebug();
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("Aplicación iniciada correctamente. Perfiles activos: {}",
            String.join(",", SpringApplication.run(Application.class).getEnvironment().getActiveProfiles()));

        // Configuración global de Reactor para mejor manejo de errores en producción
        Hooks.onOperatorError((throwable, data) -> {
            logger.error("Error en flujo reactivo", throwable);
            return throwable;
        });
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: payment-service
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://localhost:5432/payment_db
    username: payment_user
    password: payment_pass
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 2
      idle-timeout: 30000
      connection-timeout: 30000
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
        jdbc:
          lob:
            non_contextual_creation: true
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
    consumer:
      group-id: payment-group
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: "com.bank.payment.application.events"
        spring.json.value.default.type: "com.bank.payment.application.events.PaymentRegisteredEvent"

server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always

resilience4j:
  circuitbreaker:
    instances:
      creditBureau:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.util.concurrent.TimeoutException
          - org.springframework.web.reactive.function.client.WebClientRequestException
      bankCore:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 10s
        failureRateThreshold: 40
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.util.concurrent.TimeoutException
          - org.springframework.web.reactive.function.client.WebClientRequestException
  retry:
    instances:
      creditBureau:
        maxAttempts: 3
        waitDuration: 1s
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.util.concurrent.TimeoutException
      bankCore:
        maxAttempts: 3
        waitDuration: 1s
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.util.concurrent.TimeoutException

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
    operationsSorter: method
    tagsSorter: alpha

logging:
  level:
    root: INFO
    com.bank.payment: DEBUG
    org.springframework.web: INFO
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    reactor.netty.http.client: DEBUG

// === ARCHIVO: src/main/java/com/bank/payment/domain/model/Payment.java ===
package com.bank.payment.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de dominio que representa un pago con unicidad garantizada por operación y canal.
 * Incluye validaciones de negocio para asegurar consistencia.
 */
public final class Payment {
    private final UUID id;
    private final String operationNumber;
    private final String channel;
    private final BigDecimal amount;
    private final String currency;
    private final String accountNumber;
    private final String beneficiaryAccount;
    private final LocalDateTime createdAt;
    private final String status;
    private final String creditBureauResponse;
    private final String bankCoreResponse;

    private Payment(Builder builder) {
        this.id = Objects.requireNonNull(builder.id, "El ID no puede ser nulo");
        this.operationNumber = Objects.requireNonNull(builder.operationNumber, "El número de operación no puede ser nulo");
        this.channel = Objects.requireNonNull(builder.channel, "El canal no puede ser nulo");
        this.amount = Objects.requireNonNull(builder.amount, "El monto no puede ser nulo");
        this.currency = Objects.requireNonNull(builder.currency, "La moneda no puede ser nula");
        this.accountNumber = Objects.requireNonNull(builder.accountNumber, "El número de cuenta no puede ser nulo");
        this.beneficiaryAccount = Objects.requireNonNull(builder.beneficiaryAccount, "La cuenta del beneficiario no puede ser nula");
        this.createdAt = Objects.requireNonNull(builder.createdAt, "La fecha de creación no puede ser nula");
        this.status = Objects.requireNonNull(builder.status, "El estado no puede ser nulo");
        
        if (builder.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        
        if (!"COP|USD|EUR".contains(builder.currency)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }
        
        if (!"WEB|MOBILE|API".contains(builder.channel)) {
            throw new IllegalArgumentException("Canal no soportado");
        }
        
        this.creditBureauResponse = builder.creditBureauResponse;
        this.bankCoreResponse = builder.bankCoreResponse;
    }

    public UUID getId() {
        return id;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public String getChannel() {
        return channel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public String getCreditBureauResponse() {
        return creditBureauResponse;
    }

    public String getBankCoreResponse() {
        return bankCoreResponse;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return operationNumber.equals(payment.operationNumber) && channel.equals(payment.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationNumber, channel);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", operationNumber='" + operationNumber + '\'' +
                ", channel='" + channel + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static final class Builder {
        private UUID id;
        private String operationNumber;
        private String channel;
        private BigDecimal amount;
        private String currency;
        private String accountNumber;
        private String beneficiaryAccount;
        private LocalDateTime createdAt;
        private String status;
        private String creditBureauResponse;
        private String bankCoreResponse;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder operationNumber(String operationNumber) {
            this.operationNumber = operationNumber;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder beneficiaryAccount(String beneficiaryAccount) {
            this.beneficiaryAccount = beneficiaryAccount;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder creditBureauResponse(String creditBureauResponse) {
            this.creditBureauResponse = creditBureauResponse;
            return this;
        }

        public Builder bankCoreResponse(String bankCoreResponse) {
            this.bankCoreResponse = bankCoreResponse;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/domain/ports/PaymentRepository.java ===
package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;
import java.util.UUID;

/**
 * Puerto definido por el dominio para persistencia de pagos.
 * La implementación debe garantizar unicidad por operationNumber y channel.
 */
public interface PaymentRepository {
    Mono<Payment> save(Payment payment);
    
    Mono<Payment> findById(UUID id);
    
    Mono<Boolean> existsByOperationNumberAndChannel(String operationNumber, String channel);
    
    Mono<Payment> findByOperationNumberAndChannel(String operationNumber, String channel);
}

// === ARCHIVO: src/main/java/com/bank/payment/domain/ports/CreditBureauClient.java ===
package com.bank.payment.domain.ports;

import reactor.core.publisher.Mono;

/**
 * Puerto definido por el dominio para comunicación con el buró de crédito.
 * La implementación debe manejar timeouts y fallos del servicio.
 */
public interface CreditBureauClient {
    Mono<String> verifyCreditScore(String accountNumber, String beneficiaryAccount, String currency);
}

// === ARCHIVO: src/main/java/com/bank/payment/domain/ports/BankCoreClient.java ===
package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public interface BankCoreClient {
    Mono<String> processPayment(Payment payment);
}

// === ARCHIVO: src/main/java/com/bank/payment/domain/ports/AuditEventPublisher.java ===
package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public interface AuditEventPublisher {
    Mono<Void> publishEvent(Payment payment);
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/adapters/PaymentJpaRepository.java ===
package com.bank.payment.infrastructure.adapters;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, UUID>, PaymentRepository {
    @Override
    default Mono<Payment> save(Payment payment) {
        return Mono.fromCallable(() -> saveAndFlush(payment));
    }

    @Override
    default Mono<Payment> findById(UUID id) {
        return Mono.fromCallable(() -> findById(id).orElse(null));
    }

    @Override
    default Mono<Boolean> existsByOperationNumberAndChannel(String operationNumber, String channel) {
        return Mono.fromCallable(() -> existsByOperationNumberAndChannel(operationNumber, channel));
    }

    @Override
    default Mono<Payment> findByOperationNumberAndChannel(String operationNumber, String channel) {
        return Mono.fromCallable(() -> findByOperationNumberAndChannel(operationNumber, channel).orElse(null));
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import com.bank.payment.domain.ports.CreditBureauClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RegisterPaymentUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CreditBureauClient creditBureauClient;

    @CircuitBreaker(name = "registerPayment", fallbackMethod = "fallbackRegisterPayment")
    @Retry(name = "registerPayment")
    public Mono<Payment> registerPayment(Payment payment) {
        return paymentRepository.existsByOperationNumberAndChannel(payment.getOperationNumber(), payment.getChannel())
               .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("Payment already exists"));
                    }
                    return creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())
                           .flatMap(creditScore -> {
                                payment.setCreditBureauResponse(creditScore);
                                return paymentRepository.save(payment);
                            });
                });
    }

    public Mono<Payment> fallbackRegisterPayment(Payment payment, Throwable throwable) {
        return Mono.error(throwable);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCase.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ConsolidatePaymentsUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @CircuitBreaker(name = "consolidatePayments", fallbackMethod = "fallbackConsolidatePayments")
    @Retry(name = "consolidatePayments")
    public Flux<Payment> consolidatePayments(Flux<Payment> payments) {
        return payments.concatMap(payment -> paymentRepository.save(payment));
    }

    public Flux<Payment> fallbackConsolidatePayments(Flux<Payment> payments, Throwable throwable) {
        return Flux.error(throwable);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/application/usecases/RecoverPaymentsUseCase.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RecoverPaymentsUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @CircuitBreaker(name = "recoverPayments", fallbackMethod = "fallbackRecoverPayments")
    @Retry(name = "recoverPayments")
    public Flux<Payment> recoverPayments(Flux<Payment> payments) {
        return payments.concatMap(payment -> paymentRepository.findById(payment.getId())
               .flatMap(existingPayment -> {
                    if (existingPayment!= null &&!existingPayment.getStatus().equals("SUCCESS")) {
                        return paymentRepository.save(payment);
                    }
                    return Mono.just(existingPayment);
                }).defaultIfEmpty(payment));
    }

    public Flux<Payment> fallbackRecoverPayments(Flux<Payment> payments, Throwable throwable) {
        return Flux.error(throwable);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/application/events/PaymentRegisteredEvent.java ===
package com.bank.payment.application.events;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public class PaymentRegisteredEvent {
    private final Payment payment;

    public PaymentRegisteredEvent(Payment payment) {
        this.payment = payment;
    }

    public Mono<Payment> getPayment() {
        return Mono.just(payment);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java ===
package com.bank.payment.infrastructure.adapters;


import com.bank.payment.domain.model.Builder;
import com.bank.payment.domain.ports.CreditBureauClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CreditBureauWebClient implements CreditBureauClient {
    private final WebClient webClient;

    public CreditBureauWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://credit-bureau.com").build();
    }

    @Override
    public Mono<String> verifyCreditScore(String accountNumber, String beneficiaryAccount, String currency) {
        return webClient.get()
               .uri(uriBuilder -> uriBuilder
                       .path("/verify")
                       .queryParam("accountNumber", accountNumber)
                       .queryParam("beneficiaryAccount", beneficiaryAccount)
                       .queryParam("currency", currency)
                       .build())
               .retrieve()
               .bodyToMono(String.class);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java ===
package com.bank.payment.infrastructure.adapters;


import com.bank.payment.domain.model.Builder;
import com.bank.payment.domain.ports.BankCoreClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BankCoreWebClient implements BankCoreClient {
    private final WebClient webClient;

    public BankCoreWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://bank-core.com").build();
    }

    @Override
    public Mono<String> processPayment(String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount) {
        return webClient.post()
               .uri("/process")
               .bodyValue(new PaymentRequest(operationNumber, channel, amount, currency, accountNumber, beneficiaryAccount))
               .retrieve()
               .bodyToMono(String.class);
    }

    private static class PaymentRequest {
        private final String operationNumber;
        private final String channel;
        private final BigDecimal amount;
        private final String currency;
        private final String accountNumber;
        private final String beneficiaryAccount;

        public PaymentRequest(String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount) {
            this.operationNumber = operationNumber;
            this.channel = channel;
            this.amount = amount;
            this.currency = currency;
            this.accountNumber = accountNumber;
            this.beneficiaryAccount = beneficiaryAccount;
        }

        public String getOperationNumber() {
            return operationNumber;
        }

        public String getChannel() {
            return channel;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getBeneficiaryAccount() {
            return beneficiaryAccount;
        }
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/adapters/AuditEventKafkaPublisher.java ===
package com.bank.payment.infrastructure.adapters;

import com.bank.payment.domain.ports.AuditEventPublisher;
import com.bank.payment.domain.model.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuditEventKafkaPublisher implements AuditEventPublisher {

    private final KafkaProducer<String, String> kafkaProducer;

    @Value("${kafka.topic.audit}")
    private String auditTopic;

    public AuditEventKafkaPublisher(KafkaProducer<String, String> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void publish(Payment payment) {
        String key = payment.getOperationNumber();
        String value = payment.toString();
        ProducerRecord<String, String> record = new ProducerRecord<>(auditTopic, key, value);
        kafkaProducer.send(record);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/config/Resilience4jConfig.java ===
package com.bank.payment.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.reactor.retry.operator.RetryOperator;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.reactor.bulkhead.operator.BulkheadOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(10000)
               .build();
    }

    @Bean
    public CircuitBreakerOperator circuitBreakerOperator(CircuitBreakerConfig config) {
        return CircuitBreakerOperator.of(config);
    }

    @Bean
    public RetryConfig retryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public RetryOperator retryOperator(RetryConfig config) {
        return RetryOperator.of(config);
    }

    @Bean
    public BulkheadConfig bulkheadConfig() {
        return BulkheadConfig.custom()
               .maxConcurrentCalls(10)
               .maxWaitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public BulkheadOperator bulkheadOperator(BulkheadConfig config) {
        return BulkheadOperator.of(config);
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java ===
package com.bank.payment.infrastructure.controllers;

import com.bank.payment.application.usecases.RegisterPaymentUseCase;
import com.bank.payment.domain.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private RegisterPaymentUseCase registerPaymentUseCase;

    @PostMapping
    public Mono<ResponseEntity<Payment>> registerPayment(@Valid @RequestBody Payment payment) {
        return registerPaymentUseCase.execute(payment)
               .map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
               .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}

// === ARCHIVO: src/main/java/com/bank/payment/infrastructure/repositories/PaymentEntity.java ===
package com.bank.payment.infrastructure.repositories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments", uniqueConstraints = @UniqueConstraint(columnNames = {"operation_number", "channel"})
)
public class PaymentEntity {

    @Id
    private UUID id;

    @Column(name = "operation_number", nullable = false)
    private String operationNumber;

    @Column(name = "channel", nullable = false)
    private String channel;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "beneficiary_account", nullable = false)
    private String beneficiaryAccount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "credit_bureau_response")
    private String creditBureauResponse;

    @Column(name = "bank_core_response")
    private String bankCoreResponse;

    public PaymentEntity() {
    }

    public PaymentEntity(UUID id, String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount, LocalDateTime createdAt, String status, String creditBureauResponse, String bankCoreResponse) {
        this.id = id;
        this.operationNumber = operationNumber;
        this.channel = channel;
        this.amount = amount;
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.beneficiaryAccount = beneficiaryAccount;
        this.createdAt = createdAt;
        this.status = status;
        this.creditBureauResponse = creditBureauResponse;
        this.bankCoreResponse = bankCoreResponse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreditBureauResponse() {
        return creditBureauResponse;
    }

    public void setCreditBureauResponse(String creditBureauResponse) {
        this.creditBureauResponse = creditBureauResponse;
    }

    public String getBankCoreResponse() {
        return bankCoreResponse;
    }

    public void setBankCoreResponse(String bankCoreResponse) {
        this.bankCoreResponse = bankCoreResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentEntity)) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", operationNumber='" + operationNumber + '\'' +
                ", channel='" + channel + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", beneficiaryAccount='" + beneficiaryAccount + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", creditBureauResponse='" + creditBureauResponse + '\'' +
                ", bankCoreResponse='" + bankCoreResponse + '\'' +
                '}';
    }
}

// === ARCHIVO: src/test/java/com/bank/payment/bdd/PaymentRegistrationSteps.java ===
package com.bank.payment.bdd;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentRegistrationSteps {

    @Autowired
    private PaymentRepository paymentRepository;

    private Payment payment;
    private Mono<Payment> savedPayment;

    @Given("a payment with operation number {string}, channel {string}, amount {double}, currency {string}, account number {string}, beneficiary account {string}")
    public void a_payment_with_operation_number_channel_amount_currency_account_number_beneficiary_account(String operationNumber, String channel, double amount, String currency, String accountNumber, String beneficiaryAccount) {
        payment = Payment.builder()
               .operationNumber(operationNumber)
               .channel(channel)
               .amount(BigDecimal.valueOf(amount))
               .currency(currency)
               .accountNumber(accountNumber)
               .beneficiaryAccount(beneficiaryAccount)
               .build();
    }

    @When("the payment is registered")
    public void the_payment_is_registered() {
        savedPayment = paymentRepository.save(payment);
    }

    @Then("the payment should be saved with status {string}")
    public void the_payment_should_be_saved_with_status(String status) {
        savedPayment.subscribe(p -> {
            assertEquals(status, p.getStatus());
        });
    }
}

// === ARCHIVO: src/test/resources/features/payment_registration.feature ===
Feature: Payment Registration
  As a user, I want to register a payment so that it can be processed by the system.

  Scenario: Register a unique payment
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "registered"

  Scenario: Register a duplicate payment
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "duplicate"

  Scenario: Register a payment with invalid amount
    Given a payment with operation number "OP456", channel "mobile", amount -100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "invalid"

  Scenario: Register a payment with invalid currency
    Given a payment with operation number "OP789", channel "api", amount 100.0, currency "INVALID", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "invalid"

// === ARCHIVO: src/test/resources/features/payment_consolidation.feature ===
Feature: Payment Consolidation
  As a user, I want to consolidate payments from different channels so that they can be processed together.

  Scenario: Consolidate payments from web and mobile channels
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP456", channel "mobile", amount 200.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payments are consolidated
    Then the total amount should be 300.0

  Scenario: Consolidate payments with backpressure from one channel
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP456", channel "mobile", amount 200.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP789", channel "api", amount 300.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payments are consolidated with backpressure from the api channel
    Then the total amount should be 300.0

// === ARCHIVO: src/test/resources/features/payment_recovery.feature ===
Feature: Recuperación Automática de Pagos

  Scenario: Pago no procesado debido a caída del consumidor downstream
    Given el sistema está recibiendo pagos de los canales web, móvil y API externa
    And el consumidor downstream ha caído
    When un pago es intentado y falla
    Then el sistema debe encolar el pago para reintento automático
    And el pago no debe ser reprocesado si ya ha sido emitido

  Scenario: Pago procesado exitosamente después de reintento
    Given el sistema ha encolado un pago para reintento automático
    And el consumidor downstream ha sido restaurado
    When el sistema reintenta el pago
    Then el pago debe ser procesado exitosamente
    And un evento de pago exitoso debe ser emitido al sistema de auditoría

  Scenario: Pago no procesado después de múltiples reintentos
    Given el sistema ha encolado un pago para reintento automático
    And el consumidor downstream sigue caído
    When el sistema ha intentado el pago múltiples veces
    Then el pago no debe ser procesado
    And el sistema debe notificar al usuario sobre el fallo

// === ARCHIVO: src/test/java/com/bank/payment/application/usecases/RegisterPaymentUseCaseTest.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import com.bank.payment.domain.ports.CreditBureauClient;
import com.bank.payment.domain.ports.BankCoreClient;
import com.bank.payment.domain.ports.AuditEventPublisher;
import com.bank.payment.application.events.PaymentRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegisterPaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CreditBureauClient creditBureauClient;

    @Mock
    private BankCoreClient bankCoreClient;

    @Mock
    private AuditEventPublisher auditEventPublisher;

    @InjectMocks
    private RegisterPaymentUseCase registerPaymentUseCase;

    @Test
    void registerPayment_success() {
        // Arrange
        Payment payment = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(paymentRepository.save(payment)).thenReturn(Mono.just(payment));
        when(creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())).thenReturn(Mono.just("approved"));
        when(bankCoreClient.processPayment(payment)).thenReturn(Mono.just(payment));

        // Act
        Mono<Payment> result = registerPaymentUseCase.registerPayment(payment);

        // Assert
        result.subscribe(registeredPayment -> {
            assertEquals(payment, registeredPayment);
            verify(paymentRepository).save(payment);
            verify(creditBureauClient).verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency());
            verify(bankCoreClient).processPayment(payment);
            verify(auditEventPublisher).publishEvent(any(PaymentRegisteredEvent.class));
        });
    }

    @Test
    void registerPayment_creditBureauFailure() {
        // Arrange
        Payment payment = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())).thenReturn(Mono.error(new RuntimeException("Credit bureau timeout")));

        // Act
        Mono<Payment> result = registerPaymentUseCase.registerPayment(payment);

        // Assert
        result.subscribe(registeredPayment -> fail("Expected exception"),
                error -> {
                    assertTrue(error instanceof RuntimeException);
                    assertEquals("Credit bureau timeout", error.getMessage());
                    verify(paymentRepository, never()).save(payment);
                    verify(creditBureauClient).verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency());
                    verify(bankCoreClient, never()).processPayment(payment);
                    verify(auditEventPublisher, never()).publishEvent(any(PaymentRegisteredEvent.class));
                });
    }
}

// === ARCHIVO: src/test/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCaseTest.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import com.bank.payment.domain.ports.CreditBureauClient;
import com.bank.payment.domain.ports.BankCoreClient;
import com.bank.payment.domain.ports.AuditEventPublisher;
import com.bank.payment.application.events.PaymentRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConsolidatePaymentsUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CreditBureauClient creditBureauClient;

    @Mock
    private BankCoreClient bankCoreClient;

    @Mock
    private AuditEventPublisher auditEventPublisher;

    @InjectMocks
    private ConsolidatePaymentsUseCase consolidatePaymentsUseCase;

    @Test
    void consolidatePayments_success() {
        // Arrange
        Payment payment1 = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        Payment payment2 = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("654321")
               .channel("mobile")
               .amount(new BigDecimal("200.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(paymentRepository.save(payment1)).thenReturn(Mono.just(payment1));
        when(paymentRepository.save(payment2)).thenReturn(Mono.just(payment2));
        when(creditBureauClient.verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency())).thenReturn(Mono.just("approved"));
        when(creditBureauClient.verifyCreditScore(payment2.getAccountNumber(), payment2.getBeneficiaryAccount(), payment2.getCurrency())).thenReturn(Mono.just("approved"));
        when(bankCoreClient.processPayment(payment1)).thenReturn(Mono.just(payment1));
        when(bankCoreClient.processPayment(payment2)).thenReturn(Mono.just(payment2));

        // Act
        Mono<Void> result = consolidatePaymentsUseCase.consolidatePayments(Mono.just(payment1).concatWith(Mono.just(payment2)));

        // Assert
        result.subscribe();
        verify(paymentRepository).save(payment1);
        verify(paymentRepository).save(payment2);
        verify(creditBureauClient).verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency());
        verify(creditBureauClient).verifyCreditScore(payment2.getAccountNumber(), payment2.getBeneficiaryAccount(), payment2.getCurrency());
        verify(bankCoreClient).processPayment(payment1);
        verify(bankCoreClient).processPayment(payment2);
        verify(auditEventPublisher, times(2)).publishEvent(any(PaymentRegisteredEvent.class));
    }

    @Test
    void consolidatePayments_creditBureauFailure() {
        // Arrange
        Payment payment1 = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(creditBureauClient.verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency())).thenReturn(Mono.error(new RuntimeException("Credit bureau timeout")));

        // Act
        Mono<Void> result = consolidatePaymentsUseCase.consolidatePayments(Mono.just(payment1));

        // Assert
        result.subscribe(success -> fail("Expected exception"),
                error -> {
                    assertTrue(error instanceof RuntimeException);
                    assertEquals("Credit bureau timeout", error.getMessage());
                    verify(paymentRepository, never()).save(payment1);
                    verify(creditBureauClient).verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency());
                    verify(bankCoreClient, never()).processPayment(payment1);
                    verify(auditEventPublisher, never()).publishEvent(any(PaymentRegisteredEvent.class));
                });
    }
}

// === ARCHIVO: src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java ===
package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class RecoverPaymentsUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private RecoverPaymentsUseCase recoverPaymentsUseCase;

    @Test
    void shouldRecoverPaymentSuccessfully() {
        UUID paymentId = UUID.randomUUID();
        Payment payment = Payment.builder()
               .id(paymentId)
               .operationNumber("OP-123")
               .channel("WEB")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("123456789")
               .beneficiaryAccount("987654321")
               .createdAt(LocalDateTime.now())
               .status("PENDING")
               .creditBureauResponse("APPROVED")
               .bankCoreResponse("PROCESSING")
               .build();

        Mono<Payment> expectedPaymentMono = Mono.just(payment);

        when(paymentRepository.findById(paymentId)).thenReturn(expectedPaymentMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectNext(payment)
               .verifyComplete();
    }

    @Test
    void shouldHandlePaymentNotFound() {
        UUID paymentId = UUID.randomUUID();
        Mono<Payment> emptyMono = Mono.empty();

        when(paymentRepository.findById(paymentId)).thenReturn(emptyMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectError(NoSuchElementException.class)
               .verify();
    }

    @Test
    void shouldHandleRepositoryError() {
        UUID paymentId = UUID.randomUUID();
        Mono<Payment> errorMono = Mono.error(new RuntimeException("Database error"));

        when(paymentRepository.findById(paymentId)).thenReturn(errorMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectError(RuntimeException.class)
               .verify();
    }
}
```
