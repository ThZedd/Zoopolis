package pt.iade.Zoopolis.models;

public class AnimalDTO {
    private int id;
    private String name;
    private String ciName;
    private String description;

    // Construtor
    public AnimalDTO(int id, String name, String ciName, String description) {
        this.id = id;
        this.name = name;
        this.ciName = ciName;
        this.description = description;
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
}

