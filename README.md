# Java Integrator — Egg Education exercises

A small Java 8 console project created during the Egg Education course. It contains three algorithm exercises and JUnit 4 tests. It is preserved as learning history, with the original course attribution.

**Status:** historical educational exercise. No backend API, database, authentication, distributed system or deployment is implemented.

[Resumen en español](README.es.md) · [Verification and interview notes](docs/VERIFICATION.md)

## Exercises and contracts

Implementation: [Practica.java](src/integrador/Practica.java).

| Method | Intended behavior from source comments | Current limitations |
| --- | --- | --- |
| `numeroCapicua(Integer)` | Check a decimal palindrome; null returns false and negative inputs are considered | Reversal uses an int; overflow behavior needs explicit tests |
| `prisioneroDulce(int,int,int)` | Find the zero-based recipient of the last candy in a circular distribution | Wraparound defect reproduced; invalid ranges are not validated |
| `mediasAmigas(List<String>)` | Return sorted, distinct values appearing at least twice; null list returns empty | Quadratic scan; null elements are not handled |

[Integrador.java](src/integrador/Integrador.java) is a small main program that prints the result of one palindrome example. It is not a complete interactive interface.

## Run with a JDK

The NetBeans properties target Java 8. The source can also be compiled directly without NetBeans or a database. From the repository root, in PowerShell:

```powershell
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -encoding UTF-8 -d out src/integrador/Practica.java src/integrador/Integrador.java
java -cp out integrador.Integrador
```

Use `out` only for local output; do not commit generated classes.

## Existing tests

[test/tests/EggTest.java](test/tests/EggTest.java) contains three JUnit 4 test methods. To run them in PowerShell, set `JUNIT4_JAR` and `HAMCREST_JAR` to trusted local JAR paths, then:

```powershell
$testDeps = "$env:JUNIT4_JAR;$env:HAMCREST_JAR"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -encoding UTF-8 -d out -cp $testDeps src/integrador/Practica.java src/integrador/Integrador.java test/tests/EggTest.java
java -cp "out;$testDeps" org.junit.runner.JUnitCore tests.EggTest
```

**Executed on 2026-11-16:** Oracle JDK 1.8.0_202, JUnit 4.13.2 and Hamcrest Core 1.3; all three existing tests passed. Compilation emitted unchecked-operation warnings. Dependencies were available locally; no external services were called.

Passing the existing suite does not establish correctness for all inputs. A separate isolated probe reproduced this defect:

```text
prisioneroDulce(0, 4, 3)
Expected zero-based recipient: 0
Actual result: 3
```

That probe demonstrates a known failure; it is not an additional passing correctness test. The implementation is unchanged by this documentation PR.

## NetBeans / Ant

[build.xml](build.xml) imports the generated NetBeans build. [Project properties](nbproject/project.properties) reference local JUnit/Hamcrest and MySQLDriver libraries. The shown algorithm sources do not use a database. Library resolution and IDE-local paths make the original Ant build environment-dependent; that path was not executed in this verification.

The repository also tracks generated build outputs and IDE-private metadata. They are retained here to avoid deleting historical material. A future cleanup should review sensitive local metadata before removing generated artifacts in a separate PR.

## Proposed next improvements

1. Add a regression test for wraparound and define valid ranges before correcting `prisioneroDulce`.
2. Specify overflow and null-element contracts.
3. Replace the nested counting loop with a frequency map if revisiting the exercise.
4. Make the build portable and exclude regenerated outputs.

These are proposed changes. No CI, Docker, OpenAPI, integration tests or production deployment is claimed. Those facilities would not by themselves turn a console exercise into evidence of backend architecture.

## Portfolio context

Present this repository as an early course exercise. Prefer recent backend work and verified maintenance case studies when demonstrating current engineering skills. Individual contributions should be established from commits; the README does not infer sole ownership from the repository name.
