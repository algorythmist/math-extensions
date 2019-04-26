# math-extensions
Koltin extensions for matrix and vector algebra

###Examples:

####Vector Arithmetic:

```kotlin
        val v1 = doubleArrayOf(-1.0, 2.0, 1.5)
        val v2 = doubleArrayOf(1.0, -1.0, 0.5)
        val v3 = doubleArrayOf(2.0, -2.0, -0.5)

        val y = 3.5*v1 - v2*5 - v3
        assertArrayEquals(doubleArrayOf(-10.5, 14.0, 3.25), y)
```

