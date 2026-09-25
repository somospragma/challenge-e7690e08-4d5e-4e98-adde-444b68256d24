# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un Flujo de Pagos con BDD**.

| | |
|---|---|
| Tema | Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con patrón CQRS y manejo reactivo de eventos |
| Tiempo estimado | 1 semana |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-webflux 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- io.projectreactor:reactor-core 3.6.8
- io.github.resilience4j:resilience4j-spring-boot3 2.2.0
- org.apache.kafka:kafka-clients 3.8.0
- org.springframework.kafka:spring-kafka n/a
- io.cucumber:cucumber-java 7.18.0
- io.cucumber:cucumber-spring 7.18.0
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api n/a
- org.mockito:mockito-core 5.12.0
- org.springdoc:springdoc-openapi-starter-webflux-ui 2.9.1

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Registro de Pagos**: Sistema que registra pagos únicos por canal y número de operación, manejando errores específicos.
- **Fase 2 — Consolidación de Canales**: Sistema que consolida pagos de los tres canales sin pérdida de datos ante backpressure.
- **Fase 3 — Recuperación Automática**: Sistema que recupera automáticamente los pagos ante caída del consumidor downstream sin reprocesar los ya emitidos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/bank/payment/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (23)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/bank/payment/Application.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Hooks pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/Application.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/domain/ports/PaymentRepository.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/domain/ports/CreditBureauClient.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/domain/ports/BankCoreClient.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/domain/ports/AuditEventPublisher.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/infrastructure/adapters/PaymentJpaRepository.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCase.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/application/usecases/RecoverPaymentsUseCase.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/application/events/PaymentRegisteredEvent.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/bank/payment/bdd/PaymentRegistrationSteps.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/bank/payment/application/usecases/RegisterPaymentUseCaseTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCaseTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java` — `Payment.setCreditBureauResponse`
      Se invoca `setCreditBureauResponse` sobre `Payment`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java` — `Builder.baseUrl`
      Se invoca `baseUrl` sobre `Builder`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java` — `Builder.baseUrl`
      Se invoca `baseUrl` sobre `Builder`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java` — `RegisterPaymentUseCase.execute`
      Se invoca `execute` sobre `RegisterPaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java` — `RecoverPaymentsUseCase.recoverPayment`
      Se invoca `recoverPayment` sobre `RecoverPaymentsUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (26)

- `pom.xml`
- `src/main/java/com/bank/payment/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/bank/payment/domain/model/Payment.java`
- `src/main/java/com/bank/payment/domain/ports/PaymentRepository.java`
- `src/main/java/com/bank/payment/domain/ports/CreditBureauClient.java`
- `src/main/java/com/bank/payment/domain/ports/BankCoreClient.java`
- `src/main/java/com/bank/payment/domain/ports/AuditEventPublisher.java`
- `src/main/java/com/bank/payment/infrastructure/adapters/PaymentJpaRepository.java`
- `src/main/java/com/bank/payment/application/usecases/RegisterPaymentUseCase.java`
- `src/main/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCase.java`
- `src/main/java/com/bank/payment/application/usecases/RecoverPaymentsUseCase.java`
- `src/main/java/com/bank/payment/application/events/PaymentRegisteredEvent.java`
- `src/main/java/com/bank/payment/infrastructure/adapters/CreditBureauWebClient.java`
- `src/main/java/com/bank/payment/infrastructure/adapters/BankCoreWebClient.java`
- `src/main/java/com/bank/payment/infrastructure/adapters/AuditEventKafkaPublisher.java`
- `src/main/java/com/bank/payment/infrastructure/config/Resilience4jConfig.java`
- `src/main/java/com/bank/payment/infrastructure/controllers/PaymentController.java`
- `src/main/java/com/bank/payment/infrastructure/repositories/PaymentEntity.java`
- `src/test/java/com/bank/payment/bdd/PaymentRegistrationSteps.java`
- `src/test/resources/features/payment_registration.feature`
- `src/test/resources/features/payment_consolidation.feature`
- `src/test/resources/features/payment_recovery.feature`
- `src/test/java/com/bank/payment/application/usecases/RegisterPaymentUseCaseTest.java`
- `src/test/java/com/bank/payment/application/usecases/ConsolidatePaymentsUseCaseTest.java`
- `src/test/java/com/bank/payment/application/usecases/RecoverPaymentsUseCaseTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/bank/payment`
- `src/main/java/com/bank/payment/domain`
- `src/main/java/com/bank/payment/domain/model`
- `src/main/java/com/bank/payment/domain/ports`
- `src/main/java/com/bank/payment/application`
- `src/main/java/com/bank/payment/application/usecases`
- `src/main/java/com/bank/payment/application/events`
- `src/main/java/com/bank/payment/infrastructure`
- `src/main/java/com/bank/payment/infrastructure/adapters`
- `src/main/java/com/bank/payment/infrastructure/config`
- `src/main/java/com/bank/payment/infrastructure/controllers`
- `src/main/java/com/bank/payment/infrastructure/repositories`
- `src/test/java/com/bank/payment`
- `src/test/java/com/bank/payment/bdd`
- `src/test/resources`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con patrón CQRS y manejo reactivo de eventos**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnologia Java, Advanced
- Brecha que el reto ataca: Aplica metodologias de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatizacion como Cucumber, el framework Karate, etc.
- Mision: Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con solida base en arquitectura y testing.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
