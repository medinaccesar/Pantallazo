# Pantallazo
Genera una captura de pantalla por comandos.

# Prerrequisitos
Para compilar Entorno de desarrollo de java 1.6 o superior.
Para ejecutar Entorno de ejecución Java versión 1.6 o superior.

# Compilar

javac -d ./build -cp src    ./src/pantallazo/utilidades/Herramientas.java ./src/pantallazo/*.java

# Construir el ejecutable

jar cfm ./dist/Pantallazo.jar manifesto.txt -C ./build/ .


# Ejecutar

java -jar Pantallazo.jar
