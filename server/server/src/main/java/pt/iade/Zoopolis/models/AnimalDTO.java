package pt.iade.Zoopolis.models;

public class AnimalDTO {
    private int id;
    private String name;
    private String ciName;
    private String description;
    private float weight;
    private float height;
    private float length;
    private Object classe; // Pode ser um objeto ou um Map
    private String imageUrl;

    // Construtor
    public AnimalDTO(int id, String name, String ciName, String description,
                     float weight, float height, float length, Object classe, String imageUrl) {
        this.id = id;
        this.name = name;
        this.ciName = ciName;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.classe = classe;
        this.imageUrl = imageUrl;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCiName() {
        return ciName;
    }

    public String getDescription() {
        return description;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    public Object getClasse() {
        return classe;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
