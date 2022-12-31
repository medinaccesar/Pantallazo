# Pantallazo
Genera una captura de pantalla con comandos.

# Prerrequisitos
Para compilar: Entorno de desarrollo de Java 1.7 o superior.
Para ejecutar: Entorno de ejecución de Java  1.7 o superior.

# Compilar

javac -d ./build -cp src ./src/pantallazo/utilidades/Herramientas.java ./src/pantallazo/*.java

# Construir el ejecutable

jar cfm ./dist/Pantallazo.jar manifesto.txt -C ./build/ .

# Uso

 java -jar Pantallazo.jar [-d <ruta>] [-n <nombre>]  [-nf] [-r <retardo>]

 # Ayuda y ejemplos

java -jar Pantallazo.jar -a

