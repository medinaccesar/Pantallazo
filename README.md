# Pantallazo
[es] 
Genera una captura de pantalla en formato png, por defecto sin retardo, en el directorio actual y con la fecha como nombre. Admite opciones, ver ayuda.

[en] 
Generates a screenshot in png format, by default without delay, in the current directory and with the date as name. Supports options, see help.

# Requisitos previos  /  Pre-requisites
[es] 
Para compilar: Entorno de desarrollo de Java 1.7 o superior.

Para ejecutar: Entorno de ejecución de Java  1.7 o superior.

[en] 
To compile: Java Development Environment 1.7 or higher.

To run: Java Runtime Environment 1.7 or higher.

# Compilar  /  Compile 

javac -d ./build -cp src ./src/pantallazo/utilidades/Herramientas.java ./src/pantallazo/*.java

# Construir el ejecutable  / Build jar

jar cfm ./dist/Pantallazo.jar manifesto.txt -C ./build/ .

# Uso  /  Use

 java -jar Pantallazo.jar [-d \<ruta>] [-n \<nombre>]  [-nf] [-r \<retardo>]

 # Ayuda y ejemplos  /  Help

java -jar Pantallazo.jar -a

