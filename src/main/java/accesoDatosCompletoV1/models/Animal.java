package accesoDatosCompletoV1.models;

public class Animal {

    private String nombre;
    private String especie;
    private int edad;
    private String color;
    private String habitat;

    public Animal(String nombre, String especie, int edad, String color, String habitat) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.color = color;
        this.habitat = habitat;
    }

    public Animal(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", color='" + color + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
