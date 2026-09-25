# Implementación de un Flujo de Pagos con BDD

En un entorno de banca digital, el sistema debe registrar y procesar pagos de clientes. Los pagos provienen de tres canales: web, móvil y API externa. Cada pago debe ser único, identificado por un número de operación y un canal. El sistema debe manejar errores como timeouts del buró de crédito y respuestas 5xx del core bancario. Los pagos exitosos deben emitir un evento al sistema de auditoría.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 1 semana |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Registro de Pagos

**Objetivo:** Implementar la funcionalidad para registrar pagos únicos por canal y número de operación.

**Tiempo estimado:** 3 días

**Instrucciones:**

- El sistema debe aceptar pagos de los tres canales y registrarlos de manera idempotente.
- Prohibir pagos duplicados por número de operación y canal.
- Manejar timeouts del buró de crédito y respuestas 5xx del core bancario.

**Entregable:** Sistema que registra pagos únicos por canal y número de operación, manejando errores específicos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo garantizar la unicidad del registro de pagos.
- Piensa en cómo manejar diferentes tipos de errores del sistema externo.

</details>

### Fase 2: Consolidación de Canales

**Objetivo:** Consolidar los pagos de los tres canales en un único flujo sin pérdida de datos ante backpressure de uno de ellos.

**Tiempo estimado:** 2 días

**Instrucciones:**

- Asegura que los pagos de los tres canales se consoliden sin pérdida de datos.
- Maneja la backpressure de uno de los canales sin afectar los otros.

**Entregable:** Sistema que consolida pagos de los tres canales sin pérdida de datos ante backpressure.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar la backpressure en tiempo real.
- Piensa en cómo garantizar la consistencia de los datos durante la consolidación.

</details>

### Fase 3: Recuperación Automática

**Objetivo:** Implementar la recuperación automática de pagos ante caída del consumidor downstream sin reprocesar los ya emitidos.

**Tiempo estimado:** 2 días

**Instrucciones:**

- Implementa la recuperación automática de pagos ante caída del consumidor downstream.
- Asegura que los pagos ya emitidos no se reprocesen.

**Entregable:** Sistema que recupera automáticamente los pagos ante caída del consumidor downstream sin reprocesar los ya emitidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo identificar y manejar los pagos ya emitidos.
- Piensa en cómo implementar la recuperación automática de manera eficiente.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es la idempotencia en el contexto de registrar pagos?
- **paraQueSirve**: ¿Para qué sirve consolidar los pagos de los tres canales?
- **comoSeUsa**: ¿Cómo se usa la recuperación automática en este escenario?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir durante el registro y procesamiento de pagos?
- **queDecisionesImplica**: ¿Qué decisiones implica la recuperación automática de pagos ante caída del consumidor downstream?

## Criterios de Evaluacion

- Implementación de la funcionalidad para registrar pagos únicos por canal y número de operación.
- Consolidación de los pagos de los tres canales sin pérdida de datos ante backpressure.
- Recuperación automática de pagos ante caída del consumidor downstream sin reprocesar los ya emitidos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
