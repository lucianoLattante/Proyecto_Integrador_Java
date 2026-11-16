# Verification and interview notes

Reviewed source baseline: `018fcda400a168b6d8e38cfb297b76d60b872af8`.

## Executed verification — 2026-11-16

The three source/test files were retrieved from the fixed commit and compiled into a separate temporary working directory. No tracked generated classes were used as evidence.

Runtime and dependencies:

- Oracle JDK `1.8.0_202`, JVM `25.202-b08`.
- JUnit `4.13.2` and Hamcrest Core `1.3`, from an existing local Maven cache.
- Windows PowerShell.

Command shape, with dependency paths supplied via `JUNIT4_JAR` and `HAMCREST_JAR`:

```powershell
$testDeps = "$env:JUNIT4_JAR;$env:HAMCREST_JAR"
javac -encoding UTF-8 -d out -cp $testDeps src/integrador/Practica.java src/integrador/Integrador.java test/tests/EggTest.java
java -cp "out;$testDeps" org.junit.runner.JUnitCore tests.EggTest
```

Result: `OK (3 tests)`, exit code 0. The compiler reported unchecked/unsafe operations. The original NetBeans/Ant targets, historical XML reports and any packaged output were not used to claim a passing build.

## Reproduced limitation

The candy exercise's comments define a zero-based circular recipient. Starting at 0 with 4 candies and 3 recipients should visit 0, 1, 2, 0. The current method returns 3, an invalid index for that circle.

A separate compiled probe invoked the unchanged method and printed `actual=3, expected=0`. It confirmed the defect. This probe is not a replacement for a committed regression test; no correctness fix is included here.

Before a follow-up fix, define behavior for zero candies, zero/negative recipient counts, out-of-range starts and arithmetic overflow. For valid positive counts, consider modular arithmetic using a sufficiently wide intermediate value. That is a design proposal, not implemented behavior.

## Interview discussion

Use the project to discuss how testing evolved:

1. How can all three existing tests pass while the wraparound defect remains?
2. Which boundary cases distinguish an example-based test from an invariant?
3. What input contract should the candy exercise expose?
4. How would a frequency map change time and space complexity for repeated elements?
5. Why can reversing an integer overflow, and how should a contract handle it?

No production performance, professional distributed-system experience or coverage percentage is inferred from these exercises.
