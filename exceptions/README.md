# Las Excepciones

## (5.1) Definicion de excepciones

Cuando ocurre algo que interrumpe el flujo del programa--un *error*--, Java detendrá el programa, y arrojará una ***excepción***.

Sin embargo, podemos usar el *manejo de excepciones*; podemos capturar--hacer `catch` a la excepción-- y realizar una solución alternativa continuando con el flujo; sin que el programa se detenga.

## (5.2) Tipos de Excepciones

Conceptualmente, hay dos tipos de excepciones:

### Excepciones que *no* requieren de una comprobación - _unchecked exceptions_:
  No están obligadas a ser manejadas explícitamente.
  - No se deben declarar en la firma del método
    + Tampoco se requieren de capturar explícitamente en un bloque `try` / `catch`
  - Casos:
    + Excepciones de ejecución
    + Excepciones de la clase `RuntimeException`
  - Ejemplos:
    + `RuntimeException`
    + `NullPointerException`
    + `ArrayIndexOutOfBoundsException`
    + `ArithmeticException`

#### ¿Por qué estas excepciones no requieren de una comprobación?

Hipótesis: Java maneja estas excepciones automáticamente. Puede que no implemente la solución ideal, pero está garantizado que el flujo de la aplicación no se detendrá y no ocurrirá algún desbordamiento.

##### Entonces, ¿Por qué Java puede manejar de forma automática las unchecked y no las checked?

Hipótesis: En las ocasiones en que se intenta acceder a algo inexistente, Java podría estar asignando esas inexistencias a algo como `0` o `null`, y continuar con las operaciones del programa con aquellos valores. El programa no se desbordará.

#### La realidad

Estas excepciones no se manejan explícitamente porque son culpa del programador. Se deben a una falla en la lógica de programación.
Estas excepciones **no** se solucionan ni manejan automáticamente por Java. Al contrario; El programa se detiene   si una de estas excepciones ocurre para que no desemboque una monstruosidad.

### Excepciones que *sí* requieren de una comprobación - _checked exceptions_
  - Se deben declarar en la firma del método
    + O bien, Se deben capturar explícitamente en un bloque `try` / `catch`
  - Casos:
    + Aquellas que hereden de la clase `Exception`
    + Todas las demás
  - Ejemplos:
    + `IOException`
    + `FileNotFoundException`
    + `ParseException`
#### ¿Por qué las excepciones anteriores sí requiren de una comprobación?

Hipótesis: el programa está en riesgo de desbordarse si estas excepciones no son tratadas explícitamente en el código fuente. Si un archivo no se encuentra, Java no puede simplemente continuar con un valor nulo.

#### La realidad

Estas excepciones están fuera de las manos del programador. Son culpa del entorno. El programador debe prever estas excepciones y capturarlas en caso de que ocurran. Un archivo puede no encontrarse porque el almacenamiento no da para más, o el usuario simplemente lo eliminó, por ejemplo.

#### Errores

Heredan de la clase `Error` y son aquellas que requieren de una interrupción de ejecución y está fuera del control de aquel que ha programado la aplicación. **Son problemas irrecuperables en el entorno de ejecución**

### Tabla de Errores - clase `Error`

| Error  | Descripción |
| ------------- |:-------------:|
| ArithmeticError      | Error en un cálculo numérico; división entre 0     |
| ClassFormatError      | El archivo de una clase es inválido     |
| IncompatibleClassChangeError      | Cambio en una clase padre cuando una clase hija ya ha sido inicializada    |
| NoClassDefFoundError     | La clase no se encuentra al tiempo de la ejecución    |

### Tabla de Excepciones - clase `Exception`

| Error  | Descripción |
| ------------- |:-------------:|
| ArrayIndexOutOfBoundsException      | Se intenta acceder a un elemento fuera de los límites del vector    |
| ClassNotFoundException      | Se intenta acceder a una clase que no existe     |
| ConcurrentModificationException      | Un elemento se añade o elimina de un iterable     |
| FileNotFoundException     | Se intenta acceder a un archivo que no existe    |
| InputMismatchException     | Se intenta introducir un tipo de dato distinto al de una variable     |
| InterruptedException      | Un thread se interrumpe cuando este está durmiendo/esperando     |
| InvalidClassException      | El runtime de serialización observa un problema con una clase     |
| IOException      | Fallo en el input o en el output    |
| NegativeArraySizeException    | Se intenta crear un arreglo de dimensiones negativas     |
| NoSuchFieldException      | Intentar acceder al campo de una clase o variable que no existe    |
| NoSuchMethodException     | Se intenta acceder al método inexistente de una clase   |
| NullPointerException      | Se intenta acceder a un objeto cuyo puntero direcciona a `null`     |
| NumberFormatException / ParseException   | No se puede convertir un String a numérico    |
| RuntimeException      | Excepción en el Runtime; clase base para excepciones no comprobadas    |
| StringIndexOutOfBoundsException     | Se intenta acceder a un carácter inexistente en un String (como en un arreglo)    |
| TypeNotPresentException     | Un type no se puede encontrar     |
| IllegalArgumentException      | Se pasa un argumento ilegal a un método    |
| IllegalStateException    | Un método se invoca en un tiempo ilegal    |

### ¿Una operación puede arrojar múltiples excepciones?

Por ejemplo: ¿ArrayIndexOutOfBoundsException y StringOutOfBoundsException?

### ¿Cómo implementar una excepción?

Hay dos tipos: las checked y las unchecked. Como las unchecked simplemente le exigen al programador que corrija la lógica de su código, son las checked las únicas que se implementan realmente.

### (5.4.1) Manejo de excepciones _checked_

Hay dos caminos distintos para implementar excepciones checked.

#### En el bloque de código - Manejo interno; _Handle_

Esto implica que en algún punto del método habrá un bloque `try` / `catch`. Y que el argumento del catch debe de ser un objeto `e` del tipo de excepción que nuestro método arroja. En el ejemplo, _un objeto `e` de tipo `FileNotFoundException`_.

```java
try{

// Codigo que puede fallar

} catch (FileNotFoundException e){ // Captura de la excepcion que puede arrojar

// Codigo a realizar en caso de fallo

}
```

#### (5.3) En la firma del método - Declarar/Delegación en cadena; _Declare_


Declarar una excepción en la firma del método significa usar la palabra clave `throws` en la definición del método seguido por el tipo de excepción que el método podrá arrojar. Por ejemplo: un `FileNotFoundException`

```java
public void LeerArchivo() throws FileNotFoundException{ ... }

```

El método puede arrojar esta excepción, pero **aquel método invocador** va a ser quien se dé a la tarea de manejarla. Durante la invocación de este método es donde se tendrá que implementar un `try-catch`. El método se invoca en el bloque del `try`.

```java
try{
  LeerArchivo();
} catch (FileNotFoundException e){
  ...
}

```

Si el método _A_ invocador del método _B_ que utiliza el `throws` no maneja la excepción en un bloque `try-catch`, entonces **debe** trasladar esa responsabilidad a un método _C_ que invoque al método _A_. Esto se puede hacer sucesivamente hasta que, finalmente, un método--puede ser incluso el `main`-- maneje la excepción.

El método _A_, entonces, debe utilizar también el `throws` con el mismo tipo de excepción que _B_ para deslindarse de esa responsabilidad. _C_ puede manejar dicha excepción en un `try-catch`, o puede usar el `throws` en la firma de su método para agregar esa excepción a una ***Pila de llamadas / Call Stack***

```java
public void leerArchivo() throws FileNotFoundException{ ... } // => B; B no se hace cargo de la excepcion

public void procesarInformacion() throws FileNotFoundException{ // => A; A tampoco se hace cargo
  leerArchivo();
}

public static void main(String[] a){ // => C; C se hace cargo de la excepcion
  try{
    procesarInformacion();
  } catch (FileNotFoundException e){
    ...
  }
}

```

### (5.5) Crear una excepcion personalizada

Podemos crear una clase que herede, por ejemplo, de la clase `Exception`. Entonces, por definición habremos creado nuestra propia excepción.

```java
public class MiException() extends Exception{
  public MiException(
    String message,
    Throwable causa
  ){
    super(message, causa);
  }

}
```

Podemos capturarla,

```java
public static void main(String[] a){
  try{
    ...
  } catch(MiException e){
    ...
  }
}

```

en delegación en cadena también es posible,

```java

public void miMetodo() throws MiException{ ... }

public static void main(String[] a){
  try{
    miMetodo();
  } catch(MiException e){
    ...
  }
}

```

o bien, también es posible lanzarla

### (5.4.2) Lanzar excepciones

Usando la palabra clave `throw` es como podemos ordenar que se lance una excepción. 

Lo que hacemos es lanzar una instancia de una clase derivada de `Throwable`. Por ejemplo, `Exception` hereda de `Throwable`.

Como `MiException` hereda de `Exception`, entonces `MiException` es `Throwable`; se puede hacer `throw` con esta.

```java
if(!condicionEsVerdadera){
  throw new MiException("Condicion no cumplida");
}

```
