package estructuras;

public class DefensorEternia {

    private int id;
    private String nombre;
    private String habilidadEspecial;
    private int nivelPoder;
    private String region;

    public DefensorEternia(int id, String nombre, String habilidadEspecial, int nivelPoder, String region) {
        this.id = id;
        this.nombre = nombre;
        this.habilidadEspecial = habilidadEspecial;
        this.nivelPoder = nivelPoder;
        this.region = region;
    }

    public DefensorEternia() {}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegion() {
        return region;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }
}
