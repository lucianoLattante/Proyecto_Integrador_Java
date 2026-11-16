# Proyecto Integrador Java — Egg Education

Proyecto educativo de Java 8 desarrollado durante el curso de Egg Education. Incluye tres ejercicios: capicúas, distribución circular de caramelos y selección de elementos repetidos.

Se conserva como antecedente de aprendizaje. No es una API backend ni un sistema productivo.

El [README principal](README.md) incluye ejecución con JDK, configuración de JUnit, limitaciones y próximos pasos. El [registro de verificación](docs/VERIFICATION.md) explica el alcance de las pruebas.

**Resultado real del 16 de noviembre de 2026:** pasaron los tres tests existentes con JDK 1.8.0_202, JUnit 4.13.2 y Hamcrest 1.3. Una comprobación independiente reprodujo un defecto: `prisioneroDulce(0,4,3)` devuelve 3 cuando el destinatario esperado es 0. No se corrigió ni se ocultó ese resultado.

Se mantiene la atribución original al curso. No se presenta el trabajo del repositorio completo como una contribución individual sin comprobar los commits.
