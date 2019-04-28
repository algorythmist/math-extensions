# math-extensions
Koltin extensions for matrix and vector algebra

###Examples:

####Vector Arithmetic:

```kotlin
    val v1 = doubleArrayOf(-1.0, 2.0, 3.0)
    val v2 = doubleArrayOf(1.0, -1.0, 2.5)
    val v3 = doubleArrayOf(2.0, -2.0, -2.0)

    val y = 3.5*v1 - v2*5 - v3/2
    println(Arrays.toString(y))
    assertArrayEquals(doubleArrayOf(-9.5, 13.0, -1.0), y)
```

####Inner Product and norm
```kotlin
    val v = doubleArrayOf(1.0, -1.0, 1.0)
    val w = doubleArrayOf(1.0, 2.0, 2.0)
    assertEquals(1.0, v*w, 0.001)
    
    assertEquals(sqrt(3.0), v.norm(),0.001)
    assertEquals(3.0, v.normSquared(),0.001)
```

####Matrix Arithmetic
```kotlin
    val m1 = arrayOf(doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, 1.0),
            doubleArrayOf(-1.0, -2.0))
    val m2 = arrayOf(doubleArrayOf(2.0, 1.0),
            doubleArrayOf(2.0, -1.0),
            doubleArrayOf(0.0, 1.0))

     val m = 2*m1/5.0 - 5.0*m2/2
        assertEquals(
                "[-4.6, -1.7]\n" +
                "[-5.8, 2.9]\n" +
                "[-0.4, -3.3]", toString(m))
```

####Matrix Multiplication

```kotlin
    var w = zeros(3)
    val g = arrayOf(doubleArrayOf(1.0, 2.0, 1.0),
            doubleArrayOf(-2.0, 1.0, 2.0),
            doubleArrayOf(0.0, -1.0, -1.0)
        )
     val h = ones(3)

     w -= g*h
     assertArrayEquals(doubleArrayOf(-4.0, -1.0, 2.0), w)

     val v = h*g
     assertArrayEquals(doubleArrayOf(-1.0, 2.0, 2.0), v)
     
     val m = arrayOf(doubleArrayOf(1.0, 2.0),
                 doubleArrayOf(-2.0, 1.0),
                 doubleArrayOf(-1.0, -2.0))
     assertEquals(
                 "[5.0, 0.0, -5.0]\n" +
                     "[0.0, 5.0, 0.0]\n" +
                     "[-5.0, 0.0, 5.0]",
                 toString(m*m.transpose()))
     assertEquals(
                 "[6.0, 2.0]\n" +
                         "[2.0, 9.0]",
                 toString(m.transpose()*m))
```
