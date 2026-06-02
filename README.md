# Flujos y archivos

## (6.1) Definición

Son canales de comunicación utilizados para leer y escribir datos desde y hacia fuentes como archivos o la memoria.

## (6.2) Clasificación - Tipos de flujos

### Flujos de bytes

Gestionan los datos brutos binarios. Utilizan las clases bases `InputStream` y `OutputStream`.

#### Binarios
Un binario es un ejecutable, un archivo de vídeo, audio, un redireccionador, etc; Cualquier archivo cuya fuente no pueda ser visualizada por un editor de texto.

Las clases derivadas más utilizadas para el manejo de binarios son `FileInputStream` (leer entrada) y `FileOutputStream` (escribir salida).

### Flujos de caracteres

Gestionan datos adaptándose a una codificación, como ASCII o UTF-8. Sus clases base son `Reader` y `Writer`. Estos flujos son los ideales para gestionar archivos de texto como `.json` o `.csv`.



#### Archivos de texto
Utilizan una codificación específica, y pueden ser abiertos por un editor de texto. (No confundirse con un procesador de textos).

También se puede utilizar `BufferedReader` y `BufferedWriter` para leer estos archivos.

Otras opciones son `Scanner`

## (6.3) Operaciones básicas y tipos de acceso

https://www.w3schools.com/java/java_files.asp

Leer hasta I/O

## (6.4) Manejo de objetos persistentes

Alchile eso creo que ya ni va a venir
