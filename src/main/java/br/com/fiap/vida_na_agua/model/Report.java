package br.com.fiap.vida_na_agua.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
public class Report {

    @Id
    private ObjectId _id;

    private String name;
    private String state;
    private int year;
    private Condition condition;

    public Report () {}

    public Report(ObjectId id, String name, String state, int year, Condition condition) {
        this._id = id;
        this.name = name;
        this.state = state;
        this.year = year;
        this.condition = condition;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
